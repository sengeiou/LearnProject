package com.cocoa.test.interf;

import java.util.Arrays;

/**
 * 1  接口中所有的方法都是public的，所有不需要在方法前加上public
 * 2  接口中可以定义常量，但是不能有实现方法
 * 3
 *
 *
 */
public class Main implements Comparable<Person>{

    public static void main(String[] args){

        int[]  a = {1,2,3,4};

        int[] b  = Arrays.copyOf(a,6);


        for(int t :b) {
            System.out.println(t);
        }


    }


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
