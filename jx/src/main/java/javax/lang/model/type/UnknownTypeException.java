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

package javax.lang.model.type;

import javax.lang.model.UnknownEntityException;

/**
 * Indicates that an unknown kind of type was encountered.  This can
 * occur if the language evolves and new kinds of types are added to
 * the {@code TypeMirror} hierarchy.  May be thrown by a {@linkplain
 * javax.lang.model.type.TypeVisitor type visitor} to indicate that the visitor was created
 * for a prior version of the language.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see javax.lang.model.type.TypeVisitor#visitUnknown
 * @since 1.6
 */
public class UnknownTypeException extends UnknownEntityException
{

    private static final long serialVersionUID = 269L;

    private final transient javax.lang.model.type.TypeMirror type;
    private final transient Object parameter;

    /**
     * Creates a new {@code UnknownTypeException}.The {@code p}
     * parameter may be used to pass in an additional argument with
     * information about the context in which the unknown type was
     * encountered; for example, the visit methods of {@link
     * TypeVisitor} may pass in their additional parameter.
     *
     * @param t the unknown type, may be {@code null}
     * @param p an additional parameter, may be {@code null}
     */
    public UnknownTypeException(javax.lang.model.type.TypeMirror t, Object p)
    {
        super("Unknown type: " + t);
        type = t;
        this.parameter = p;
    }

    /**
     * Returns the unknown type.
     * The value may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the unknown type, or {@code null} if unavailable
     */
    public TypeMirror getUnknownType()
    {
        return type;
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
