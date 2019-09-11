package com.cocoa.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest1 {

    @Test
    public void test1() {
        // create stream

        // 1. Collection.stream
        List<String> list = new ArrayList<>();
        Stream stream = list.stream();

        // 2. Arrays.stream
        String[] array = new String[10];
        Stream<String> stream1 = Arrays.stream(array);

        // 3. stream.of
        Stream stream2 = Stream.of(1, 2, 3);

        // 4. String.interator
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x);
        stream3.forEach(System.out::println);
    }


    @Test
    public void test2() {
        //filter skip limit
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14)
                .filter((i) -> i % 2 == 0)
                .skip(2)
                .limit(3)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        String[] array = {"11", "22", "33", "44"};
        Arrays.stream(array)
                .map((x) -> Integer.parseInt(x) + 1)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("aa", 12));
        itemList.add(new Item("bb", 9));
        itemList.add(new Item("cc", 30));
        itemList.add(new Item("cc", 45));
        itemList.add(new Item("dd", 89));

//        itemList.stream()
//                .sorted((t1,t2) -> t2.name.compareTo(t1.name))
//                .forEach(System.out::println);

        // sorted by age asc
        itemList.stream()
                .sorted((t1, t2) -> {
                    if (t1.age == t2.age) {
                        return 0;
                    } else if (t1.age < t2.age) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .forEach(System.out::println);

    }

    @Test
    public void test5() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("aa", 12));
        itemList.add(new Item("bb", 9));
        itemList.add(new Item("cc", 30));
        itemList.add(new Item("cc", 45));
        itemList.add(new Item("dd", 89));

        Optional<Item> itemOptional = itemList.stream().sorted((t1, t2) -> {
            if (t1.age == t2.age) {
                return 0;
            } else if (t1.age < t2.age) {
                return -1;
            } else {
                return 1;
            }
        }).findFirst();
        System.out.println(itemOptional.get());

        boolean allMatch = itemList.stream().allMatch((i) -> i.age < 100);
        System.out.println(allMatch);


        long count = itemList.stream().filter((i) -> i.age > 10).count();
        System.out.println(count);

        Optional<Item> itemOptional1 = itemList.stream().max((t1, t2) -> t1.name.compareTo(t2.name));
        System.out.println(itemOptional1);
        
        Arrays.asList(1,2,3,4).stream().reduce(Math::max);


    }


}
