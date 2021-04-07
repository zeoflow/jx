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

/**
 * Utility class for assembling {@link Completion} objects.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class Completions
{

    // No instances for you.
    private Completions()
    {
    }
    /**
     * Returns a completion of the value and message.
     *
     * @param value   the text of the completion
     * @param message a message about the completion
     *
     * @return a completion of the provided value and message
     */
    public static Completion of(String value, String message)
    {
        return new SimpleCompletion(value, message);
    }
    /**
     * Returns a completion of the value and an empty message
     *
     * @param value the text of the completion
     *
     * @return a completion of the value and an empty message
     */
    public static Completion of(String value)
    {
        return new SimpleCompletion(value, "");
    }

    private static class SimpleCompletion implements Completion
    {

        private final String value;
        private final String message;

        SimpleCompletion(String value, String message)
        {
            if (value == null || message == null)
                throw new NullPointerException("Null completion strings not accepted.");
            this.value = value;
            this.message = message;
        }

        public String getValue()
        {
            return value;
        }

        public String getMessage()
        {
            return message;
        }

        @Override
        public String toString()
        {
            return "[\"" + value + "\", \"" + message + "\"]";
        }
        // Default equals and hashCode are fine.
    }

}
