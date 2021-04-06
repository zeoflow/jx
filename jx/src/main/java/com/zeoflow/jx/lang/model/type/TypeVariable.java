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
import com.zeoflow.jx.lang.model.element.TypeParameterElement;

/**
 * Represents a type variable.
 * A type variable may be explicitly declared by a
 * {@linkplain TypeParameterElement type parameter} of a
 * type, method, or constructor.
 * A type variable may also be declared implicitly, as by
 * the capture conversion of a wildcard type argument
 * (see chapter 5 of
 * <cite>The Java&trade; Language Specification</cite>).
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see TypeParameterElement
 * @since 1.6
 */
public interface TypeVariable extends ReferenceType
{

    /**
     * Returns the element corresponding to this type variable.
     *
     * @return the element corresponding to this type variable
     */
    Element asElement();

    /**
     * Returns the upper bound of this type variable.
     *
     * <p> If this type variable was declared with no explicit
     * upper bounds, the result is {@code java.lang.Object}.
     * If it was declared with multiple upper bounds,
     * the result is an {@linkplain IntersectionType intersection type};
     * individual bounds can be found by examining the result's
     * {@linkplain IntersectionType#getBounds() bounds}.
     *
     * @return the upper bound of this type variable
     */
    TypeMirror getUpperBound();

    /**
     * Returns the lower bound of this type variable.  While a type
     * parameter cannot include an explicit lower bound declaration,
     * capture conversion can produce a type variable with a
     * non-trivial lower bound.  Type variables otherwise have a
     * lower bound of {@link NullType}.
     *
     * @return the lower bound of this type variable
     */
    TypeMirror getLowerBound();

}
