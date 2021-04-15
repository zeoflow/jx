/*
 * Copyright (C) 2021 ZeoFlow SRL
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zeoflow.test;

import android.os.Bundle;

import com.zeoflow.app.Activity;
import com.zeoflow.jx.file.JavaFile;
import com.zeoflow.jx.file.MethodSpec;
import com.zeoflow.jx.file.TypeName;
import com.zeoflow.jx.file.TypeSpec;

import java.io.IOException;

import javax.lang.model.element.Modifier;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String packageEx = "androidx.lifecycle.LiveData<java.util.List<java.lang.String>>";

        log("" + TypeName.get(String.class).contains(String.class));
        log("" + TypeName.get(packageEx).contains(String.class));
        log("" + TypeName.get("androidx.lifecycle.Observer").contains(String.class));
        log("" + TypeName.get(packageEx).disassemble().disassemble().disassemble().disassemble().toString());
        log("" + TypeName.get(packageEx).assemble("java.lang.String").assemble(String.class).toString());
        log("" + TypeName.get(String.class).assemble(Activity.class, true).toString());
        log("" + TypeName.get(String.class).assemble(Activity.class, false).toString());

        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .addStatement("String<T> name")
                .build();

        MethodSpec main2 = MethodSpec.methodBuilder("getObs")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addParameter(TypeName.get("com.Observable<T>"), "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .addStatement("String<T> name")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld<Text, View>")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .addMethod(main2)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        try
        {
            javaFile.writeTo(System.out);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}