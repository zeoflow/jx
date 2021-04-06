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

import javax.lang.model.SourceVersion;

import java.util.List;

/**
 * Represents a union type.
 * <p>
 * As of the {@link SourceVersion#RELEASE_7
 * RELEASE_7} source version, union types can appear as the type
 * of a multi-catch exception parameter.
 *
 * @since 1.7
 */
public interface UnionType extends TypeMirror
{

    /**
     * Return the alternatives comprising this union type.
     *
     * @return the alternatives comprising this union type.
     */
    List<? extends TypeMirror> getAlternatives();

}
