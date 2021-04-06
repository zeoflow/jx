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

package com.zeoflow.jx.lang.model;

import com.zeoflow.jx.lang.model.element.UnknownAnnotationValueException;
import com.zeoflow.jx.lang.model.element.UnknownElementException;
import com.zeoflow.jx.lang.model.type.UnknownTypeException;

/**
 * Superclass of exceptions which indicate that an unknown kind of
 * entity was encountered.  This situation can occur if the language
 * evolves and new kinds of constructs are introduced.  Subclasses of
 * this exception may be thrown by visitors to indicate that the
 * visitor was created for a prior version of the language.
 *
 * <p>A common superclass for those exceptions allows a single catch
 * block to have code handling them uniformly.
 *
 * @author Joseph D. Darcy
 * @see UnknownElementException
 * @see UnknownAnnotationValueException
 * @see UnknownTypeException
 * @since 1.7
 */
public class UnknownEntityException extends RuntimeException
{

    private static final long serialVersionUID = 269L;

    /**
     * Creates a new {@code UnknownEntityException} with the specified
     * detail message.
     *
     * @param message the detail message
     */
    protected UnknownEntityException(String message)
    {
        super(message);
    }

}
