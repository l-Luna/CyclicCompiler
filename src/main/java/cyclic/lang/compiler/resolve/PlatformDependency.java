package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import cyclic.lang.compiler.model.platform.PrimitiveTypeRef;

import java.util.Optional;

/**
 * Implements {@linkplain Dependency} for the primitive types and array types.
 */
public final class PlatformDependency implements Dependency{
	
	public static final TypeReference BOOLEAN = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.BOOLEAN);
	
	public static final TypeReference BYTE = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.BYTE);
	public static final TypeReference SHORT = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.SHORT);
	public static final TypeReference INT = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.INT);
	public static final TypeReference LONG = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.LONG);
	public static final TypeReference CHAR = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.CHAR);
	
	public static final TypeReference FLOAT = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.FLOAT);
	public static final TypeReference DOUBLE = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.DOUBLE);
	
	public static final TypeReference VOID = new PrimitiveTypeRef(PrimitiveTypeRef.Primitive.VOID);
	
	public Optional<TypeReference> find(String fqName){
		if(fqName.endsWith("[]"))
			return TypeResolver.resolveFqOptional(fqName.substring(0, fqName.length() - 2)).map(ArrayTypeRef::new);
		
		return Optional.ofNullable(switch(fqName){
			case "boolean" -> BOOLEAN;
			case "byte" -> BYTE;
			case "short" -> SHORT;
			case "int" -> INT;
			case "long" -> LONG;
			case "char" -> CHAR;
			case "float" -> FLOAT;
			case "double" -> DOUBLE;
			case "void" -> VOID;
			default -> null;
		});
	}
}