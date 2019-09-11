package com.cocoa.thread;

import java.util.stream.IntStream;

public class Stop002 {

    public static void main(String[] args) {
        Stop002 stop002 = new Stop002();
        stop002.test1();
    }



    public void test1(){
        IntStream.range(0,10).boxed().map( i -> new Thread( () -> {
            System.out.println(Thread.currentThread().getName());
        })).forEach(Thread::start);
    }


}
