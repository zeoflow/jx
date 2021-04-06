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
import java.util.Iterator;
import java.util.Set;

/**
 * Forwards calls to a given file manager.  Subclasses of this class
 * might override some of these methods and might also provide
 * additional fields and methods.
 *
 * @param <M> the kind of file manager forwarded to by this object
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class ForwardingJavaFileManager<M extends JavaFileManager> implements JavaFileManager
{

    /**
     * The file manager which all methods are delegated to.
     */
    protected final M fileManager;

    /**
     * Creates a new instance of ForwardingJavaFileManager.
     *
     * @param fileManager delegate to this file manager
     */
    protected ForwardingJavaFileManager(M fileManager)
    {
        fileManager.getClass(); // null check
        this.fileManager = fileManager;
    }

    /**
     * @throws SecurityException     {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     */
    public ClassLoader getClassLoader(Location location)
    {
        return fileManager.getClassLoader(location);
    }

    /**
     * @throws IOException           {@inheritDoc}
     * @throws IllegalStateException {@inheritDoc}
     */
    public Iterable<JavaFileObject> list(Location location,
                                         String packageName,
                                         Set<JavaFileObject.Kind> kinds,
                                         boolean recurse)
            throws IOException
    {
        return fileManager.list(location, packageName, kinds, recurse);
    }

    /**
     * @throws IllegalStateException {@inheritDoc}
     */
    public String inferBinaryName(Location location, JavaFileObject file)
    {
        return fileManager.inferBinaryName(location, file);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    public boolean isSameFile(FileObject a, FileObject b)
    {
        return fileManager.isSameFile(a, b);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IllegalStateException    {@inheritDoc}
     */
    public boolean handleOption(String current, Iterator<String> remaining)
    {
        return fileManager.handleOption(current, remaining);
    }

    public boolean hasLocation(Location location)
    {
        return fileManager.hasLocation(location);
    }

    public int isSupportedOption(String option)
    {
        return fileManager.isSupportedOption(option);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IllegalStateException    {@inheritDoc}
     */
    public JavaFileObject getJavaFileForInput(Location location,
                                              String className,
                                              JavaFileObject.Kind kind)
            throws IOException
    {
        return fileManager.getJavaFileForInput(location, className, kind);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IllegalStateException    {@inheritDoc}
     */
    public JavaFileObject getJavaFileForOutput(Location location,
                                               String className,
                                               JavaFileObject.Kind kind,
                                               FileObject sibling)
            throws IOException
    {
        return fileManager.getJavaFileForOutput(location, className, kind, sibling);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IllegalStateException    {@inheritDoc}
     */
    public FileObject getFileForInput(Location location,
                                      String packageName,
                                      String relativeName)
            throws IOException
    {
        return fileManager.getFileForInput(location, packageName, relativeName);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     * @throws IllegalStateException    {@inheritDoc}
     */
    public FileObject getFileForOutput(Location location,
                                       String packageName,
                                       String relativeName,
                                       FileObject sibling)
            throws IOException
    {
        return fileManager.getFileForOutput(location, packageName, relativeName, sibling);
    }

    public void flush() throws IOException
    {
        fileManager.flush();
    }

    public void close() throws IOException
    {
        fileManager.close();
    }

}
