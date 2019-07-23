package com.cocoa.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHash {

    @Test
    public void test1(){
        Person p1 = new Person();
        p1.setName("cocoa");
        p1.setCode("code");
        p1.setAge(12);

        Person p2 = new Person();
        p2.setName("cocoa");
        p2.setCode("code");
        p2.setAge(12);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p2.equals(p1));


        Map<Person,String> map = new HashMap<>();

        map.put(p1,"p1");
        map.put(p2,"p2");
        map.put(p1,"p1");

        System.out.println(map.size());




    }

}
