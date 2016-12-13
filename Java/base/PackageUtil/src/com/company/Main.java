package com.company;

import java.io.File;
import java.lang.reflect.Method;

public class Main {
    static File parentFile = new File("/Users/sj/Documents/kqc_pro/b2b-ii-android/app/build/intermediates/classes/dev/debug");


    public static void main(String[] args) {
//        if (parentFile.exists()) {
//            listDir(parentFile);
//        }


        try {
            Class clazz = Main.class;
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                System.out.println("方法名称:" + methodName);
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> clas : parameterTypes) {
                    String parameterName = clas.getName();
                    System.out.println("参数名称:" + parameterName);
                }
                System.out.println("*****************************");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void listDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                listDir(f);
            }
        } else {
            if (isRealPage(file.getName()) && file.toString().contains(parentFile.toString())) {
                String str = file.toString().replace(parentFile.toString()+File.separator, "");
                System.out.println(str.replace(File.separator,".").replace(".class",""));
            }
        }
    }


    public static boolean isRealPage(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            return false;
        }
        if (fileName.startsWith("R") || fileName.contains("$$ViewBinder") || fileName.contains("Cst")) {
            return false;
        }
        return true;
    }


}
