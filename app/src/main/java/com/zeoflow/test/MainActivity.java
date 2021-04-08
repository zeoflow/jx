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
import com.zeoflow.jx.file.TypeName;

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
    }

}