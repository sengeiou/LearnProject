package com.cocoa;

public class TestParent  implements  Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private String name;
    private int age;
    private TestChild child;


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

    public TestChild getChild() {
        return child;
    }

    public void setChild(TestChild child) {
        this.child = child;
    }
}
