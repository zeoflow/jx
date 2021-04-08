package com.zeoflow.jx.file;

@SuppressWarnings({"unused", "RedundantSuppression"})
public class ClassBean
{
    public String classPackage;
    public String className;

    public ClassBean(String classData)
    {
        this.classPackage = classData.substring(0, classData.lastIndexOf("."));
        this.className = classData.substring(classData.lastIndexOf(".") + 1);
    }

    public ClassBean(String classPackage, String className)
    {
        this.classPackage = classPackage;
        this.className = className;
    }

}
