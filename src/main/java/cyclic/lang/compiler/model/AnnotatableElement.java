package cyclic.lang.compiler.model;

import java.util.Collections;
import java.util.Set;

/**
 * Represents an element in Cyclic that can be annotated.
 *
 * @see AnnotationTag
 * @see TypeReference
 */
public interface AnnotatableElement{
	
	/**
	 * Returns a set of references to the annotations on this element.
	 */
	default Set<AnnotationTag> annotations(){
		return Collections.emptySet();
	}
	
	/**
	 * Returns the name of the corresponding {@linkplain java.lang.annotation.ElementType} instance that describes the type
	 * of element this is for determining the applicability of annotations.
	 * @return The annotatable element type.
	 */
	String elementType();
}