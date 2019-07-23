package com.cocoa.hashmap.test1.test2;

import java.util.Arrays;

/**
 * Created by sj on 17/7/18.
 */
public class Test {
    public static void main(String[] args) {
        String[] strArray = new String[10];

        for (int i = 0; i < 10; i++) {
            strArray[i] = i + "-";
        }

        String[] result = Arrays.copyOf(strArray, 20);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
