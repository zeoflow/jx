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

package javax.tools;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;

/**
 * Forwards calls to a given file object.  Subclasses of this class
 * might override some of these methods and might also provide
 * additional fields and methods.
 *
 * @param <F> the kind of file object forwarded to by this object
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class ForwardingJavaFileObject<F extends javax.tools.JavaFileObject>
        extends ForwardingFileObject<F>
        implements JavaFileObject
{

    /**
     * Creates a new instance of ForwardingJavaFileObject.
     *
     * @param fileObject delegate to this file object
     */
    protected ForwardingJavaFileObject(F fileObject)
    {
        super(fileObject);
    }

    public Kind getKind()
    {
        return fileObject.getKind();
    }

    public boolean isNameCompatible(String simpleName, Kind kind)
    {
        return fileObject.isNameCompatible(simpleName, kind);
    }

    public NestingKind getNestingKind()
    {
        return fileObject.getNestingKind();
    }

    public Modifier getAccessLevel()
    {
        return fileObject.getAccessLevel();
    }

}
