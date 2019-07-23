package com.cocoa.classloader;

public class TestClassLoader {

    public static void main(String[] args) throws Exception{
        Class cls  = Class.forName("java.util.Date");
        System.out.println( cls.getClassLoader());
        System.out.println("我们会发现，上面打印的是null");

        cls = Class.forName("com.cocoa.classloader.TestClassLoader");
        System.out.println(cls.getClassLoader());
        System.out.println("而我们自定义的类，则能得到一个真实的 ClassLoader对象");

    }

}
