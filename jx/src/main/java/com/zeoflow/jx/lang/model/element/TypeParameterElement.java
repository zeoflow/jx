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

package com.zeoflow.jx.lang.model.element;

import com.zeoflow.jx.lang.model.type.TypeMirror;
import com.zeoflow.jx.lang.model.type.TypeVariable;

import java.util.List;

/**
 * Represents a formal type parameter of a generic class, interface, method,
 * or constructor element.
 * A type parameter declares a {@link TypeVariable}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see TypeVariable
 * @since 1.6
 */
public interface TypeParameterElement extends Element
{

    /**
     * Returns the generic class, interface, method, or constructor that is
     * parameterized by this type parameter.
     *
     * @return the generic class, interface, method, or constructor that is
     * parameterized by this type parameter
     */
    Element getGenericElement();

    /**
     * Returns the bounds of this type parameter.
     * These are the types given by the {@code extends} clause
     * used to declare this type parameter.
     * If no explicit {@code extends} clause was used,
     * then {@code java.lang.Object} is considered to be the sole bound.
     *
     * @return the bounds of this type parameter, or an empty list if
     * there are none
     */
    List<? extends TypeMirror> getBounds();

    /**
     * Returns the {@linkplain TypeParameterElement#getGenericElement generic element} of this type parameter.
     *
     * @return the generic element of this type parameter
     */
    @Override
    Element getEnclosingElement();

}
