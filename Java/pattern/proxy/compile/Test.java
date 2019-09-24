import javax.tools.*;
import java.io.*;
import java.util.Arrays;
import java.net.*;


public class Test{


    public static void main(String[] args) throws Exception{

        String str =

        "package com.cocoa.compile;"+
        "public class TestCompile{"+

            "public static void main(String[] args){"+

                "System.out.println(\"Hello World\");"+

            "}"+

        "}";

        System.out.println(System.getProperty("user.dir"));

        String packagePath =  System.getProperty("user.dir") + "/com/cocoa/compile";

        File filePath  = new File(packagePath);
        File file = new File(filePath,"TestCompile.java");

        if(!filePath.exists()){
          filePath.mkdirs();

        }
        file.createNewFile();
        // create java file
        FileWriter writer = new FileWriter(file);

        writer.write(str);
        writer.close();


        // compile class file

        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        System.out.println(javac);

        StandardJavaFileManager fileManager = javac.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> compilationUnits1 =
                  fileManager.getJavaFileObjects(file);
        javac.getTask(null, fileManager, null, null, null, compilationUnits1).call();

        fileManager.close();


        // load class

        URL[]  urls = {new URL("file:/"+System.getProperty("user.dir"))};

        System.out.println(urls[0].toString());


        URLClassLoader  classLoader = new URLClassLoader(urls);

        Class clazz =   classLoader.loadClass("com.cocoa.compile.TestCompile");  // 要特别注意这个package  ，要和文件的一致

        System.out.println(clazz.getName());

        TestCompile t =  (TestCompile) clazz.	newInstance();

        t.main(null);




    }

}
