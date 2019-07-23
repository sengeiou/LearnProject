package com.cocoa;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 *  本项目的代码基于 java多线程编程核心技术
 *
 *
 *
 */
public class test {

    public static void main(String[] args) throws Exception {

        //fix-22118f6a710eb5f47cb4351155afc24d.apatch
//        JarFile jarFile = new JarFile(new File("D:\\my_github\\LearmProject\\Java\\base\\Thread\\src\\com\\cocoa\\fix-22118f6a710eb5f47cb4351155afc24d.apatch"));
//
//
//        JarEntry jarExtry = jarFile.getJarEntry("META-INF/PATCH.MF");
//
//        InputStream inputStream = jarFile.getInputStream(jarExtry);
//
//        BufferedInputStream reader = new BufferedInputStream(inputStream);
//        int i = 0;
//        while ((i = reader.read()) != -1) {
//            System.out.print((char) i);
//        }
//
//
//        Class clazz = test.class;
//
//        Field[] fields = clazz.getDeclaredFields();
//        for(Field f: fields){
//            System.out.println(f.toString());
//        }

//        Random random = new Random();


//        for (int i = 1; i < 100 ; i++) {
////            System.out.println((char) i);

//        }

//           System.out.println(File.separator);
//        downloadPatch("http://www.baidu.com/asjdkas/dasd/aa.apatch");
//        downloadPatch("http://www.baidu.com/bb.apatch");
//        downloadPatch("http://www.baidu.com/asda/bb.apatch");


        ThreadLocal<String>  threadLocal = new ThreadLocal<String>(){

            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };

//        threadLocal.set("main");
        String result  = threadLocal.get();

        new Thread(){
            @Override
            public void run() {
                super.run();
                String result  = threadLocal.get();
                System.out.println(result+"at child thread");
            }
        }.start();

        System.out.println(result+"at main thread");

        ArrayList


    }

    public  static  void downloadPatch(String patchUrl) {
        if ( TextUtils.isEmpty(patchUrl)) {
            return;
        }

        String[] patchNameArray = patchUrl.split("\\/");

        if (patchNameArray == null || patchNameArray.length < 2) {
            return;
        }

        String patchName = patchNameArray[patchNameArray.length - 1];

        if (TextUtils.isEmpty(patchName)) {
            return;
        }

        System.out.println(patchUrl +"-----"+ patchName);
    }



    private static  final int tag =1;


    public void hjahaha(){

    }


}
