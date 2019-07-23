package com.cocoa.generics.Ginterface;



//
//public class Test implements Generator<String> {
//
//
//    public String next() {
//        return null;
//    }
//}


//这里发现，泛型接口的定义加上类本身的泛型，使得这个程序变得更加的灵活
public class Test<T> implements Generator<T> {

    public T next() {
        return null;
    }

}