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

package javax.lang.model.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

/**
 * Filters for selecting just the elements of interest from a
 * collection of elements.  The returned sets and lists are new
 * collections and do use the argument as a backing store.  The
 * methods in this class do not make any attempts to guard against
 * concurrent modifications of the arguments.  The returned sets and
 * lists are mutable but unsafe for concurrent access.  A returned set
 * has the same iteration order as the argument set to a method.
 *
 * <p>If iterables and sets containing {@code null} are passed as
 * arguments to methods in this class, a {@code NullPointerException}
 * will be thrown.
 *
 * <p>Note that a <i>static import</i> statement can make the text of
 * calls to the methods in this class more concise; for example:
 *
 * <blockquote><pre>
 *     import static jx.lang.model.util.ElementFilter.*;
 *     ...
 *         {@code List<VariableElement>} fs = fieldsIn(someClass.getEnclosedElements());
 * </pre></blockquote>
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @author Martin Buchholz
 * @since 1.6
 */
public class ElementFilter
{

    private static final Set<javax.lang.model.element.ElementKind> CONSTRUCTOR_KIND =
            Collections.unmodifiableSet(EnumSet.of(javax.lang.model.element.ElementKind.CONSTRUCTOR));
    private static final Set<javax.lang.model.element.ElementKind> FIELD_KINDS =
            Collections.unmodifiableSet(EnumSet.of(javax.lang.model.element.ElementKind.FIELD,
                    javax.lang.model.element.ElementKind.ENUM_CONSTANT));
    private static final Set<javax.lang.model.element.ElementKind> METHOD_KIND =
            Collections.unmodifiableSet(EnumSet.of(javax.lang.model.element.ElementKind.METHOD));
    private static final Set<javax.lang.model.element.ElementKind> PACKAGE_KIND =
            Collections.unmodifiableSet(EnumSet.of(javax.lang.model.element.ElementKind.PACKAGE));
    private static final Set<javax.lang.model.element.ElementKind> TYPE_KINDS =
            Collections.unmodifiableSet(EnumSet.of(javax.lang.model.element.ElementKind.CLASS,
                    javax.lang.model.element.ElementKind.ENUM,
                    javax.lang.model.element.ElementKind.INTERFACE,
                    javax.lang.model.element.ElementKind.ANNOTATION_TYPE));

    private ElementFilter()
    {
    } // Do not instantiate.
    /**
     * Returns a list of fields in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a list of fields in {@code elements}
     */
    public static List<javax.lang.model.element.VariableElement>
    fieldsIn(Iterable<? extends javax.lang.model.element.Element> elements)
    {
        return listFilter(elements, FIELD_KINDS, javax.lang.model.element.VariableElement.class);
    }

    /**
     * Returns a set of fields in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a set of fields in {@code elements}
     */
    public static Set<javax.lang.model.element.VariableElement>
    fieldsIn(Set<? extends javax.lang.model.element.Element> elements)
    {
        return setFilter(elements, FIELD_KINDS, VariableElement.class);
    }

    /**
     * Returns a list of constructors in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a list of constructors in {@code elements}
     */
    public static List<javax.lang.model.element.ExecutableElement>
    constructorsIn(Iterable<? extends javax.lang.model.element.Element> elements)
    {
        return listFilter(elements, CONSTRUCTOR_KIND, javax.lang.model.element.ExecutableElement.class);
    }

    /**
     * Returns a set of constructors in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a set of constructors in {@code elements}
     */
    public static Set<javax.lang.model.element.ExecutableElement>
    constructorsIn(Set<? extends javax.lang.model.element.Element> elements)
    {
        return setFilter(elements, CONSTRUCTOR_KIND, javax.lang.model.element.ExecutableElement.class);
    }

    /**
     * Returns a list of methods in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a list of methods in {@code elements}
     */
    public static List<javax.lang.model.element.ExecutableElement>
    methodsIn(Iterable<? extends javax.lang.model.element.Element> elements)
    {
        return listFilter(elements, METHOD_KIND, javax.lang.model.element.ExecutableElement.class);
    }

    /**
     * Returns a set of methods in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a set of methods in {@code elements}
     */
    public static Set<javax.lang.model.element.ExecutableElement>
    methodsIn(Set<? extends javax.lang.model.element.Element> elements)
    {
        return setFilter(elements, METHOD_KIND, ExecutableElement.class);
    }

    /**
     * Returns a list of types in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a list of types in {@code elements}
     */
    public static List<javax.lang.model.element.TypeElement>
    typesIn(Iterable<? extends javax.lang.model.element.Element> elements)
    {
        return listFilter(elements, TYPE_KINDS, javax.lang.model.element.TypeElement.class);
    }

    /**
     * Returns a set of types in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a set of types in {@code elements}
     */
    public static Set<javax.lang.model.element.TypeElement>
    typesIn(Set<? extends javax.lang.model.element.Element> elements)
    {
        return setFilter(elements, TYPE_KINDS, TypeElement.class);
    }

    /**
     * Returns a list of packages in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a list of packages in {@code elements}
     */
    public static List<javax.lang.model.element.PackageElement>
    packagesIn(Iterable<? extends javax.lang.model.element.Element> elements)
    {
        return listFilter(elements, PACKAGE_KIND, javax.lang.model.element.PackageElement.class);
    }

    /**
     * Returns a set of packages in {@code elements}.
     *
     * @param elements the elements to filter
     *
     * @return a set of packages in {@code elements}
     */
    public static Set<javax.lang.model.element.PackageElement>
    packagesIn(Set<? extends javax.lang.model.element.Element> elements)
    {
        return setFilter(elements, PACKAGE_KIND, PackageElement.class);
    }

    // Assumes targetKinds and E are sensible.
    private static <E extends javax.lang.model.element.Element> List<E> listFilter(Iterable<? extends javax.lang.model.element.Element> elements,
                                                                                   Set<javax.lang.model.element.ElementKind> targetKinds,
                                                                                   Class<E> clazz)
    {
        List<E> list = new ArrayList<E>();
        for (javax.lang.model.element.Element e : elements)
        {
            if (targetKinds.contains(e.getKind()))
                list.add(clazz.cast(e));
        }
        return list;
    }

    // Assumes targetKinds and E are sensible.
    private static <E extends javax.lang.model.element.Element> Set<E> setFilter(Set<? extends javax.lang.model.element.Element> elements,
                                                                                 Set<ElementKind> targetKinds,
                                                                                 Class<E> clazz)
    {
        // Return set preserving iteration order of input set.
        Set<E> set = new LinkedHashSet<E>();
        for (Element e : elements)
        {
            if (targetKinds.contains(e.getKind()))
                set.add(clazz.cast(e));
        }
        return set;
    }

}
