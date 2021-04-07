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

import javax.lang.model.SourceVersion;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;

/**
 * A visitor of program elements based on their {@linkplain
 * javax.lang.model.element.ElementKind kind} with default behavior appropriate for the {@link
 * SourceVersion#RELEASE_6 RELEASE_6} source version.  For {@linkplain
 * Element elements} <tt><i>XYZ</i></tt> that may have more than one
 * kind, the <tt>visit<i>XYZ</i></tt> methods in this class delegate
 * to the <tt>visit<i>XYZKind</i></tt> method corresponding to the
 * first argument's kind.  The <tt>visit<i>XYZKind</i></tt> methods
 * call {@link #defaultAction defaultAction}, passing their arguments
 * to {@code defaultAction}'s corresponding parameters.
 *
 * <p> Methods in this class may be overridden subject to their
 * general contract.  Note that annotating methods in concrete
 * subclasses with {@link java.lang.Override @Override} will help
 * ensure that methods are overridden as intended.
 *
 * <p> <b>WARNING:</b> The {@code ElementVisitor} interface
 * implemented by this class may have methods added to it or the
 * {@code ElementKind} {@code enum} used in this case may have
 * constants added to it in the future to accommodate new, currently
 * unknown, language structures added to future versions of the
 * Java&trade; programming language.  Therefore, methods whose names
 * begin with {@code "visit"} may be added to this class in the
 * future; to avoid incompatibilities, classes which extend this class
 * should not declare any instance methods with names beginning with
 * {@code "visit"}.
 *
 * <p>When such a new visit method is added, the default
 * implementation in this class will be to call the {@link
 * #visitUnknown visitUnknown} method.  A new abstract element kind
 * visitor class will also be introduced to correspond to the new
 * language level; this visitor will have different default behavior
 * for the visit method in question.  When the new visitor is
 * introduced, all or portions of this visitor may be deprecated.
 *
 * <p>Note that adding a default implementation of a new visit method
 * in a visitor class will occur instead of adding a <em>default
 * method</em> directly in the visitor interface since a Java SE 8
 * language feature cannot be used to this version of the API since
 * this version is required to be runnable on Java SE 7
 * implementations.  Future versions of the API that are only required
 * to run on Java SE 8 and later may take advantage of default methods
 * in this situation.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see ElementKindVisitor7
 * @see ElementKindVisitor8
 * @since 1.6
 */
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ElementKindVisitor6<R, P>
        extends SimpleElementVisitor6<R, P>
{

    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected ElementKindVisitor6()
    {
        super(null);
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected ElementKindVisitor6(R defaultValue)
    {
        super(defaultValue);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The element argument has kind {@code PACKAGE}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public R visitPackage(PackageElement e, P p)
    {
        assert e.getKind() == javax.lang.model.element.ElementKind.PACKAGE : "Bad kind on PackageElement";
        return defaultAction(e, p);
    }

    /**
     * Visits a type element, dispatching to the visit method for the
     * specific {@linkplain javax.lang.model.element.ElementKind kind} of type, {@code
     * ANNOTATION_TYPE}, {@code CLASS}, {@code ENUM}, or {@code
     * INTERFACE}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of the kind-specific visit method
     */
    @Override
    public R visitType(javax.lang.model.element.TypeElement e, P p)
    {
        javax.lang.model.element.ElementKind k = e.getKind();
        switch (k)
        {
            case ANNOTATION_TYPE:
                return visitTypeAsAnnotationType(e, p);

            case CLASS:
                return visitTypeAsClass(e, p);

            case ENUM:
                return visitTypeAsEnum(e, p);

            case INTERFACE:
                return visitTypeAsInterface(e, p);

            default:
                throw new AssertionError("Bad kind " + k + " for TypeElement" + e);
        }
    }

    /**
     * Visits an {@code ANNOTATION_TYPE} type element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitTypeAsAnnotationType(javax.lang.model.element.TypeElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code CLASS} type element by calling {@code
     * defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitTypeAsClass(javax.lang.model.element.TypeElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits an {@code ENUM} type element by calling {@code
     * defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitTypeAsEnum(javax.lang.model.element.TypeElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits an {@code INTERFACE} type element by calling {@code
     * defaultAction}.
     * .
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitTypeAsInterface(TypeElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a variable element, dispatching to the visit method for
     * the specific {@linkplain javax.lang.model.element.ElementKind kind} of variable, {@code
     * ENUM_CONSTANT}, {@code EXCEPTION_PARAMETER}, {@code FIELD},
     * {@code LOCAL_VARIABLE}, {@code PARAMETER}, or {@code RESOURCE_VARIABLE}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of the kind-specific visit method
     */
    @Override
    public R visitVariable(javax.lang.model.element.VariableElement e, P p)
    {
        javax.lang.model.element.ElementKind k = e.getKind();
        switch (k)
        {
            case ENUM_CONSTANT:
                return visitVariableAsEnumConstant(e, p);

            case EXCEPTION_PARAMETER:
                return visitVariableAsExceptionParameter(e, p);

            case FIELD:
                return visitVariableAsField(e, p);

            case LOCAL_VARIABLE:
                return visitVariableAsLocalVariable(e, p);

            case PARAMETER:
                return visitVariableAsParameter(e, p);

            case RESOURCE_VARIABLE:
                return visitVariableAsResourceVariable(e, p);

            default:
                throw new AssertionError("Bad kind " + k + " for VariableElement" + e);
        }
    }

    /**
     * Visits an {@code ENUM_CONSTANT} variable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitVariableAsEnumConstant(javax.lang.model.element.VariableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits an {@code EXCEPTION_PARAMETER} variable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitVariableAsExceptionParameter(javax.lang.model.element.VariableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code FIELD} variable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitVariableAsField(javax.lang.model.element.VariableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code LOCAL_VARIABLE} variable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitVariableAsLocalVariable(javax.lang.model.element.VariableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code PARAMETER} variable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitVariableAsParameter(javax.lang.model.element.VariableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code RESOURCE_VARIABLE} variable element by calling
     * {@code visitUnknown}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code visitUnknown}
     *
     * @since 1.7
     */
    public R visitVariableAsResourceVariable(VariableElement e, P p)
    {
        return visitUnknown(e, p);
    }

    /**
     * Visits an executable element, dispatching to the visit method
     * for the specific {@linkplain javax.lang.model.element.ElementKind kind} of executable,
     * {@code CONSTRUCTOR}, {@code INSTANCE_INIT}, {@code METHOD}, or
     * {@code STATIC_INIT}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of the kind-specific visit method
     */
    @Override
    public R visitExecutable(javax.lang.model.element.ExecutableElement e, P p)
    {
        javax.lang.model.element.ElementKind k = e.getKind();
        switch (k)
        {
            case CONSTRUCTOR:
                return visitExecutableAsConstructor(e, p);

            case INSTANCE_INIT:
                return visitExecutableAsInstanceInit(e, p);

            case METHOD:
                return visitExecutableAsMethod(e, p);

            case STATIC_INIT:
                return visitExecutableAsStaticInit(e, p);

            default:
                throw new AssertionError("Bad kind " + k + " for ExecutableElement" + e);
        }
    }

    /**
     * Visits a {@code CONSTRUCTOR} executable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitExecutableAsConstructor(javax.lang.model.element.ExecutableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits an {@code INSTANCE_INIT} executable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitExecutableAsInstanceInit(javax.lang.model.element.ExecutableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code METHOD} executable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitExecutableAsMethod(javax.lang.model.element.ExecutableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * Visits a {@code STATIC_INIT} executable element by calling
     * {@code defaultAction}.
     *
     * @param e the element to visit
     * @param p a visitor-specified parameter
     *
     * @return the result of {@code defaultAction}
     */
    public R visitExecutableAsStaticInit(ExecutableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The element argument has kind {@code TYPE_PARAMETER}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public R visitTypeParameter(TypeParameterElement e, P p)
    {
        assert e.getKind() == ElementKind.TYPE_PARAMETER : "Bad kind on TypeParameterElement";
        return defaultAction(e, p);
    }

}
