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

package javax.annotation.processing;

import java.io.IOException;

import javax.annotation.processing.Filer;

/**
 * Indicates a {@link Filer} detected an attempt to open a file that
 * would violate the guarantees provided by the {@code Filer}.  Those
 * guarantees include not creating the same file more than once, not
 * creating multiple files corresponding to the same type, and not
 * creating files for types with invalid names.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class FilerException extends IOException
{

    static final long serialVersionUID = 8426423106453163293L;
    /**
     * Constructs an exception with the specified detail message.
     *
     * @param s the detail message, which should include the name of
     *          the file attempting to be opened; may be {@code null}
     */
    public FilerException(String s)
    {
        super(s);
    }

}
