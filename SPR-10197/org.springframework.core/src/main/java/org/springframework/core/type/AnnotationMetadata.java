/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.type;

import java.util.Map;
import java.util.Set;

/**
 * Interface that defines abstract access to the annotations of a specific
 * class, in a form that does not require that class to be loaded yet.
 *
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @since 2.5
 * @see StandardAnnotationMetadata
 * @see org.springframework.core.type.classreading.MetadataReader#getAnnotationMetadata()
 */
public interface AnnotationMetadata extends ClassMetadata {

	/**
	 * Return the names of all annotation types defined on the underlying class.
	 * @return the annotation type names
	 */
	Set<String> getAnnotationTypes();

	/**
	 * Return the names of all meta-annotation types defined on the
	 * given annotation type of the underlying class.
	 * @param annotationType the meta-annotation type to look for
	 * @return the meta-annotation type names
	 */
	Set<String> getMetaAnnotationTypes(String annotationType);

	/**
	 * Determine whether the underlying class has an annotation of the given
	 * type defined.
	 * @param annotationType the annotation type to look for
	 * @return whether a matching annotation is defined
	 */
	boolean hasAnnotation(String annotationType);

	/**
	 * Determine whether the underlying class has an annotation that
	 * is itself annotated with the meta-annotation of the given type.
	 * @param metaAnnotationType the meta-annotation type to look for
	 * @return whether a matching meta-annotation is defined
	 */
	boolean hasMetaAnnotation(String metaAnnotationType);

	/**
	 * Determine whether the underlying class has an annotation or
	 * meta-annotation of the given type defined.
	 * <p>This is equivalent to a "hasAnnotation || hasMetaAnnotation"
	 * check. If this method returns <code>true</code>, then
	 * {@link #getAnnotationAttributes} will return a non-null Map.
	 * @param annotationType the annotation type to look for
	 * @return whether a matching annotation is defined
	 */
	boolean isAnnotated(String annotationType);

	/**
	 * Retrieve the attributes of the annotation of the given type,
	 * if any (i.e. if defined on the underlying class, as direct
	 * annotation or as meta-annotation).
	 * @param annotationType the annotation type to look for
	 * @return a Map of attributes, with the attribute name as key (e.g. "value")
	 * and the defined attribute value as Map value. This return value will be
	 * <code>null</code> if no matching annotation is defined.
	 */
	Map<String, Object> getAnnotationAttributes(String annotationType);

	/**
	 * Retrieve the attributes of the annotation of the given type,
	 * if any (i.e. if defined on the underlying class, as direct
	 * annotation or as meta-annotation).
	 * @param annotationType the annotation type to look for
	 * @param classValuesAsString whether to convert class references to String
	 * class names for exposure as values in the returned Map, instead of Class
	 * references which might potentially have to be loaded first
	 * @return a Map of attributes, with the attribute name as key (e.g. "value")
	 * and the defined attribute value as Map value. This return value will be
	 * <code>null</code> if no matching annotation is defined.
	 */
	Map<String, Object> getAnnotationAttributes(String annotationType, boolean classValuesAsString);

	/**
	 * Determine whether the underlying class has any methods that are
	 * annotated (or meta-annotated) with the given annotation type.
	 */
	boolean hasAnnotatedMethods(String annotationType);

	/**
	 * Retrieve the method metadata for all methods that are annotated
	 * (or meta-annotated) with the given annotation type.
	 * <p>For any returned method, {@link MethodMetadata#isAnnotated} will
	 * return <code>true</code> for the given annotation type.
	 * @param annotationType the annotation type to look for
	 * @return a Set of {@link MethodMetadata} for methods that have a matching
	 * annotation. The return value will be an empty set if no methods match
	 * the annotation type.
	 */
	Set<MethodMetadata> getAnnotatedMethods(String annotationType);

}
