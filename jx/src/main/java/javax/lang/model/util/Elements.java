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

import javax.lang.model.AnnotatedConstruct;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import java.util.List;
import java.util.Map;

/**
 * Utility methods for operating on program elements.
 *
 * <p><b>Compatibility Note:</b> Methods may be added to this interface
 * in future releases of the platform.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see ProcessingEnvironment#getElementUtils
 * @since 1.6
 */
public interface Elements
{

    /**
     * Returns a package given its fully qualified name.
     *
     * @param name fully qualified package name, or "" for an unnamed package
     *
     * @return the named package, or {@code null} if it cannot be found
     */
    javax.lang.model.element.PackageElement getPackageElement(CharSequence name);

    /**
     * Returns a type element given its canonical name.
     *
     * @param name the canonical name
     *
     * @return the named type element, or {@code null} if it cannot be found
     */
    javax.lang.model.element.TypeElement getTypeElement(CharSequence name);

    /**
     * Returns the values of an annotation's elements, including defaults.
     *
     * @param a annotation to examine
     *
     * @return the values of the annotation's elements, including defaults
     *
     * @see javax.lang.model.element.AnnotationMirror#getElementValues()
     */
    Map<? extends javax.lang.model.element.ExecutableElement, ? extends AnnotationValue>
    getElementValuesWithDefaults(javax.lang.model.element.AnnotationMirror a);

    /**
     * Returns the text of the documentation (&quot;Javadoc&quot;)
     * comment of an element.
     *
     * <p> A documentation comment of an element is a comment that
     * begins with "{@code /**}" , ends with a separate
     * "<code>*&#47;</code>", and immediately precedes the element,
     * ignoring white space.  Therefore, a documentation comment
     * contains at least three"{@code *}" characters.  The text
     * returned for the documentation comment is a processed form of
     * the comment as it appears in source code.  The leading "{@code
     * /**}" and trailing "<code>*&#47;</code>" are removed.  For lines
     * of the comment starting after the initial "{@code /**}",
     * leading white space characters are discarded as are any
     * consecutive "{@code *}" characters appearing after the white
     * space or starting the line.  The processed lines are then
     * concatenated together (including line terminators) and
     * returned.
     *
     * @param e the element being examined
     *
     * @return the documentation comment of the element, or {@code null}
     * if there is none
     */
    String getDocComment(javax.lang.model.element.Element e);

    /**
     * Returns {@code true} if the element is deprecated, {@code false} otherwise.
     *
     * @param e the element being examined
     *
     * @return {@code true} if the element is deprecated, {@code false} otherwise
     */
    boolean isDeprecated(javax.lang.model.element.Element e);

    /**
     * Returns the <i>binary name</i> of a type element.
     *
     * @param type the type element being examined
     *
     * @return the binary name
     * @see javax.lang.model.element.TypeElement#getQualifiedName
     */
    javax.lang.model.element.Name getBinaryName(javax.lang.model.element.TypeElement type);

    /**
     * Returns the package of an element.  The package of a package is
     * itself.
     *
     * @param type the element being examined
     *
     * @return the package of an element
     */
    PackageElement getPackageOf(javax.lang.model.element.Element type);

    /**
     * Returns all members of a type element, whether inherited or
     * declared directly.  For a class the result also includes its
     * constructors, but not local or anonymous classes.
     *
     * <p>Note that elements of certain kinds can be isolated using
     * methods in {@link ElementFilter}.
     *
     * @param type the type being examined
     *
     * @return all members of the type
     *
     * @see javax.lang.model.element.Element#getEnclosedElements
     */
    List<? extends javax.lang.model.element.Element> getAllMembers(javax.lang.model.element.TypeElement type);

    /**
     * Returns all annotations <i>present</i> on an element, whether
     * directly present or present via inheritance.
     *
     * @param e the element being examined
     *
     * @return all annotations of the element
     *
     * @see javax.lang.model.element.Element#getAnnotationMirrors
     * @see AnnotatedConstruct
     */
    List<? extends AnnotationMirror> getAllAnnotationMirrors(javax.lang.model.element.Element e);

    /**
     * Tests whether one type, method, or field hides another.
     *
     * @param hider  the first element
     * @param hidden the second element
     *
     * @return {@code true} if and only if the first element hides
     * the second
     */
    boolean hides(javax.lang.model.element.Element hider, javax.lang.model.element.Element hidden);

    /**
     * Tests whether one method, as a member of a given type,
     * overrides another method.
     * When a non-abstract method overrides an abstract one, the
     * former is also said to <i>implement</i> the latter.
     *
     * <p> In the simplest and most typical usage, the value of the
     * {@code type} parameter will simply be the class or interface
     * directly enclosing {@code overrider} (the possibly-overriding
     * method).  For example, suppose {@code m1} represents the method
     * {@code String.hashCode} and {@code m2} represents {@code
     * Object.hashCode}.  We can then ask whether {@code m1} overrides
     * {@code m2} within the class {@code String} (it does):
     *
     * <blockquote>
     * {@code assert elements.overrides(m1, m2,
     * elements.getTypeElement("java.lang.String")); }
     * </blockquote>
     * <p>
     * A more interesting case can be illustrated by the following example
     * in which a method in type {@code A} does not override a
     * like-named method in type {@code B}:
     *
     * <blockquote>
     * {@code class A { public void m() {} } }<br>
     * {@code interface B { void m(); } }<br>
     * ...<br>
     * {@code m1 = ...;  // A.m }<br>
     * {@code m2 = ...;  // B.m }<br>
     * {@code assert ! elements.overrides(m1, m2,
     * elements.getTypeElement("A")); }
     * </blockquote>
     * <p>
     * When viewed as a member of a third type {@code C}, however,
     * the method in {@code A} does override the one in {@code B}:
     *
     * <blockquote>
     * {@code class C extends A implements B {} }<br>
     * ...<br>
     * {@code assert elements.overrides(m1, m2,
     * elements.getTypeElement("C")); }
     * </blockquote>
     *
     * @param overrider  the first method, possible overrider
     * @param overridden the second method, possibly being overridden
     * @param type       the type of which the first method is a member
     *
     * @return {@code true} if and only if the first method overrides
     * the second
     */
    boolean overrides(javax.lang.model.element.ExecutableElement overrider, ExecutableElement overridden,
                      javax.lang.model.element.TypeElement type);

    /**
     * Returns the text of a <i>constant expression</i> representing a
     * primitive value or a string.
     * The text returned is in a form suitable for representing the value
     * in source code.
     *
     * @param value a primitive value or string
     *
     * @return the text of a constant expression
     *
     * @throws IllegalArgumentException if the argument is not a primitive
     *                                  value or string
     * @see VariableElement#getConstantValue()
     */
    String getConstantExpression(Object value);

    /**
     * Prints a representation of the elements to the given writer in
     * the specified order.  The main purpose of this method is for
     * diagnostics.  The exact format of the output is <em>not</em>
     * specified and is subject to change.
     *
     * @param w        the writer to print the output to
     * @param elements the elements to print
     */
    void printElements(java.io.Writer w, Element... elements);

    /**
     * Return a name with the same sequence of characters as the
     * argument.
     *
     * @param cs the character sequence to return as a name
     *
     * @return a name with the same sequence of characters as the argument
     */
    Name getName(CharSequence cs);

    /**
     * Returns {@code true} if the type element is a functional interface, {@code false} otherwise.
     *
     * @param type the type element being examined
     *
     * @return {@code true} if the element is a functional interface, {@code false} otherwise
     *
     * @since 1.8
     */
    boolean isFunctionalInterface(TypeElement type);

}
