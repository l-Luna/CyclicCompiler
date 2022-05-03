package cyclic.lang.compiler.model.instructions;

import cyclic.lang.antlr_generated.CyclicLangParser;
import cyclic.lang.compiler.CompileTimeException;
import cyclic.lang.compiler.CompilerLauncher;
import cyclic.lang.compiler.Constants;
import cyclic.lang.compiler.configuration.dependencies.PlatformDependency;
import cyclic.lang.compiler.gen.Operations;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.*;
import cyclic.lang.compiler.model.cyclic.CyclicType;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;
import cyclic.lang.compiler.resolve.TypeResolver;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Value{
	
	protected ParserRuleContext text;
	
	public static Value fromAst(CyclicLangParser.ValueContext ctx, Scope scope, CyclicType type, @Nullable CallableReference method){
		CompileTimeException.pushContext(ctx);
		
		Value result = switch(ctx){
			case CyclicLangParser.NullLitContext ignored -> new NullLiteralValue();
			case CyclicLangParser.BoolLitContext boolLit -> new IntLiteralValue(boolLit.getText().equals("true") ? 1 : 0, true);
			case CyclicLangParser.StrLitContext strLit -> new StringLiteralValue(strLit.getText().substring(1, strLit.getText().length() - 1));
			case CyclicLangParser.ParenValueContext paren -> fromAst(paren.value(), scope, type, method);
			case CyclicLangParser.ArrayIndexValueContext ind -> new ArrayIndexValue(fromAst(ind.array, scope, type, method), fromAst(ind.index, scope, type, method));
			case CyclicLangParser.PrimitiveClassValueContext prim -> new PrimitiveClassValue(PrimitiveTypeRef.getPrimitiveDesc(prim.primitiveType().getText()));
			case CyclicLangParser.PrefixOpValueContext preOp -> Operations.resolvePrefix(preOp.prefixop().getText(), fromAst(preOp.value(), scope, type, method));
			case CyclicLangParser.PostfixOpValueContext postOp -> Operations.resolvePostfix(postOp.postfixop().getText(), fromAst(postOp.value(), scope, type, method));
			
			case CyclicLangParser.InlineAssignValueContext ia -> {
				Value toAssign = fromAst(ia.left, scope, type, method);
				Value newValue = fromAst(ia.right, scope, type, method);
				if(ia.binaryop() != null)
					newValue = Operations.resolveBinary(ia.binaryop().getText(), toAssign, newValue, null);
				yield createInlineAssignValue(toAssign, newValue);
			}
			case CyclicLangParser.IntLitContext intLit -> {
				String text = intLit.INTLIT().getText();
				if(text.endsWith("f"))
					yield new FloatLiteralValue(Float.parseFloat(text));
				else if(text.endsWith("d"))
					yield new DoubleLiteralValue(Double.parseDouble(text));
				else
					yield new IntLiteralValue(Integer.parseInt(text));
			}
			case CyclicLangParser.DecLitContext decLit -> {
				String text = decLit.DECLIT().getText();
				if(text.endsWith("f"))
					yield new FloatLiteralValue(Float.parseFloat(text));
				else
					yield new DoubleLiteralValue(Double.parseDouble(text));
			}
			case CyclicLangParser.VarValueContext val -> {
				String name = val.idPart().getText();
				// if a value is present, check if it's a partial type name, and add to it if so; otherwise return a field
				if(val.value() != null){
					Value on = fromAst(val.value(), scope, type, method);
					if(on instanceof TypeValue v && v.getPartialTypeName() != null){
						var newTypeName = v.getPartialTypeName() + "." + name;
						var target = TypeResolver.resolveOptional(newTypeName, type.imports, type.packageName());
						yield target.map(TypeValue::new).orElseGet(() -> new TypeValue(newTypeName));
					}else
						yield new FieldValue(name, on, method, type);
				}else{// otherwise, it could be a local variable,
					Variable local = scope.get(name);
					if(local != null)
						yield new LocalVarValue(local);
					else{// or a static field of the current type, or an instance field of the current type for a non-static method
						if(method != null)
							for(var field : method.in().fields())
								if(field.name().equals(name) && (field.isStatic() || !method.isStatic()))
									yield new FieldValue(field);
						// or a partial or full type name
						var target = TypeResolver.resolveOptional(name, type.imports, type.packageName());
						yield target.map(TypeValue::new).orElseGet(() -> new TypeValue(name));
					}
				}
			}
			case CyclicLangParser.FunctionValueContext func -> {
				Value on = func.value() != null ? Value.fromAst(func.value(), scope, type, method) : null;
				boolean isSuperCall = func.SUPER() != null;
				List<Value> args = func.call().arguments().value().stream().map(x -> Value.fromAst(x, scope, type, method)).toList();
				// TODO: "X.super.Y()" for interface methods? maybe "X:super.Y()"?
				var funcName = func.call().idPart().getText();
				yield new CallValue(on, args, Utils.resolveMethod(funcName, on, args, method, isSuperCall), isSuperCall, funcName, method);
			}
			case CyclicLangParser.InitialisationValueContext init -> {
				List<Value> args = init.initialisation().arguments().value().stream().map(x -> Value.fromAst(x, scope, type, method)).toList();
				TypeReference of = TypeResolver.resolve(init.initialisation().type(), type.imports, type.packageName());
				CallableReference target = Utils.resolveConstructor(of, args, method);
				// pass expressions won't save you here, safe to eagerly throw
				if(target != null){
					if(target.in().kind() == TypeKind.ENUM)
						throw new CompileTimeException("Can't manually call enum constructors");
					if(target.in().kind() == TypeKind.SINGLE)
						throw new CompileTimeException("Can't manually call single-type constructors");
				}
				yield new InitializationValue(args, target, of, method);
			}
			case CyclicLangParser.BinaryOpValueContext bin -> {
				Value left = Value.fromAst(bin.left, scope, type, method);
				Value right = Value.fromAst(bin.right, scope, type, method);
				yield Operations.resolveBinary(bin.binaryop().getText(), left, right, bin);
			}
			case CyclicLangParser.ThisValueContext ignored -> {
				if(method == null)
					throw new CompileTimeException("Can't use \"this\" outside of methods");
				if(method.isStatic())
					throw new CompileTimeException("Can't use \"this\" in a static method");
				yield new ThisValue(method.in());
			}
			case CyclicLangParser.ClassValueContext clss -> {
				// TODO: generics
				TypeReference target = TypeResolver.resolve(clss.id().getText(), type.imports, type.packageName());
				if(!Visibility.visibleFrom(target, method != null ? method : type))
					throw new CompileTimeException("Target type is not accessible from here");
				yield new ClassValue(target);
			}
			case CyclicLangParser.InstanceCheckValueContext inst -> {
				var check = new InstanceofValue(TypeResolver.resolve(inst.type(), type.imports, type.packageName()), fromAst(inst.value(), scope, type, method));
				yield inst.EXCLAMATION() == null ? check : new Operations.BranchBoolBinaryOpValue(Opcodes.IFEQ, check, null);
			}
			case CyclicLangParser.CastValueContext castCtx -> {
				String typeName = TypeResolver.getBaseName(castCtx.cast().type());
				if(typeName.equals("var") || typeName.equals("val"))
					throw new CompileTimeException("Cannot infer type of cast");
				TypeReference target = TypeResolver.resolve(castCtx.cast().type(), type.imports, type.packageName());
				if(!Visibility.visibleFrom(target, method != null ? method : type))
					throw new CompileTimeException("Target of cast is not visible here");
				Value casting = fromAst(castCtx.cast().value(), scope, type, method);
				// if it fits, just pass it along
				var fit = casting.fit(target);
				if(fit != null){
					yield new SubstituteTypeValue(target, fit);
				}else if(target instanceof PrimitiveTypeRef p){
					if(p.type == PrimitiveTypeRef.Primitive.NULL)
						yield casting;
					else if(casting.type() instanceof PrimitiveTypeRef c){
						if(c.narrowingOpcodes(p.type) == null)
							throw new CompileTimeException("Cannot convert value of type " + c.fullyQualifiedName() + " to " + p.fullyQualifiedName());
						else
							yield new PrimitiveCastValue(casting, p.type);
					}else
						throw new CompileTimeException("Cannot convert non-primitive value of type " + casting.type().fullyQualifiedName() + " to primitive type " + p.fullyQualifiedName());
				}else if(casting.type() instanceof PrimitiveTypeRef p)
					throw new CompileTimeException("Cannot convert primitive value of type " + p.fullyQualifiedName() + " to non-primitive type " + target.fullyQualifiedName());
				else
					yield new ClassCastValue(casting, target);
			}
			case CyclicLangParser.NewArrayValueContext array -> {
				TypeReference component = TypeResolver.resolve(array.newArray().type(), type.imports, type.packageName());
				Value length = fromAst(array.newArray().value(), scope, type, method);
				if(component instanceof PrimitiveTypeRef p)
					yield new NewPrimitiveArrayValue(p, length);
				else
					yield new NewArrayValue(component, length);
			}
			case CyclicLangParser.NewListedArrayValueContext array -> {
				TypeReference component = TypeResolver.resolve(array.newListedArray().type(), type.imports, type.packageName());
				List<Value> entries = array.newListedArray().value().stream().map(k -> fromAst(k, scope, type, method)).toList();
				yield new NewListedArrayValue(entries, component);
			}
			case null, default -> null;
		};
		
		CompileTimeException.popContext();
		if(result != null)
			result.text = ctx;
		return result;
	}
	
	@NotNull
	public static InlineAssignValue createInlineAssignValue(Value toAssign, Value newValue){
		return switch(toAssign){
			case LocalVarValue lvv -> new InlineAssignValue(newValue, lvv.localIdx);
			case FieldValue fv -> new InlineAssignValue(newValue, fv.from, fv.ref);
			case ArrayIndexValue aiv -> new InlineAssignValue(newValue, aiv.array, aiv.index);
			case default -> throw new CompileTimeException("Can't assign value to " + toAssign);
		};
	}
	
	/**
	 * Returns a value equivalent to this value of the target type,
	 * or null if no conversion exists between this type and the target.
	 * May return the same value.
	 *
	 * @param target
	 * 		The target type to convert to
	 * @return An equivalent to this as the target, or null.
	 */
	public Value fit(TypeReference target){
		if(type().isAssignableTo(target))
			return this;
		
		Value ret = null;
		// unboxing conversion
		if(target instanceof PrimitiveTypeRef prim)
			if(type().fullyQualifiedName().equals(prim.boxedTypeName()))
				ret = new UnboxValue(this, prim.type);
		
		if(type() instanceof PrimitiveTypeRef p){
			// boxing conversion
			if(p.boxedType().isAssignableTo(target) && p.type != PrimitiveTypeRef.Primitive.NULL && p.type != PrimitiveTypeRef.Primitive.VOID)
				ret = new BoxValue(this, p.boxedType());
			// widening conversion
			if(target instanceof PrimitiveTypeRef to && to.type != p.type){
				int op = p.wideningOpcode(to.type);
				if(op == 0)
					ret = new SubstituteTypeValue(target, this);
				else if(op != -1)
					ret = new Operations.UnaryOpValue(to, this, op);
			}
		}
		
		// allows for multi-step conversions
		return ret != null ? ret.fit(target) : null;
	}
	
	public void write(MethodVisitor mv){
	}
	
	public void simplify(Statement in){
		// evaluate constant expressions...
	}
	
	public String toString(){
		return text != null ? Utils.format(text) : "<generated: " + getClass().getSimpleName() + ">";
	}
	
	public abstract TypeReference type();
	
	public static class NullLiteralValue extends Value{
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.NULL);
		}
		
		public void write(MethodVisitor mv){
			mv.visitInsn(Opcodes.ACONST_NULL);
		}
		
		public String toString(){
			return "null";
		}
	}
	
	// TODO: combine primitive literal values?
	public static class IntLiteralValue extends Value{
		public int value;
		public boolean isBool = false;
		
		public IntLiteralValue(int value){
			this.value = value;
		}
		
		public IntLiteralValue(int value, boolean isBool){
			this.value = value;
			this.isBool = isBool;
		}
		
		public void write(MethodVisitor mv){
			if(value >= -1 && value <= 5)
				mv.visitInsn(switch(value){
					case -1 -> Opcodes.ICONST_M1;
					case 0 -> Opcodes.ICONST_0;
					case 1 -> Opcodes.ICONST_1;
					case 2 -> Opcodes.ICONST_2;
					case 3 -> Opcodes.ICONST_3;
					case 4 -> Opcodes.ICONST_4;
					case 5 -> Opcodes.ICONST_5;
					default -> throw new IllegalStateException("Unexpected value: " + value);
				});
			else if(value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE)
				mv.visitIntInsn(Opcodes.BIPUSH, value);
			else if(value >= Short.MIN_VALUE && value <= Short.MAX_VALUE)
				mv.visitIntInsn(Opcodes.SIPUSH, value);
			else
				mv.visitLdcInsn(value);
		}
		
		public Value fit(TypeReference target){
			var s = super.fit(target);
			if(s != null)
				return s;
			// TODO: error if the value is out of range
			if(!isBool && target instanceof PrimitiveTypeRef pref){
				if(pref.type == PrimitiveTypeRef.Primitive.SHORT)
					return new SubstituteTypeValue(PlatformDependency.SHORT, this);
				if(pref.type == PrimitiveTypeRef.Primitive.BYTE)
					return new SubstituteTypeValue(PlatformDependency.BYTE, this);
			}
			return null;
		}
		
		public TypeReference type(){
			return isBool ? new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.BOOLEAN) : new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.INT);
		}
		
		public String toString(){
			return isBool ? (value == 1 ? "true" : "false") : String.valueOf(value);
		}
	}
	
	public static class FloatLiteralValue extends Value{
		
		public float value;
		
		public FloatLiteralValue(float value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value == 0)
				mv.visitInsn(Opcodes.FCONST_0);
			else if(value == 1)
				mv.visitInsn(Opcodes.FCONST_1);
			else if(value == 2)
				mv.visitInsn(Opcodes.FCONST_2);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.FLOAT);
		}
	}
	
	public static class DoubleLiteralValue extends Value{
		
		public double value;
		
		public DoubleLiteralValue(double value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value == 0)
				mv.visitInsn(Opcodes.DCONST_0);
			else if(value == 1)
				mv.visitInsn(Opcodes.DCONST_1);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.DOUBLE);
		}
	}
	
	public static class LongLiteralValue extends Value{
		
		public long value;
		
		public LongLiteralValue(long value){
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			if(value == 0)
				mv.visitInsn(Opcodes.LCONST_0);
			else if(value == 1)
				mv.visitInsn(Opcodes.LCONST_1);
			else
				mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.LONG);
		}
	}
	
	public static class StringLiteralValue extends Value{
		
		public String value;
		
		public StringLiteralValue(String value){
			// TODO: all escape codes
			value = value.replace("\\\"", "\"");
			value = value.replace("\\n", "\n");
			
			this.value = value;
		}
		
		public void write(MethodVisitor mv){
			mv.visitLdcInsn(value);
		}
		
		public TypeReference type(){
			return TypeResolver.resolveFq(Constants.STRING);
		}
	}
	
	/**
	 * If the target is a single-type, this is the single value of that type.
	 * Otherwise, it simply provides static members.
	 */
	public static class TypeValue extends Value{
		TypeReference target;
		String partialTypeName = null;
		
		public TypeValue(TypeReference target){
			this.target = target;
		}
		
		public TypeValue(String partialTypeName){
			this.partialTypeName = partialTypeName;
		}
		
		public String getPartialTypeName(){
			return partialTypeName;
		}
		
		public void write(MethodVisitor mv){
			// write singleton types
			if(target.kind() == TypeKind.SINGLE)
				mv.visitFieldInsn(Opcodes.GETSTATIC, target.internalName(), "INSTANCE", "L" + target.internalName() + ";");
		}
		
		public TypeReference type(){
			if(target == null)
				throw new CompileTimeException(text, "Invalid reference; there is no such variable or type \"" + getPartialTypeName() + "\", nor are there any types that correspond to parts of that name");
			return target;
		}
	}
	
	public static class FieldValue extends Value{
		String fieldName;
		Value from;
		
		public FieldReference ref;
		
		public FieldValue(String fieldName, Value from, @Nullable CallableReference method, @NotNull TypeReference mIn){
			this.fieldName = fieldName;
			this.from = from;
			ref = from.type().fields().stream()
					.filter(x -> x.name().equals(fieldName))
					.filter(x -> Visibility.visibleFrom(x, method == null ? mIn : method))
					.findFirst()
					.orElseThrow(() -> new CompileTimeException(text, "Could not find visible field of name " + fieldName + " in type " + from.type().fullyQualifiedName() + "!"));
		}
		
		public FieldValue(FieldReference ref){
			this.ref = ref;
		}
		
		public FieldValue(FieldReference ref, Value from){
			this.ref = ref;
			this.from = from;
		}
		
		public void write(MethodVisitor mv){
			if(!ref.isStatic()){
				if(from != null)
					from.write(mv);
				else
					mv.visitVarInsn(Opcodes.ALOAD, 0);
			}
			ref.writeFetch(mv);
		}
		
		public void simplify(Statement in){
			if(from != null)
				from.simplify(in);
		}
		
		public TypeReference type(){
			return ref.type();
		}
	}
	
	public static class LocalVarValue extends Value{
		String localName;
		int localIdx;
		TypeReference type;
		
		// for computing range of local variable
		Variable variable;
		
		public LocalVarValue(Variable local){
			localName = local.name;
			localIdx = local.getAdjIndex();
			type = local.type;
			variable = local;
		}
		
		// for some generated members
		public LocalVarValue(TypeReference type, int localIdx){
			this.localIdx = localIdx;
			this.type = type;
		}
		
		public void write(MethodVisitor mv){
			mv.visitVarInsn(type().localLoadOpcode(), localIdx);
			
			// end range is exclusive, so attach to next instruction
			if(CompilerLauncher.project.includeCyclicLibRefs && variable != null){
				Label label = new Label();
				mv.visitLabel(label);
				if(variable.end == null || variable.end.getOffset() < label.getOffset())
					variable.end = label;
			}
		}
		
		public TypeReference type(){
			return type;
		}
		
		public void simplify(Statement in){
			if(Utils.maxMethodParameterLocalIndex(in.from) <= localIdx)
				if(Flow.minOccurrencesBefore(in.from.getBody(), in, Flow.willAssignToIndex(localIdx).or(Flow.WILL_EXIT), false) <= 0)
					throw new CompileTimeException(in.text, "Local variable \"" + localName + "\" must be assigned to before it is used");
		}
	}
	
	public static class CallValue extends Value{
		public Value on;
		public List<Value> args;
		public MethodReference target;
		// must be tracked here for using invokespecial
		public boolean isSuperCall = false;
		
		// for pass expressions
		public String name;
		public CallableReference method;
		
		public CallValue(Value on, List<Value> args, MethodReference target){
			this.on = on;
			this.args = args;
			this.target = target;
		}
		
		public CallValue(Value on, List<Value> args, MethodReference target, boolean isSuperCall, String name, CallableReference method){
			this.on = on;
			this.args = args;
			this.target = target;
			this.isSuperCall = isSuperCall;
			this.name = name;
			this.method = method;
		}
		
		// make sure that changes here are mirrored in InitializationValue
		// and CallStatement
		public void write(MethodVisitor mv){
			if(!target.isStatic()){
				if(on != null)
					on.write(mv);
					// implicit this for instance method calls with no explicit value
				else
					mv.visitVarInsn(Opcodes.ALOAD, 0);
			}
			// for varargs methods, all extra parameters are stuffed into an array
			if(target.isVarargs()){
				args = new ArrayList<>(args);
				ArrayTypeRef varParam = (ArrayTypeRef)target.parameters().get(target.parameters().size() - 1);
				if(args.size() == target.parameters().size()){
					// if the last argument is not a (the right kind of) array, it also needs boxing
					if(args.get(args.size() - 1).fit(varParam) == null)
						args.set(args.size() - 1, new NewListedArrayValue(List.of(args.get(args.size() - 1)), varParam.getComponent()));
				}else{
					int length = args.size() - target.parameters().size() + 1;
					var newEntries = new ArrayList<Value>(length);
					for(int i = 0; i < length; i++){
						newEntries.add(0, args.get(args.size() - 1));
						args.remove(args.size() - 1);
					}
					args.add(new NewListedArrayValue(newEntries, varParam.getComponent()));
				}
			}
			for(int i = 0; i < args.size(); i++){
				Value v = args.get(i);
				v.fit(target.parameters().get(i)).write(mv);
			}
			if(isSuperCall)
				target.writeInvokeSpecial(mv);
			else
				target.writeInvoke(mv);
		}
		
		public void simplify(Statement in){
			if(target == null)
				throw new CompileTimeException(text, "Could not find method " + name + " for args of types " + args.stream().map(Value::type).map(TypeReference::fullyQualifiedName).collect(Collectors.joining(", ", "[", "]")));
			if(on != null)
				on.simplify(in);
			args.forEach(value -> value.simplify(in));
		}
		
		public TypeReference type(){
			return target.returns();
		}
		
		public String toString(){
			return text != null ? super.toString() :
					(on != null ? on + "." : "") + target.name() + "(" + args.stream().map(Value::toString).collect(Collectors.joining(", ")) + ")";
		}
	}
	
	// could just use call values
	public static class UnboxValue extends Value{
		Value underlying;
		PrimitiveTypeRef.Primitive type;
		
		public UnboxValue(Value underlying, PrimitiveTypeRef.Primitive type){
			this.underlying = underlying;
			this.type = type;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv); // is a boxed value
			mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, underlying.type().internalName(), type.name().toLowerCase() + "Value", "()" + PrimitiveTypeRef.getPrimitiveDesc(type), false);
		}
		
		public void simplify(Statement in){
			underlying.simplify(in);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(type);
		}
	}
	
	public static class BoxValue extends Value{
		Value underlying;
		TypeReference targetType; // e.g. java.lang.Integer
		
		public BoxValue(Value underlying, TypeReference targetType){
			this.underlying = underlying;
			this.targetType = targetType;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv);
			mv.visitMethodInsn(Opcodes.INVOKESTATIC, targetType.internalName(), "valueOf", "(" + underlying.type().descriptor() + ")" + targetType.descriptor(), false);
		}
		
		public void simplify(Statement in){
			underlying.simplify(in);
		}
		
		public TypeReference type(){
			return targetType;
		}
	}
	
	public static class SubstituteTypeValue extends Value{
		TypeReference substitute;
		Value underlying;
		
		public SubstituteTypeValue(TypeReference substitute, Value underlying){
			this.substitute = substitute;
			this.underlying = underlying;
		}
		
		public void write(MethodVisitor mv){
			underlying.write(mv);
		}
		
		public void simplify(Statement in){
			underlying.simplify(in);
		}
		
		public TypeReference type(){
			return substitute;
		}
	}
	
	public static class ThisValue extends Value{
		TypeReference thisType;
		
		public ThisValue(TypeReference thisType){
			this.thisType = thisType;
		}
		
		public void write(MethodVisitor mv){
			mv.visitVarInsn(Opcodes.ALOAD, 0);
		}
		
		public TypeReference type(){
			return thisType;
		}
	}
	
	public static class InitializationValue extends Value{
		public List<Value> args;
		public CallableReference ctor;
		
		// for pass expressions
		public TypeReference of;
		public MemberReference from;
		
		public InitializationValue(List<Value> args, CallableReference ctor, TypeReference of, MemberReference from){
			this.args = args;
			this.ctor = ctor;
			this.of = of;
			this.from = from;
		}
		
		public void write(MethodVisitor mv){
			mv.visitTypeInsn(Opcodes.NEW, ctor.in().internalName());
			mv.visitInsn(Opcodes.DUP);
			for(int i = 0; i < args.size(); i++){
				Value v = args.get(i);
				v.fit(ctor.parameters().get(i)).write(mv);
			}
			ctor.writeInvoke(mv);
		}
		
		public void simplify(Statement in){
			if(ctor == null){
				String candidates = of.constructors().stream().map(CallableReference::summary).collect(Collectors.joining(", "));
				String types = args.stream().map(Value::type).map(TypeReference::fullyQualifiedName).collect(Collectors.joining(", "));
				throw new CompileTimeException(text, "Could not find constructor for type %s given candidates [%s] for args of types [%s]".formatted(of.fullyQualifiedName(), candidates, types));
			}
			args.forEach(value -> value.simplify(in));
		}
		
		public TypeReference type(){
			return of;
		}
	}
	
	public static class ClassValue extends Value{
		public TypeReference of;
		
		public ClassValue(TypeReference of){
			this.of = of;
		}
		
		public void write(MethodVisitor mv){
			mv.visitLdcInsn(Type.getType(of.descriptor()));
		}
		
		public TypeReference type(){
			// TODO: generics
			return TypeResolver.resolveFq(Constants.CLASS);
		}
	}
	
	public static class PrimitiveClassValue extends Value{
		private static final Handle PRIMITIVE_CLASS_HANDLE =
				new Handle(
						Opcodes.H_INVOKESTATIC,
						Constants.CONSTANT_BOOTSTRAPS_INT,
						Constants.PRIMITIVE_CLASS,
						Constants.PRIMITIVE_CLASS_DESC,
						false
				);
		
		public String descriptor;
		
		public PrimitiveClassValue(String descriptor){
			this.descriptor = descriptor;
		}
		
		public void write(MethodVisitor mv){
			mv.visitLdcInsn(new ConstantDynamic(descriptor, "Ljava/lang/Class;", PRIMITIVE_CLASS_HANDLE));
		}
		
		public TypeReference type(){
			// TODO: generics; consider that int.class is Class<Integer>
			return TypeResolver.resolveFq(Constants.CLASS);
		}
	}
	
	public static class InstanceofValue extends Value{
		private TypeReference target;
		Value checking;
		
		public InstanceofValue(TypeReference target, Value checking){
			this.target = target;
			this.checking = checking;
		}
		
		public void write(MethodVisitor mv){
			checking.write(mv);
			mv.visitTypeInsn(Opcodes.INSTANCEOF, target.internalName());
		}
		
		public void simplify(Statement in){
			checking.simplify(in);
		}
		
		public TypeReference type(){
			return PlatformDependency.BOOLEAN;
		}
	}
	
	public static class PrimitiveCastValue extends Value{
		Value casting;
		PrimitiveTypeRef.Primitive to;
		
		public PrimitiveCastValue(Value casting, PrimitiveTypeRef.Primitive to){
			this.casting = casting;
			this.to = to;
		}
		
		public void write(MethodVisitor mv){
			casting.write(mv);
			if(casting.type() instanceof PrimitiveTypeRef from){
				List<Integer> opcodes = from.narrowingOpcodes(to);
				if(opcodes == null)
					throw new CompileTimeException(text, "Can't convert from " + from.type + " to " + to + " by narrowing!");
				for(var op : opcodes)
					mv.visitInsn(op);
			}
		}
		
		public void simplify(Statement in){
			casting.simplify(in);
		}
		
		public TypeReference type(){
			return new PrimitiveTypeRef(to);
		}
	}
	
	public static class ClassCastValue extends Value{
		Value casting;
		TypeReference target;
		
		public ClassCastValue(Value casting, TypeReference target){
			this.casting = casting;
			this.target = target;
		}
		
		public void write(MethodVisitor mv){
			casting.write(mv);
			mv.visitTypeInsn(Opcodes.CHECKCAST, target.internalName());
		}
		
		public void simplify(Statement in){
			casting.simplify(in);
		}
		
		public TypeReference type(){
			return target;
		}
	}
	
	public static class ArrayIndexValue extends Value{
		Value array, index;
		ArrayTypeRef arrayType;
		
		public ArrayIndexValue(Value array, Value index){
			this.array = array;
			this.index = index.fit(PlatformDependency.INT);
			if(this.index == null){
				throw new CompileTimeException(text, "Cannot index an array using an index of type " + index.type().fullyQualifiedName() + ", which cannot be fit to an integer!");
			}
			if(array.type() instanceof ArrayTypeRef a)
				arrayType = a;
			else
				throw new CompileTimeException(text, "Tried to index a value of type " + array.type().fullyQualifiedName() + ", which is not an array!");
		}
		
		public void write(MethodVisitor mv){
			array.write(mv);
			index.write(mv);
			mv.visitInsn(arrayType.getComponent().arrayLoadOpcode());
		}
		
		public void simplify(Statement in){
			array.simplify(in);
			index.simplify(in);
		}
		
		public TypeReference type(){
			return arrayType.getComponent();
		}
	}
	
	public static class NewArrayValue extends Value{
		TypeReference componentType;
		Value length;
		
		public NewArrayValue(TypeReference componentType, Value length){
			this.componentType = componentType;
			this.length = length;
		}
		
		public void write(MethodVisitor mv){
			length.write(mv);
			mv.visitTypeInsn(Opcodes.ANEWARRAY, componentType.internalName());
		}
		
		public void simplify(Statement in){
			length.simplify(in);
		}
		
		public TypeReference type(){
			return new ArrayTypeRef(componentType);
		}
	}
	
	public static class NewPrimitiveArrayValue extends Value{
		PrimitiveTypeRef componentType;
		Value length;
		
		public NewPrimitiveArrayValue(PrimitiveTypeRef componentType, Value length){
			this.componentType = componentType;
			this.length = length;
		}
		
		public void write(MethodVisitor mv){
			length.write(mv);
			mv.visitIntInsn(Opcodes.NEWARRAY, componentType.arrayTypeCode());
		}
		
		public void simplify(Statement in){
			length.simplify(in);
		}
		
		public TypeReference type(){
			return new ArrayTypeRef(componentType);
		}
	}
	
	public static class NewListedArrayValue extends Value{
		public List<Value> entries;
		Value array;
		ArrayTypeRef arrayType;
		
		public NewListedArrayValue(List<Value> entries, TypeReference componentType){
			this.entries = entries.stream()
					.map(x -> x.fit(componentType))
					.collect(Collectors.toCollection(ArrayList::new));
			int invalidIdx = this.entries.indexOf(null);
			if(invalidIdx != -1)
				throw new CompileTimeException(null, "Expression \"" + entries.get(invalidIdx) + "\" cannot be converted to \"" + componentType.fullyQualifiedName() + "\"");
			var length = new IntLiteralValue(entries.size());
			if(componentType instanceof PrimitiveTypeRef p)
				array = new NewPrimitiveArrayValue(p, length);
			else
				array = new NewArrayValue(componentType, length);
			this.arrayType = (ArrayTypeRef)array.type();
		}
		
		public void write(MethodVisitor mv){
			array.write(mv);
			for(int i = 0; i < entries.size(); i++){
				mv.visitInsn(Opcodes.DUP);
				Value e = entries.get(i);
				new IntLiteralValue(i).write(mv);
				e.write(mv);
				mv.visitInsn(arrayType.getComponent().arrayStoreOpcode());
			}
		}
		
		public void simplify(Statement in){
			array.simplify(in);
			entries.forEach(value -> value.simplify(in));
		}
		
		public TypeReference type(){
			return arrayType;
		}
	}
	
	public static class InlineAssignValue extends Value{
		// TODO: refactor this, it sucks
		
		Value newValue;
		
		// only one of these lines should be set
		int localIdx = -10;
		Value fieldOf = null;
		FieldReference field = null;
		Value array = null, arrayIndex = null;
		
		// if true, evaluate to the value pre-assignment, like in ++x
		public boolean returnPreAssign = false;
		public Value target;
		
		// for computing range of local variable
		private Variable[] uses;
		
		public InlineAssignValue(Value newValue, int varIdx){
			this.newValue = newValue;
			localIdx = varIdx;
			uses = new Variable[]{newValue instanceof LocalVarValue local ? local.variable : null};
		}
		
		public InlineAssignValue(Value newValue, Value on, FieldReference target){
			this.newValue = newValue;
			fieldOf = on;
			field = target;
			uses = new Variable[]{
					newValue instanceof LocalVarValue nLocal ? nLocal.variable : null,
					on instanceof LocalVarValue onLocal ? onLocal.variable : null
			};
		}
		
		public InlineAssignValue(Value newValue, Value array, Value index){
			this.newValue = newValue;
			this.array = array;
			this.arrayIndex = index;
			uses = new Variable[]{
					newValue instanceof LocalVarValue nLocal ? nLocal.variable : null,
					array instanceof LocalVarValue arrLocal ? arrLocal.variable : null,
					index instanceof LocalVarValue idxLocal ? idxLocal.variable : null
			};
		}
		
		public void write(MethodVisitor mv){
			if(returnPreAssign)
				target.write(mv);
			
			if(localIdx > -10){
				newValue.write(mv);
				if(!returnPreAssign)
					mv.visitInsn(Opcodes.DUP);
				mv.visitVarInsn(newValue.type().localStoreOpcode(), localIdx);
			}else if(field != null){
				boolean farDup = true;
				
				if(!field.isStatic()){
					if(fieldOf != null)
						fieldOf.write(mv);
					else
						mv.visitVarInsn(Opcodes.ALOAD, 0);
				}else
					farDup = false;
				
				newValue.write(mv);
				if(!returnPreAssign){
					if(farDup){
						mv.visitInsn((newValue.type().equals(PlatformDependency.LONG) || newValue.type().equals(PlatformDependency.DOUBLE))
								? Opcodes.DUP2_X1 : Opcodes.DUP_X1);
					}else{
						mv.visitInsn((newValue.type().equals(PlatformDependency.LONG) || newValue.type().equals(PlatformDependency.DOUBLE))
								? Opcodes.DUP2 : Opcodes.DUP);
					}
				}
				field.writePut(mv);
			}else if(array != null && arrayIndex != null){
				array.write(mv);
				arrayIndex.write(mv);
				newValue.write(mv);
				if(!returnPreAssign)
					mv.visitInsn((newValue.type().equals(PlatformDependency.LONG) || newValue.type().equals(PlatformDependency.DOUBLE))
							? Opcodes.DUP2_X2 : Opcodes.DUP_X2);
				mv.visitInsn(((ArrayTypeRef)array.type()).getComponent().arrayStoreOpcode());
			}else
				throw new IllegalStateException();
			
			// end range is exclusive, so attach to next instruction
			if(CompilerLauncher.project.includeCyclicLibRefs){
				Label label = new Label();
				mv.visitLabel(label);
				for(Variable use : uses)
					if(use != null)
						if(use.end == null || use.end.getOffset() < label.getOffset())
							use.end = label;
			}
		}
		
		public TypeReference type(){
			return newValue.type();
		}
	}
}