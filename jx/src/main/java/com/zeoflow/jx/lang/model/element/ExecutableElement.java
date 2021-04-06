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

import com.zeoflow.jx.lang.model.type.ExecutableType;
import com.zeoflow.jx.lang.model.type.NoType;
import com.zeoflow.jx.lang.model.type.TypeKind;
import com.zeoflow.jx.lang.model.type.TypeMirror;

import java.util.List;

/**
 * Represents a method, constructor, or initializer (static or
 * instance) of a class or interface, including annotation type
 * elements.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see ExecutableType
 * @since 1.6
 */
public interface ExecutableElement extends Element, Parameterizable
{

    /**
     * Returns the formal type parameters of this executable
     * in declaration order.
     *
     * @return the formal type parameters, or an empty list
     * if there are none
     */
    List<? extends TypeParameterElement> getTypeParameters();

    /**
     * Returns the return type of this executable.
     * Returns a {@link NoType} with kind {@link TypeKind#VOID VOID}
     * if this executable is not a method, or is a method that does not
     * return a value.
     *
     * @return the return type of this executable
     */
    TypeMirror getReturnType();

    /**
     * Returns the formal parameters of this executable.
     * They are returned in declaration order.
     *
     * @return the formal parameters,
     * or an empty list if there are none
     */
    List<? extends VariableElement> getParameters();

    /**
     * Returns the receiver type of this executable,
     * or {@link NoType NoType} with
     * kind {@link TypeKind#NONE NONE}
     * if the executable has no receiver type.
     * <p>
     * An executable which is an instance method, or a constructor of an
     * inner class, has a receiver type derived from the {@linkplain
     * #getEnclosingElement declaring type}.
     * <p>
     * An executable which is a static method, or a constructor of a
     * non-inner class, or an initializer (static or instance), has no
     * receiver type.
     *
     * @return the receiver type of this executable
     *
     * @since 1.8
     */
    TypeMirror getReceiverType();

    /**
     * Returns {@code true} if this method or constructor accepts a variable
     * number of arguments and returns {@code false} otherwise.
     *
     * @return {@code true} if this method or constructor accepts a variable
     * number of arguments and {@code false} otherwise
     */
    boolean isVarArgs();

    /**
     * Returns {@code true} if this method is a default method and
     * returns {@code false} otherwise.
     *
     * @return {@code true} if this method is a default method and
     * {@code false} otherwise
     *
     * @since 1.8
     */
    boolean isDefault();

    /**
     * Returns the exceptions and other throwables listed in this
     * method or constructor's {@code throws} clause in declaration
     * order.
     *
     * @return the exceptions and other throwables listed in the
     * {@code throws} clause, or an empty list if there are none
     */
    List<? extends TypeMirror> getThrownTypes();

    /**
     * Returns the default value if this executable is an annotation
     * type element.  Returns {@code null} if this method is not an
     * annotation type element, or if it is an annotation type element
     * with no default value.
     *
     * @return the default value, or {@code null} if none
     */
    AnnotationValue getDefaultValue();

    /**
     * Returns the simple name of a constructor, method, or
     * initializer.  For a constructor, the name {@code "<init>"} is
     * returned, for a static initializer, the name {@code "<clinit>"}
     * is returned, and for an anonymous class or instance
     * initializer, an empty name is returned.
     *
     * @return the simple name of a constructor, method, or
     * initializer
     */
    @Override
    Name getSimpleName();

}
