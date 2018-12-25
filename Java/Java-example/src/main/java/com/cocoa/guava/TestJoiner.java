package com.cocoa.guava;


import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class TestJoiner {

    @Test
    public void test1() {
        String[] ids = {"11111", "22222", "333333"};
        long s1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (String id : ids) {
            sb.append(id).append(",");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
        System.out.println(System.currentTimeMillis() - s1);

        System.out.println("---use guava---");

        long s2 = System.currentTimeMillis();
        String result = Joiner.on(",").useForNull("default value").join(1, 2, 3, 4);
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - s2);

    }

    @Test
    public void test2() {
        // mao joiner
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");


        Preconditions.checkNotNull(map,"map cant be null");

        Joiner.MapJoiner joiner = Joiner.on(",").withKeyValueSeparator("=");
        String result = joiner.join(map);
        System.out.println(result);
//        1=one,2=two,3=three

    }


}
