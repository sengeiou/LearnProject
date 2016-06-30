package com.cocoa.tets;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/15.
 */
public class HashMapTest {

    // 理解hashmap
    /**
     * 1.HashMap 可以接受null 键和 null 值 ， 不是线程安全的
     *2
     *
     *
     *
     *
     *
     */


    public static void main(String[] args){
        String s1  = "123";
        String s2  = "124";
        String s3  = "125";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());


        HashMap<String,String>  hashMap = new HashMap<>();

        hashMap.put(s1,s1);
        hashMap.put(s2,s2);
        hashMap.put(s1,s1);


        double b = 10.0;
        Integer i = 10;



//        test(0);


    }


    public static void test(byte b){
        System.out.println(b);
    }







}
