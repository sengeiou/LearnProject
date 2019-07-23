package com.cocoa.lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;


import java.util.function.Function;
import java.util.function.Predicate;

public class Main2 {

    @Test
    public void test1() {
        // java.util.function.consumer
        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };
        consumer.accept("coaoa");
    }

    @Test
    public void test2() {
        // Supplier
        Supplier<Long> supplier = () -> System.currentTimeMillis();
        System.out.println(supplier.get());
    }

    @Test
    public void test3() {
        // function
        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("123"));
    }


    @Test
    public void test4() {
        // prdicate
        Predicate<String> predicate = (str) -> str.length() > 0;
        System.out.println(predicate.test(""));
        "".replaceAll("\\.","\\/");
    }


}
