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

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Standard locations of file objects.
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public enum StandardLocation implements JavaFileManager.Location
{

    /**
     * Location of new class files.
     */
    CLASS_OUTPUT,

    /**
     * Location of new source files.
     */
    SOURCE_OUTPUT,

    /**
     * Location to search for user class files.
     */
    CLASS_PATH,

    /**
     * Location to search for existing source files.
     */
    SOURCE_PATH,

    /**
     * Location to search for annotation processors.
     */
    ANNOTATION_PROCESSOR_PATH,

    /**
     * Location to search for platform classes.  Sometimes called
     * the boot class path.
     */
    PLATFORM_CLASS_PATH,

    /**
     * Location of new native header files.
     *
     * @since 1.8
     */
    NATIVE_HEADER_OUTPUT;

    //where
    private static final ConcurrentMap<String, JavaFileManager.Location> locations
            = new ConcurrentHashMap<String, JavaFileManager.Location>();
    /**
     * Gets a location object with the given name.  The following
     * property must hold: {@code locationFor(x) ==
     * locationFor(y)} if and only if {@code x.equals(y)}.
     * The returned location will be an output location if and only if
     * name ends with {@code "_OUTPUT"}.
     *
     * @param name a name
     *
     * @return a location
     */
    public static JavaFileManager.Location locationFor(final String name)
    {
        if (locations.isEmpty())
        {
            // can't use valueOf which throws IllegalArgumentException
            for (JavaFileManager.Location location : values())
                locations.putIfAbsent(location.getName(), location);
        }
        /* null-check */
        locations.putIfAbsent(name, new JavaFileManager.Location()
        {
            public String getName()
            {
                return name;
            }
            public boolean isOutputLocation()
            {
                return name.endsWith("_OUTPUT");
            }
        });
        return locations.get(name);
    }
    public String getName()
    {
        return name();
    }

    public boolean isOutputLocation()
    {
        switch (this)
        {
            case CLASS_OUTPUT:
            case SOURCE_OUTPUT:
            case NATIVE_HEADER_OUTPUT:
                return true;
            default:
                return false;
        }
    }
}
