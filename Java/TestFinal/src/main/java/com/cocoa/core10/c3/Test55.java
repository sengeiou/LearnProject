package com.cocoa.core10.c3;

public class Test55 {

    public static void main(String[] args){
        int i  = 7;
        int k  = 7;

        System.out.println("先乘后++");
        System.out.println(i++ * 2 );
        System.out.println("先++后乘");
        System.out.println(++k * 2 );

        System.out.println("------------");

        System.out.printf("the i = %s and k = %s",i,k);


    }


}
