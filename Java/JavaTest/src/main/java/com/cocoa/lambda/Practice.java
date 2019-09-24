package com.cocoa.lambda;

import org.junit.Test;

import java.util.Arrays;

public class Practice {

    @Test
    public void test1(){
        Arrays.asList(1,2,3,4,5)
                .stream()
                .map(x -> x*x )
                .forEach(System.out::println);
    }


}
