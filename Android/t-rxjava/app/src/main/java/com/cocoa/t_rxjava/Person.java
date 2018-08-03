package com.cocoa.t_rxjava;

import java.util.List;

/**
 * Created by junshen on 2018/1/2.
 */

public class Person {

    public String name;
    public List<String> books;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
