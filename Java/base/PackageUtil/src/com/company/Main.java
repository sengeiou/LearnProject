package com.company;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main extends Thread{
    static File parentFile = new File("/Users/sj/Documents/kqc_pro/b2b-ii-android/app/build/intermediates/classes/dev/debug");

    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

        @Override
        protected String initialValue() {
            // 设置初始值，这里使用当前thread的名字
            return Thread.currentThread().getName();
        }

    };

    public static void main(String[] args) {
//        if (parentFile.exists()) {
//            listDir(parentFile);
//        }

        ArrayList


//        try {
//            Class clazz = Main.class;
//            Method[] methods = clazz.getDeclaredMethods();
//            for (Method method : methods) {
//                String methodName = method.getName();
//                System.out.println("方法名称:" + methodName);
//                Class<?>[] parameterTypes = method.getParameterTypes();
//                for (Class<?> clas : parameterTypes) {
//                    String parameterName = clas.getName();
//                    System.out.println("参数名称:" + parameterName);
//                }
//                System.out.println("*****************************");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




            // threadLocal.set("main");

            Main test = new Main();
            test.start();//在子线程中获取

            //在主线程中获取
            String result = threadLocal.get();
            System.out.println("main thread get str" + result);

    }

    @Override
    public void run() {
        threadLocal.set("123123");
        threadLocal.set("123123");
        String result = threadLocal.get();

        System.out.println("ThreadLocalTest thread get str" + result);
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
