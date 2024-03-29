package cyclic.lang.compiler.model;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.problems.CompileTimeException;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A reference to an instance of an annotation on an annotatable element, consisting of a reference to an annotation type,
 * the parameters of that type, the arguments to the annotation's constructor, and the element this annotates.
 * <p>
 * {@linkplain Enum} values are stored as {@linkplain EnumConstant}s, {@linkplain Class} values are stored as {@linkplain TypeReference}s, and
 * {@linkplain Annotation} values are stored as {@linkplain AnnotationTag}s, so that no uncompiled or external code needs to be loaded.
 *
 * @see AnnotationParam
 * @see AnnotatableElement#annotations()
 */
public record AnnotationTag(TypeReference annotationType, Map<String, AnnotationParam> parameters, Map<String, Object> arguments, @Nullable AnnotatableElement on){
	
	/**
	 * An element of an annotation type.
	 *
	 * @see AnnotationTag
	 */
	record AnnotationParam(String name, TypeReference type, Object defaultValue){}
	
	public AnnotationTag{
		if(arguments.values().stream().anyMatch(Flow.NULL_MARKER::equals))
			throw new IllegalStateException("Annotation " + annotationType.fullyQualifiedName() + " on " + on + " cannot accept null value");
	}
	
	public static AnnotationTag fromAnnotation(Annotation annotation, AnnotatableElement on){
		Class<? extends Annotation> annoType = annotation.annotationType();
		var params = Arrays
				.stream(annoType.getDeclaredMethods())
				.filter(x -> x.getReturnType() != void.class)
				.collect(Collectors.toMap(Method::getName,
						method -> new AnnotationParam(method.getName(), TypeResolver.resolveFq(method.getReturnType().getCanonicalName()), clean(method.getDefaultValue(), on)), (a, b) -> b));
		return new AnnotationTag(Utils.forAnyClass(annoType), params, args(annotation, on, params), on);
	}
	
	public static AnnotationTag fromAst(CyclicLangParser.AnnotationContext ctx, AnnotatableElement on, CyclicType type){
		String name = ctx.id().getText();
		TypeReference ref = type != null ? TypeResolver.resolve(name, type.imports, type.packageName()) : TypeResolver.resolveFq(name);
		var params = ref
				.methods()
				.stream()
				.filter(x -> x.returns() != null && !Objects.equals(x.returns().fullyQualifiedName(), "void"))
				.filter(k -> k.in().fullyQualifiedName().equals(ref.fullyQualifiedName()))
				.collect(Collectors.toMap(MethodReference::name, k -> new AnnotationParam(k.name(), k.returns(), k.defaultValueForAnnotation())));
		Map<String, Object> args = new HashMap<>();
		if(ctx.value() != null){
			Value value = Value.fromAst(ctx.value(), new Scope(), type, null);
			var constant = Flow.constantValue(value);
			args.put("value", constant.orElseThrow(() -> new CompileTimeException(value.getText(), "Annotation value must be a compile-time constant")));
		}else if(ctx.annotationArg().size() > 0)
			for(CyclicLangParser.AnnotationArgContext context : ctx.annotationArg()){
				Value value = Value.fromAst(context.value(), new Scope(), type, null);
				var constant = Flow.constantValue(value);
				String argName = context.idPart().getText();
				args.put(argName, constant.orElseThrow(() -> new CompileTimeException(value.getText(), "Annotation value \"" + argName + "\" must be a compile-time constant")));
			}
		return new AnnotationTag(ref, params, args, on);
	}
	
	private static Map<String, Object> args(Annotation annotation, AnnotatableElement on, Map<String, AnnotationParam> params){
		var ret = new HashMap<String, Object>();
		params.forEach((name, param) -> {
			try{
				Object value = annotation.annotationType().getMethod(name).invoke(annotation);
				value = clean(value, on);
				ret.put(name, value);
			}catch(IllegalAccessException | InvocationTargetException | NoSuchMethodException e){
				throw new CompileTimeException(null, "Could not get parameter of annotation usage: " + e);
			}
		});
		return ret;
	}
	
	/**
	 * Changes an Object value into a type that can be handled by {@linkplain AnnotationTag}.
	 * <p>{@linkplain Class} values become {@linkplain TypeReference}s, {@linkplain Enum} constants become {@linkplain EnumConstant}s,
	 * {@linkplain Annotation} values become {@linkplain AnnotationTag}s, and primitive values become their wrapper types.
	 *
	 * @return A representation of the value that can be handled by {@linkplain AnnotationTag}.
	 */
	public static Object clean(Object value, @Nullable AnnotatableElement on){
		if(value == null)
			return null;
		if(value instanceof Enum<?> v){
			var type = Utils.forAnyClass(v.getDeclaringClass());
			return new EnumConstant(type, v.name());
		}
		if(value instanceof Class<?> c)
			return Utils.forAnyClass(c);
		if(value instanceof Annotation a)
			return fromAnnotation(a, on);
		if(value.getClass().isArray()){
			// could this be a primitive array?
			Object[] val = (Object[])value;
			return Arrays.stream(val).map(k -> clean(k, on)).toArray();
		}
		return value; // primitive values are boxed when passed in
	}
	
	public boolean isRepeatable(){
		return annotationType().annotations().stream().anyMatch(k -> k.annotationType().fullyQualifiedName().equals(Constants.REPEATABLE));
	}
	
	public Optional<TypeReference> repeatContainer(AnnotatableElement e){
		Optional<AnnotationTag> first = annotationType().annotations().stream().filter(k -> k.annotationType().fullyQualifiedName().equals(Constants.REPEATABLE)).findFirst();
		if(first.isEmpty())
			return Optional.empty();
		TypeReference targets = (TypeReference)first.get().arguments.get("value");
		return Optional.ofNullable(targets);
	}
	
	public boolean isApplicable(String elementType){
		Optional<AnnotationTag> first = annotationType().annotations().stream().filter(k -> k.annotationType().fullyQualifiedName().equals(Constants.TARGET)).findFirst();
		if(first.isEmpty())
			return true;
		// can't cast directly to a specific array because clean() cannot determine the correct type in all circumstances
		Object[] targets = (Object[])first.get().arguments.get("value");
		return Arrays.stream(targets).anyMatch(k -> k != null && ((EnumConstant)k).name().equals(elementType));
	}
	
	public boolean isApplicable(AnnotatableElement e){
		return isApplicable(e.elementType());
	}
	
	public RetentionPolicy retention(){
		Optional<AnnotationTag> first = annotationType().annotations().stream().filter(k -> k.annotationType().fullyQualifiedName().equals(Constants.RETENTION)).findFirst();
		if(first.isEmpty())
			return RetentionPolicy.CLASS;
		EnumConstant policy = (EnumConstant)first.get().arguments.get("value");
		if(policy == null)
			return RetentionPolicy.SOURCE;
		return RetentionPolicy.valueOf(policy.name());
	}
}