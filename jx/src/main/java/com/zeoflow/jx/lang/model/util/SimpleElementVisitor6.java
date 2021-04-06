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

package com.zeoflow.jx.lang.model.util;

import javax.lang.model.SourceVersion;
import com.zeoflow.jx.lang.model.element.Element;
import com.zeoflow.jx.lang.model.element.ElementKind;
import com.zeoflow.jx.lang.model.element.ExecutableElement;
import com.zeoflow.jx.lang.model.element.PackageElement;
import com.zeoflow.jx.lang.model.element.TypeElement;
import com.zeoflow.jx.lang.model.element.TypeParameterElement;
import com.zeoflow.jx.lang.model.element.VariableElement;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * A simple visitor of program elements with default behavior
 * appropriate for the {@link SourceVersion#RELEASE_6 RELEASE_6}
 * source version.
 * <p>
 * Visit methods corresponding to {@code RELEASE_6} language
 * constructs call {@link #defaultAction defaultAction}, passing their
 * arguments to {@code defaultAction}'s corresponding parameters.
 * <p>
 * For constructs introduced in {@code RELEASE_7} and later, {@code
 * visitUnknown} is called instead.
 *
 * <p> Methods in this class may be overridden subject to their
 * general contract.  Note that annotating methods in concrete
 * subclasses with {@link java.lang.Override @Override} will help
 * ensure that methods are overridden as intended.
 *
 * <p> <b>WARNING:</b> The {@code ElementVisitor} interface
 * implemented by this class may have methods added to it in the
 * future to accommodate new, currently unknown, language structures
 * added to future versions of the Java&trade; programming language.
 * Therefore, methods whose names begin with {@code "visit"} may be
 * added to this class in the future; to avoid incompatibilities,
 * classes which extend this class should not declare any instance
 * methods with names beginning with {@code "visit"}.
 *
 * <p>When such a new visit method is added, the default
 * implementation in this class will be to call the {@link
 * #visitUnknown visitUnknown} method.  A new simple element visitor
 * class will also be introduced to correspond to the new language
 * level; this visitor will have different default behavior for the
 * visit method in question.  When the new visitor is introduced, all
 * or portions of this visitor may be deprecated.
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
 * @param <R> the return type of this visitor's methods.  Use {@code Void}
 *            for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's methods.  Use {@code Void}
 *            for visitors that do not need an additional parameter.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @see SimpleElementVisitor7
 * @see SimpleElementVisitor8
 * @since 1.6
 */
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class SimpleElementVisitor6<R, P> extends AbstractElementVisitor6<R, P>
{

    /**
     * Default value to be returned; {@link #defaultAction
     * defaultAction} returns this value unless the method is
     * overridden.
     */
    protected final R DEFAULT_VALUE;

    /**
     * Constructor for concrete subclasses; uses {@code null} for the
     * default value.
     */
    protected SimpleElementVisitor6()
    {
        DEFAULT_VALUE = null;
    }

    /**
     * Constructor for concrete subclasses; uses the argument for the
     * default value.
     *
     * @param defaultValue the value to assign to {@link #DEFAULT_VALUE}
     */
    protected SimpleElementVisitor6(R defaultValue)
    {
        DEFAULT_VALUE = defaultValue;
    }
    /**
     * The default action for visit methods.  The implementation in
     * this class just returns {@link #DEFAULT_VALUE}; subclasses will
     * commonly override this method.
     *
     * @param e the element to process
     * @param p a visitor-specified parameter
     *
     * @return {@code DEFAULT_VALUE} unless overridden
     */
    protected R defaultAction(Element e, P p)
    {
        return DEFAULT_VALUE;
    }

    /**
     * {@inheritDoc} This implementation calls {@code defaultAction}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of {@code defaultAction}
     */
    public R visitPackage(PackageElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * {@inheritDoc} This implementation calls {@code defaultAction}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of {@code defaultAction}
     */
    public R visitType(TypeElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation calls {@code defaultAction}, unless the
     * element is a {@code RESOURCE_VARIABLE} in which case {@code
     * visitUnknown} is called.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of {@code defaultAction} or {@code visitUnknown}
     */
    public R visitVariable(VariableElement e, P p)
    {
        if (e.getKind() != ElementKind.RESOURCE_VARIABLE)
            return defaultAction(e, p);
        else
            return visitUnknown(e, p);
    }

    /**
     * {@inheritDoc} This implementation calls {@code defaultAction}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of {@code defaultAction}
     */
    public R visitExecutable(ExecutableElement e, P p)
    {
        return defaultAction(e, p);
    }

    /**
     * {@inheritDoc} This implementation calls {@code defaultAction}.
     *
     * @param e {@inheritDoc}
     * @param p {@inheritDoc}
     *
     * @return the result of {@code defaultAction}
     */
    public R visitTypeParameter(TypeParameterElement e, P p)
    {
        return defaultAction(e, p);
    }

}
