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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Provides an easy way to collect diagnostics in a list.
 *
 * @param <S> the type of source objects used by diagnostics received
 *            by this object
 *
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public final class DiagnosticCollector<S> implements DiagnosticListener<S>
{

    private final List<javax.tools.Diagnostic<? extends S>> diagnostics =
            Collections.synchronizedList(new ArrayList<javax.tools.Diagnostic<? extends S>>());

    public void report(javax.tools.Diagnostic<? extends S> diagnostic)
    {
        diagnostic.getClass(); // null check
        diagnostics.add(diagnostic);
    }

    /**
     * Gets a list view of diagnostics collected by this object.
     *
     * @return a list view of diagnostics
     */
    public List<Diagnostic<? extends S>> getDiagnostics()
    {
        return Collections.unmodifiableList(diagnostics);
    }

}
