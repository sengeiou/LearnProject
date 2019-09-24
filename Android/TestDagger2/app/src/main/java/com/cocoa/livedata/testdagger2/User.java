package com.cocoa.livedata.testdagger2;

/**
 * Created by junshen on 2018/2/22.
 */

public class User {
    private String name;
    private int age;

    public User(){

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
