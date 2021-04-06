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

/**
 * The {@code kind} of an element.
 *
 * <p>Note that it is possible additional element kinds will be added
 * to accommodate new, currently unknown, language structures added to
 * future versions of the Java&trade; programming language.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see Element
 * @since 1.6
 */
public enum ElementKind
{

    /**
     * A package.
     */
    PACKAGE,

    // Declared types
    /**
     * An enum type.
     */
    ENUM,
    /**
     * A class not described by a more specific kind (like {@code ENUM}).
     */
    CLASS,
    /**
     * An annotation type.
     */
    ANNOTATION_TYPE,
    /**
     * An interface not described by a more specific kind (like
     * {@code ANNOTATION_TYPE}).
     */
    INTERFACE,

    // Variables
    /**
     * An enum constant.
     */
    ENUM_CONSTANT,
    /**
     * A field not described by a more specific kind (like
     * {@code ENUM_CONSTANT}).
     */
    FIELD,
    /**
     * A parameter of a method or constructor.
     */
    PARAMETER,
    /**
     * A local variable.
     */
    LOCAL_VARIABLE,
    /**
     * A parameter of an exception handler.
     */
    EXCEPTION_PARAMETER,

    // Executables
    /**
     * A method.
     */
    METHOD,
    /**
     * A constructor.
     */
    CONSTRUCTOR,
    /**
     * A static initializer.
     */
    STATIC_INIT,
    /**
     * An instance initializer.
     */
    INSTANCE_INIT,

    /**
     * A type parameter.
     */
    TYPE_PARAMETER,

    /**
     * An implementation-reserved element.  This is not the element
     * you are looking for.
     */
    OTHER,

    /**
     * A resource variable.
     *
     * @since 1.7
     */
    RESOURCE_VARIABLE;

    /**
     * Returns {@code true} if this is a kind of class:
     * either {@code CLASS} or {@code ENUM}.
     *
     * @return {@code true} if this is a kind of class
     */
    public boolean isClass()
    {
        return this == CLASS || this == ENUM;
    }

    /**
     * Returns {@code true} if this is a kind of interface:
     * either {@code INTERFACE} or {@code ANNOTATION_TYPE}.
     *
     * @return {@code true} if this is a kind of interface
     */
    public boolean isInterface()
    {
        return this == INTERFACE || this == ANNOTATION_TYPE;
    }

    /**
     * Returns {@code true} if this is a kind of field:
     * either {@code FIELD} or {@code ENUM_CONSTANT}.
     *
     * @return {@code true} if this is a kind of field
     */
    public boolean isField()
    {
        return this == FIELD || this == ENUM_CONSTANT;
    }
}
