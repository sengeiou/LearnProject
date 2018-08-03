package com.cocoa.lambda;

import org.junit.Test;

import java.util.Arrays;

public class Practice {

    /**
     *  练习1. 给定一个数组 【1,2,3,4,5】，输出 【1，4，9，16，25】
     */
    @Test
    public void test1(){
        Arrays.asList(1,2,3,4,5)
                .stream()
                .map(x -> x*x )
                .forEach(System.out::println);
    }


}
