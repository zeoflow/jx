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

package javax.lang.model.element;

import javax.lang.model.type.TypeMirror;

import java.util.List;

/**
 * A visitor of the values of annotation type elements, using a
 * variant of the visitor design pattern.  Unlike a standard visitor
 * which dispatches based on the concrete type of a member of a type
 * hierarchy, this visitor dispatches based on the type of data
 * stored; there are no distinct subclasses for storing, for example,
 * {@code boolean} values versus {@code int} values.  Classes
 * implementing this interface are used to operate on a value when the
 * type of that value is unknown at compile time.  When a visitor is
 * passed to a value's {@link javax.lang.model.element.AnnotationValue#accept accept} method,
 * the <tt>visit<i>XYZ</i></tt> method applicable to that value is
 * invoked.
 *
 * <p> Classes implementing this interface may or may not throw a
 * {@code NullPointerException} if the additional parameter {@code p}
 * is {@code null}; see documentation of the implementing class for
 * details.
 *
 * <p> <b>WARNING:</b> It is possible that methods will be added to
 * this interface to accommodate new, currently unknown, language
 * structures added to future versions of the Java&trade; programming
 * language.  Therefore, visitor classes directly implementing this
 * interface may be source incompatible with future versions of the
 * platform.  To avoid this source incompatibility, visitor
 * implementations are encouraged to instead extend the appropriate
 * abstract visitor class that implements this interface.  However, an
 * API should generally use this visitor interface as the type for
 * parameters, return type, etc. rather than one of the abstract
 * classes.
 *
 * <p>Note that methods to accommodate new language constructs could
 * be added in a source <em>compatible</em> way if they were added as
 * <em>default methods</em>.  However, default methods are only
 * available on Java SE 8 and higher releases and the {@code
 * jx.lang.model.*} packages bundled in Java SE 8 are required to
 * also be runnable on Java SE 7.  Therefore, default methods
 * <em>cannot</em> be used when extending {@code jx.lang.model.*}
 * to cover Java SE 8 language features.  However, default methods may
 * be used in subsequent revisions of the {@code jx.lang.model.*}
 * packages that are only required to run on Java SE 8 and higher
 * platform versions.
 *
 * @param <R> the return type of this visitor's methods
 * @param <P> the type of the additional parameter to this visitor's methods.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public interface AnnotationValueVisitor<R, P>
{

    /**
     * Visits an annotation value.
     *
     * @param av the value to visit
     * @param p  a visitor-specified parameter
     *
     * @return a visitor-specified result
     */
    R visit(javax.lang.model.element.AnnotationValue av, P p);

    /**
     * A convenience method equivalent to {@code v.visit(av, null)}.
     *
     * @param av the value to visit
     *
     * @return a visitor-specified result
     */
    R visit(javax.lang.model.element.AnnotationValue av);

    /**
     * Visits a {@code boolean} value in an annotation.
     *
     * @param b the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitBoolean(boolean b, P p);

    /**
     * Visits a {@code byte} value in an annotation.
     *
     * @param b the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitByte(byte b, P p);

    /**
     * Visits a {@code char} value in an annotation.
     *
     * @param c the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitChar(char c, P p);

    /**
     * Visits a {@code double} value in an annotation.
     *
     * @param d the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitDouble(double d, P p);

    /**
     * Visits a {@code float} value in an annotation.
     *
     * @param f the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitFloat(float f, P p);

    /**
     * Visits an {@code int} value in an annotation.
     *
     * @param i the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitInt(int i, P p);

    /**
     * Visits a {@code long} value in an annotation.
     *
     * @param i the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitLong(long i, P p);

    /**
     * Visits a {@code short} value in an annotation.
     *
     * @param s the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitShort(short s, P p);

    /**
     * Visits a string value in an annotation.
     *
     * @param s the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitString(String s, P p);

    /**
     * Visits a type value in an annotation.
     *
     * @param t the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitType(TypeMirror t, P p);

    /**
     * Visits an {@code enum} value in an annotation.
     *
     * @param c the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitEnumConstant(VariableElement c, P p);

    /**
     * Visits an annotation value in an annotation.
     *
     * @param a the value being visited
     * @param p a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitAnnotation(AnnotationMirror a, P p);

    /**
     * Visits an array value in an annotation.
     *
     * @param vals the value being visited
     * @param p    a visitor-specified parameter
     *
     * @return the result of the visit
     */
    R visitArray(List<? extends javax.lang.model.element.AnnotationValue> vals, P p);

    /**
     * Visits an unknown kind of annotation value.
     * This can occur if the language evolves and new kinds
     * of value can be stored in an annotation.
     *
     * @param av the unknown value being visited
     * @param p  a visitor-specified parameter
     *
     * @return the result of the visit
     *
     * @throws UnknownAnnotationValueException a visitor implementation may optionally throw this exception
     */
    R visitUnknown(AnnotationValue av, P p);

}
