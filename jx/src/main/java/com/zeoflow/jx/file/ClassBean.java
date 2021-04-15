package com.zeoflow.jx.file;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class ClassBean
{
    public String classPackage;
    public String className;

    public ClassBean(String classData)
    {
        int lastIndex = classData.lastIndexOf(".");
        if (lastIndex != -1)
        {
            this.classPackage = classData.substring(0, lastIndex);
            this.className = classData.substring(lastIndex + 1);
        } else {
            this.classPackage = classData;
            this.className = classData;
        }
    }

    public ClassBean(String classPackage, String className)
    {
        this.classPackage = classPackage;
        this.className = className;
    }

}
