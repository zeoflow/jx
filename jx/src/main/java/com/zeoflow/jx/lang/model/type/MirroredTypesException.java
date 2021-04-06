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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Thrown when an application attempts to access a sequence of {@link
 * Class} objects each corresponding to a {@link TypeMirror}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see MirroredTypeException
 * @see Element#getAnnotation(Class)
 * @since 1.6
 */
public class MirroredTypesException extends RuntimeException
{

    private static final long serialVersionUID = 269;

    transient List<? extends TypeMirror> types; // cannot be serialized

    /*
     * Trusted constructor to be called by MirroredTypeException.
     */
    MirroredTypesException(String message, TypeMirror type)
    {
        super(message);
        List<TypeMirror> tmp = (new ArrayList<TypeMirror>());
        tmp.add(type);
        types = Collections.unmodifiableList(tmp);
    }

    /**
     * Constructs a new MirroredTypesException for the specified types.
     *
     * @param types the types being accessed
     */
    public MirroredTypesException(List<? extends TypeMirror> types)
    {
        super("Attempt to access Class objects for TypeMirrors " +
                (types = // defensive copy
                        new ArrayList<TypeMirror>(types)).toString());
        this.types = Collections.unmodifiableList(types);
    }

    /**
     * Returns the type mirrors corresponding to the types being accessed.
     * The type mirrors may be unavailable if this exception has been
     * serialized and then read back in.
     *
     * @return the type mirrors in construction order, or {@code null} if unavailable
     */
    public List<? extends TypeMirror> getTypeMirrors()
    {
        return types;
    }

    /**
     * Explicitly set all transient fields.
     */
    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();
        types = null;
    }

}
