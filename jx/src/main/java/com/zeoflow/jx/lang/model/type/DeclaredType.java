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

package com.zeoflow.jx.lang.model.type;

import com.zeoflow.jx.lang.model.element.Element;
import com.zeoflow.jx.lang.model.element.TypeElement;
import com.zeoflow.jx.lang.model.util.Types;

import java.util.List;

/**
 * Represents a declared type, either a class type or an interface type.
 * This includes parameterized types such as {@code java.util.Set<String>}
 * as well as raw types.
 *
 * <p> While a {@code TypeElement} represents a class or interface
 * <i>element</i>, a {@code DeclaredType} represents a class
 * or interface <i>type</i>, the latter being a use
 * (or <i>invocation</i>) of the former.
 * See {@link TypeElement} for more on this distinction.
 *
 * <p> The supertypes (both class and interface types) of a declared
 * type may be found using the {@link
 * Types#directSupertypes(TypeMirror)} method.  This returns the
 * supertypes with any type arguments substituted in.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see TypeElement
 * @since 1.6
 */
public interface DeclaredType extends ReferenceType
{

    /**
     * Returns the element corresponding to this type.
     *
     * @return the element corresponding to this type
     */
    Element asElement();

    /**
     * Returns the type of the innermost enclosing instance or a
     * {@code NoType} of kind {@code NONE} if there is no enclosing
     * instance.  Only types corresponding to inner classes have an
     * enclosing instance.
     *
     * @return a type mirror for the enclosing type
     */
    TypeMirror getEnclosingType();

    /**
     * Returns the actual type arguments of this type.
     * For a type nested within a parameterized type
     * (such as {@code Outer<String>.Inner<Number>}), only the type
     * arguments of the innermost type are included.
     *
     * @return the actual type arguments of this type, or an empty list
     * if none
     */
    List<? extends TypeMirror> getTypeArguments();

}
