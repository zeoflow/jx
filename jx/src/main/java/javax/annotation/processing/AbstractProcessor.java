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

package javax.annotation.processing;

import javax.lang.model.SourceVersion;

import com.zeoflow.jx.annotation.processing.Processor;
import com.zeoflow.jx.lang.model.element.AnnotationMirror;
import com.zeoflow.jx.lang.model.element.Element;
import com.zeoflow.jx.lang.model.element.ExecutableElement;
import com.zeoflow.jx.lang.model.element.TypeElement;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * An abstract annotation processor designed to be a convenient
 * superclass for most concrete annotation processors.  This class
 * examines annotation values to compute the {@linkplain
 * #getSupportedOptions options}, {@linkplain
 * #getSupportedAnnotationTypes annotation types}, and {@linkplain
 * #getSupportedSourceVersion source version} supported by its
 * subtypes.
 *
 * <p>The getter methods may {@linkplain Messager#printMessage issue
 * warnings} about noteworthy conditions using the facilities available
 * after the processor has been {@linkplain #isInitialized
 * initialized}.
 *
 * <p>Subclasses are free to override the implementation and
 * specification of any of the methods in this class as long as the
 * general {@link com.zeoflow.jx.annotation.processing.Processor Processor}
 * contract for that method is obeyed.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public abstract class AbstractProcessor implements Processor
{

    /**
     * Processing environment providing by the tool framework.
     */
    protected ProcessingEnvironment processingEnv;
    private boolean initialized = false;

    /**
     * Constructor for subclasses to call.
     */
    protected AbstractProcessor()
    {
    }
    private static Set<String> arrayToSet(String[] array)
    {
        assert array != null;
        Set<String> set = new HashSet<>(array.length);
        Collections.addAll(set, array);
        return Collections.unmodifiableSet(set);
    }
    /**
     * If the processor class is annotated with {@link
     * SupportedOptions}, return an unmodifiable set with the same set
     * of strings as the annotation.  If the class is not so
     * annotated, an empty set is returned.
     *
     * @return the options recognized by this processor, or an empty
     * set if none
     */
    public Set<String> getSupportedOptions()
    {
        SupportedOptions so = this.getClass().getAnnotation(SupportedOptions.class);
        if (so == null)
            return Collections.emptySet();
        else
            return arrayToSet(so.value());
    }
    /**
     * If the processor class is annotated with {@link
     * SupportedAnnotationTypes}, return an unmodifiable set with the
     * same set of strings as the annotation.  If the class is not so
     * annotated, an empty set is returned.
     *
     * @return the names of the annotation types supported by this
     * processor, or an empty set if none
     */
    public Set<String> getSupportedAnnotationTypes()
    {
        SupportedAnnotationTypes sat = this.getClass().getAnnotation(SupportedAnnotationTypes.class);
        if (sat == null)
        {
            isInitialized();
            return Collections.emptySet();
        } else
            return arrayToSet(sat.value());
    }
    /**
     * If the processor class is annotated with {@link
     * SupportedSourceVersion}, return the source version in the
     * annotation.  If the class is not so annotated, {@link
     * SourceVersion#RELEASE_6} is returned.
     *
     * @return the latest source version supported by this processor
     */
    public SourceVersion getSupportedSourceVersion()
    {
        SupportedSourceVersion ssv = this.getClass().getAnnotation(SupportedSourceVersion.class);
        SourceVersion sv;
        if (ssv == null)
        {
            sv = SourceVersion.RELEASE_6;
            isInitialized();
        } else
            sv = ssv.value();
        return sv;
    }
    /**
     * Initializes the processor with the processing environment by
     * setting the {@code processingEnv} field to the value of the
     * {@code processingEnv} argument.  An {@code
     * IllegalStateException} will be thrown if this method is called
     * more than once on the same object.
     *
     * @param processingEnv environment to access facilities the tool framework
     *                      provides to the processor
     *
     * @throws IllegalStateException if this method is called more than once.
     */
    public synchronized void init(ProcessingEnvironment processingEnv)
    {
        if (initialized)
            throw new IllegalStateException("Cannot call init more than once.");
        Objects.requireNonNull(processingEnv, "Tool provided null ProcessingEnvironment");

        this.processingEnv = processingEnv;
        initialized = true;
    }
    /**
     * {@inheritDoc}
     */
    public abstract boolean process(Set<? extends TypeElement> annotations,
                                    RoundEnvironment roundEnv);
    /**
     * Returns an empty iterable of completions.
     *
     * @param element    {@inheritDoc}
     * @param annotation {@inheritDoc}
     * @param member     {@inheritDoc}
     * @param userText   {@inheritDoc}
     */
    public Iterable<? extends Completion> getCompletions(Element element,
                                                         AnnotationMirror annotation,
                                                         ExecutableElement member,
                                                         String userText)
    {
        return Collections.emptyList();
    }
    /**
     * Returns {@code true} if this object has been {@linkplain #init
     * initialized}, {@code false} otherwise.
     *
     * @return {@code true} if this object has been initialized,
     * {@code false} otherwise.
     */
    protected synchronized boolean isInitialized()
    {
        return initialized;
    }

}
