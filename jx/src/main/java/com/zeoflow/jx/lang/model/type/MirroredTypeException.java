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

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Thrown when an application attempts to access the {@link Class} object
 * corresponding to a {@link TypeMirror}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see MirroredTypesException
 * @see Element#getAnnotation(Class)
 * @since 1.6
 */
public class MirroredTypeException extends MirroredTypesException
{

    private static final long serialVersionUID = 269;

    private transient TypeMirror type;          // cannot be serialized

    /**
     * Constructs a new MirroredTypeException for the specified type.
     *
     * @param type the type being accessed
     */
    public MirroredTypeException(TypeMirror type)
    {
        super("Attempt to access Class object for TypeMirror " + type.toString(), type);
        this.type = type;
    }

    /**
     * Returns the type mirror corresponding to the type being accessed.
     * The type mirror may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the type mirror, or {@code null} if unavailable
     */
    public TypeMirror getTypeMirror()
    {
        return type;
    }

    /**
     * Explicitly set all transient fields.
     */
    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();
        type = null;
        types = null;
    }

}
