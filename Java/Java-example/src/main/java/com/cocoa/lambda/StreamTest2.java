package com.cocoa.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest2 {



    @Test
    public void test1() {
        // simple reduce
        Integer sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);


        Optional<Integer> integerOptional = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .reduce(Integer::sum);

        System.out.println(integerOptional);


        Optional<Integer> ageSum = getList().stream().map(Item::getAge).reduce(Integer::sum);
        System.out.println(ageSum);
    }

    @Test
    public void test2(){
        // simple collect
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream().collect(Collectors.toList());
        System.out.println(integerList);

       HashSet<Integer> integerHashSet = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println(integerHashSet);
    }


    @Test
    public void test3(){

    }








    public List<Item> getList(){
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("aa", 12));
        itemList.add(new Item("bb", 9));
        itemList.add(new Item("cc", 30));
        itemList.add(new Item("cc", 45));
        itemList.add(new Item("dd", 89));
        return itemList;
    }
}
