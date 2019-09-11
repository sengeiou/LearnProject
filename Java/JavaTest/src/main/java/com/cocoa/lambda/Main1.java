package com.cocoa.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main1 {

    public static void main(String[] args) {
        Runnable myRunnable = () -> {
            System.out.println("this is lambda");
            System.out.println(Thread.currentThread().getName());
        };
        Thread t = new Thread(myRunnable);
        t.start();


        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };
        consumer.accept("cocoa");

        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("this is print");
            return Integer.compare(x, y);
        };
        int result = comparator.compare(1, 2);
        System.out.println(result);

//        Item item = new Item("123123",12);
//        Stream st1 = Stream.generate(item::getName);
//        System.out.println(st1.count());

        int[] a = {1, 2, 3, 4};
        Stream stream1 = Stream.of(1, 2, 3, 4);
        stream1.forEach(System.out::println);


        // use Arrays.stream
        int[] intArray = {1, 2, 3};
        IntStream stream5 = Arrays.stream(intArray);
        stream5.forEach(System.out::print);
        System.out.println("");

        Predicate predicate = null;


    }

}
