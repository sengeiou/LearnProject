package com.cocoa.base.scjp.lesson8;

public class Test {


    public int x = 10;

    public void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {


        InnerClass innerClass1 = new Test().new InnerClass();

        Test test = new Test();
        System.out.println(test);
        InnerClass innerClass = test.new InnerClass();
        innerClass.showValues();

    }

    class InnerClass {

        public int x = 20;
        public void showValues (){
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Test.this.x);
            System.out.println(Test.this);
        }

    }

    static class InnerStaticClass {

    }

}
