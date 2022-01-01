package cyclic.lang.compiler.model;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.instructions.Scope;
import cyclic.lang.compiler.model.instructions.Value;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
	
	public static AnnotationTag fromAnnotation(Annotation annotation, AnnotatableElement on){
		Class<? extends Annotation> annoType = annotation.annotationType();
		var params = Arrays
				.stream(annoType.getDeclaredMethods())
				.collect(Collectors.toMap(Method::getName,
						method -> new AnnotationParam(method.getName(), TypeResolver.resolve(method.getReturnType().getCanonicalName()), clean(method.getDefaultValue(), on)), (a, b) -> b));
		return new AnnotationTag(Utils.forAnyClass(annoType), params, args(annotation, on, params), on);
	}
	
	public static AnnotationTag fromAst(CyclicLangParser.AnnotationContext ctx, AnnotatableElement on, CyclicType type){
		String name = ctx.id().getText();
		TypeReference ref = type != null ? TypeResolver.resolve(name, type.imports, type.packageName()) : TypeResolver.resolve(name);
		var params = ref
				.methods()
				.stream()
				.filter(k -> k.in().fullyQualifiedName().equals(ref.fullyQualifiedName()))
				.collect(Collectors.toMap(MethodReference::name, k -> new AnnotationParam(k.name(), k.returns(), k.defaultValueForAnnotation())));
		Map<String, Object> args = new HashMap<>();
		if(ctx.value() != null){
			Value value = Value.fromAst(ctx.value(), new Scope(), type, null);
			var constant = Guaranteed.constant(value);
			args.put("value", constant.orElseThrow(() -> new CompileTimeException(null, "Annotation value must be a compile-time constant")));
		}else if(ctx.annotationArg().size() > 0)
			for(CyclicLangParser.AnnotationArgContext context : ctx.annotationArg()){
				Value value = Value.fromAst(context.value(), new Scope(), type, null);
				var constant = Guaranteed.constant(value);
				String argName = context.idPart().getText();
				args.put(argName, constant.orElseThrow(() -> new CompileTimeException(null, "Annotation value " + argName + " must be a compile-time constant")));
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
	 * @return A representation of the value that can be handled by {@linkplain AnnotationTag}.
	 */
	public static Object clean(Object value, @Nullable AnnotatableElement on){
		if(value instanceof Enum<?> v){
			var type = Utils.forAnyClass(v.getDeclaringClass());
			return new EnumConstant(type, v.name());
		}
		if(value instanceof Class<?> c)
			return Utils.forAnyClass(c);
		if(value instanceof Annotation a)
			return fromAnnotation(a, on);
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
		return Optional.of(targets);
	}
	
	public boolean isApplicable(AnnotatableElement e){
		Optional<AnnotationTag> first = annotationType().annotations().stream().filter(k -> k.annotationType().fullyQualifiedName().equals(Constants.TARGET)).findFirst();
		if(first.isEmpty())
			return true;
		EnumConstant[] targets = (EnumConstant[])first.get().arguments.get("value");
		return Arrays.stream(targets).anyMatch(k -> k.name().equals(e.elementType()));
	}
	
	public RetentionPolicy retention(){
		Optional<AnnotationTag> first = annotationType().annotations().stream().filter(k -> k.annotationType().fullyQualifiedName().equals(Constants.RETENTION)).findFirst();
		if(first.isEmpty())
			return RetentionPolicy.CLASS;
		EnumConstant policy = (EnumConstant)first.get().arguments.get("value");
		return RetentionPolicy.valueOf(policy.name());
	}
}