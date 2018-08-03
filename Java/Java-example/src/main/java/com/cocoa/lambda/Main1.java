package com.cocoa.lambda;

import java.util.function.Consumer;
import java.util.Comparator;


public class Main1 {

    public static void main(String[] args) {
        // 语法格式一 无参数 无返回值  () ->
        Runnable myRunnable = () -> {
            System.out.println("this is lambda");
            System.out.println(Thread.currentThread().getName());
        };
        Thread t = new Thread(myRunnable);
        t.start();

        // 语法格式二 有一个参数，无返回值

        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };
        consumer.accept("cocoa");

        // 有两个参数，有返回值
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("this is print");
            return Integer.compare(x, y);
        };
        int result = comparator.compare(1, 2);
        System.out.println(result);
    }

}
