/*
 * Copyright (C) 2021 ZeoFlow SRL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.lang.model.element;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.Elements;

import java.util.Map;

/**
 * Represents an annotation.  An annotation associates a value with
 * each element of an annotation type.
 *
 * <p> Annotations should be compared using the {@code equals}
 * method.  There is no guarantee that any particular annotation will
 * always be represented by the same object.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public interface AnnotationMirror
{

    /**
     * Returns the type of this annotation.
     *
     * @return the type of this annotation
     */
    DeclaredType getAnnotationType();

    /**
     * Returns the values of this annotation's elements.
     * This is returned in the form of a map that associates elements
     * with their corresponding values.
     * Only those elements with values explicitly present in the
     * annotation are included, not those that are implicitly assuming
     * their default values.
     * The order of the map matches the order in which the
     * values appear in the annotation's source.
     *
     * <p>Note that an annotation mirror of a marker annotation type
     * will by definition have an empty map.
     *
     * <p>To fill in default values, use {@link
     * Elements#getElementValuesWithDefaults
     * getElementValuesWithDefaults}.
     *
     * @return the values of this annotation's elements,
     * or an empty map if there are none
     */
    Map<? extends ExecutableElement, ? extends AnnotationValue> getElementValues();

}
