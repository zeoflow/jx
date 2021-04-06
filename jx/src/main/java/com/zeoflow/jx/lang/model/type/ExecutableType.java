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

import com.zeoflow.jx.lang.model.element.ExecutableElement;

import java.util.List;

/**
 * Represents the type of an executable.  An <i>executable</i>
 * is a method, constructor, or initializer.
 *
 * <p> The executable is
 * represented as when viewed as a method (or constructor or
 * initializer) of some reference type.
 * If that reference type is parameterized, then its actual
 * type arguments are substituted into any types returned by the methods of
 * this interface.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see ExecutableElement
 * @since 1.6
 */
public interface ExecutableType extends TypeMirror
{

    /**
     * Returns the type variables declared by the formal type parameters
     * of this executable.
     *
     * @return the type variables declared by the formal type parameters,
     * or an empty list if there are none
     */
    List<? extends TypeVariable> getTypeVariables();

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
     * Returns the types of this executable's formal parameters.
     *
     * @return the types of this executable's formal parameters,
     * or an empty list if there are none
     */
    List<? extends TypeMirror> getParameterTypes();

    /**
     * Returns the receiver type of this executable,
     * or {@link NoType NoType} with
     * kind {@link TypeKind#NONE NONE}
     * if the executable has no receiver type.
     * <p>
     * An executable which is an instance method, or a constructor of an
     * inner class, has a receiver type derived from the {@linkplain
     * ExecutableElement#getEnclosingElement declaring type}.
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
     * Returns the exceptions and other throwables listed in this
     * executable's {@code throws} clause.
     *
     * @return the exceptions and other throwables listed in this
     * executable's {@code throws} clause,
     * or an empty list if there are none.
     */
    List<? extends TypeMirror> getThrownTypes();

}
