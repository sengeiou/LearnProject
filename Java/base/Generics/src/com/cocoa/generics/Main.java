package com.cocoa.generics;

/**
 *   泛型的简单用法
 *   在类名后加上<T> 或者 <T extends ParentClass>  或者<T，K>
 *   如果<T extends ParentClass>，那么T的类型必须是ParentClass的本身或它的之类
 *   如果要使用多个泛型，可以用逗号隔开，比如<T，K>
 *   常用的泛型符号有：T、E、K、V
 *
 */

public class Main {

    public static void main(String[] args) {
        Box<PClass> box = new Box<PClass>(new PClass());
        System.out.println(box.getData());
    }

    /**
     * 在这个例子中，个人理解是用泛型定义了data的类型，使得程序更加灵活
     *
     */
    static class Box<T extends PClass> {

        private T data;

        public Box(T t) {
            this.data = t;
        }

        public T getData(){
            return  data;
        }

    }
    static class PClass {

    }
}