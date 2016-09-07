package com.cocoa;

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

        Random random = new Random();


        for (int i = 0; i < 100 ; i++) {
            System.out.println((char) (random.nextInt(100)+40));
        }


    }





    private static  final int tag =1;


    public void hjahaha(){

    }


}
