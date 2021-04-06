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

/**
 * Interface for recognizing options.
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public interface OptionChecker
{

    /**
     * Determines if the given option is supported and if so, the
     * number of arguments the option takes.
     *
     * @param option an option
     *
     * @return the number of arguments the given option takes or -1 if
     * the option is not supported
     */
    int isSupportedOption(String option);

}
