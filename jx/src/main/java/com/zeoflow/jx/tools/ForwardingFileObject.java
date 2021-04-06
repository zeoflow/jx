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

package com.zeoflow.jx.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;

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
public class ForwardingFileObject<F extends FileObject> implements FileObject
{

    /**
     * The file object which all methods are delegated to.
     */
    protected final F fileObject;

    /**
     * Creates a new instance of ForwardingFileObject.
     *
     * @param fileObject delegate to this file object
     */
    protected ForwardingFileObject(F fileObject)
    {
        fileObject.getClass(); // null check
        this.fileObject = fileObject;
    }

    public URI toUri()
    {
        return fileObject.toUri();
    }

    public String getName()
    {
        return fileObject.getName();
    }

    /**
     * @throws IllegalStateException         {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IOException                   {@inheritDoc}
     */
    public InputStream openInputStream() throws IOException
    {
        return fileObject.openInputStream();
    }

    /**
     * @throws IllegalStateException         {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IOException                   {@inheritDoc}
     */
    public OutputStream openOutputStream() throws IOException
    {
        return fileObject.openOutputStream();
    }

    /**
     * @throws IllegalStateException         {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IOException                   {@inheritDoc}
     */
    public Reader openReader(boolean ignoreEncodingErrors) throws IOException
    {
        return fileObject.openReader(ignoreEncodingErrors);
    }

    /**
     * @throws IllegalStateException         {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IOException                   {@inheritDoc}
     */
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException
    {
        return fileObject.getCharContent(ignoreEncodingErrors);
    }

    /**
     * @throws IllegalStateException         {@inheritDoc}
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IOException                   {@inheritDoc}
     */
    public Writer openWriter() throws IOException
    {
        return fileObject.openWriter();
    }

    public long getLastModified()
    {
        return fileObject.getLastModified();
    }

    public boolean delete()
    {
        return fileObject.delete();
    }

}
