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

import com.zeoflow.jx.lang.model.UnknownEntityException;

/**
 * Indicates that an unknown kind of annotation value was encountered.
 * This can occur if the language evolves and new kinds of annotation
 * values can be stored in an annotation.  May be thrown by an
 * {@linkplain AnnotationValueVisitor annotation value visitor} to
 * indicate that the visitor was created for a prior version of the
 * language.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see AnnotationValueVisitor#visitUnknown
 * @since 1.6
 */
public class UnknownAnnotationValueException extends UnknownEntityException
{

    private static final long serialVersionUID = 269L;

    private final transient AnnotationValue av;
    private final transient Object parameter;

    /**
     * Creates a new {@code UnknownAnnotationValueException}.  The
     * {@code p} parameter may be used to pass in an additional
     * argument with information about the context in which the
     * unknown annotation value was encountered; for example, the
     * visit methods of {@link AnnotationValueVisitor} may pass in
     * their additional parameter.
     *
     * @param av the unknown annotation value, may be {@code null}
     * @param p  an additional parameter, may be {@code null}
     */
    public UnknownAnnotationValueException(AnnotationValue av, Object p)
    {
        super("Unknown annotation value: " + av);
        this.av = av;
        this.parameter = p;
    }

    /**
     * Returns the unknown annotation value.
     * The value may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the unknown element, or {@code null} if unavailable
     */
    public AnnotationValue getUnknownAnnotationValue()
    {
        return av;
    }

    /**
     * Returns the additional argument.
     *
     * @return the additional argument
     */
    public Object getArgument()
    {
        return parameter;
    }

}
