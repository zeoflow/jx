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

package com.zeoflow.jx.lang.model.element;

import javax.annotation.processing.ProcessingEnvironment;
import com.zeoflow.jx.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import com.zeoflow.jx.lang.model.util.Elements;

/**
 * An immutable sequence of characters.  When created by the same
 * implementation, objects implementing this interface must obey the
 * general {@linkplain Object#equals equals contract} when compared
 * with each other.  Therefore, {@code Name} objects from the same
 * implementation are usable in collections while {@code Name}s from
 * different implementations may not work properly in collections.
 *
 * <p>An empty {@code Name} has a length of zero.
 *
 * <p>In the context of {@linkplain
 * ProcessingEnvironment annotation
 * processing}, the guarantees for "the same" implementation must
 * include contexts where the {@linkplain javax.annotation.processing
 * API mediated} side effects of {@linkplain
 * Processor processors} could be visible
 * to each other, including successive annotation processing
 * {@linkplain RoundEnvironment rounds}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see Elements#getName
 * @since 1.6
 */
public interface Name extends CharSequence
{

    /**
     * Returns {@code true} if the argument represents the same
     * name as {@code this}, and {@code false} otherwise.
     *
     * <p>Note that the identity of a {@code Name} is a function both
     * of its content in terms of a sequence of characters as well as
     * the implementation which created it.
     *
     * @param obj the object to be compared with this element
     *
     * @return {@code true} if the specified object represents the same
     * name as this
     *
     * @see Element#equals
     */
    boolean equals(Object obj);

    /**
     * Obeys the general contract of {@link Object#hashCode Object.hashCode}.
     *
     * @see #equals
     */
    int hashCode();

    /**
     * Compares this name to the specified {@code CharSequence}. The result
     * is {@code true} if and only if this name represents the same sequence
     * of {@code char} values as the specified sequence.
     *
     * @param cs The sequence to compare this name against
     *
     * @return {@code true} if this name represents the same sequence
     * of {@code char} values as the specified sequence, {@code false}
     * otherwise
     *
     * @see String#contentEquals(CharSequence)
     */
    boolean contentEquals(CharSequence cs);

}
