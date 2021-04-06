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
 * Represents an intersection type.
 *
 * <p>An intersection type can be either implicitly or explicitly
 * declared in a program. For example, the bound of the type parameter
 * {@code <T extends Number & Runnable>} is an (implicit) intersection
 * type.  As of {@link SourceVersion#RELEASE_8
 * RELEASE_8}, this is represented by an {@code IntersectionType} with
 * {@code Number} and {@code Runnable} as its bounds.
 *
 * Also as of {@link
 * SourceVersion#RELEASE_8 RELEASE_8}, in the
 * reference implementation an {@code IntersectionType} is used to
 * model the explicit target type of a cast expression.
 * @since 1.8
 */
public interface IntersectionType extends TypeMirror
{

    /**
     * Return the bounds comprising this intersection type.
     *
     * @return the bounds of this intersection types.
     */
    List<? extends TypeMirror> getBounds();

}
