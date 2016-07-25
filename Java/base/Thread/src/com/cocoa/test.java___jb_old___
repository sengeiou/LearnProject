package com.cocoa;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Administrator on 2016/7/14.
 */
public class test {

    public static void main(String[] args) throws Exception {

        //fix-22118f6a710eb5f47cb4351155afc24d.apatch
        JarFile jarFile = new JarFile(new File("D:\\my_github\\LearmProject\\Java\\base\\Thread\\src\\com\\cocoa\\fix-22118f6a710eb5f47cb4351155afc24d.apatch"));


        JarEntry jarExtry = jarFile.getJarEntry("META-INF/PATCH.MF");

        InputStream inputStream = jarFile.getInputStream(jarExtry);

        BufferedInputStream reader = new BufferedInputStream(inputStream);
        int i = 0;
        while ((i = reader.read()) != -1) {
            System.out.print((char) i);
        }


        Class clazz = test.class;

        Field[] fields = clazz.getDeclaredFields();
        for(Field f: fields){
            System.out.println(f.toString());
        }


    }





    private static  final int tag =1;


    public void hjahaha(){

    }


}
