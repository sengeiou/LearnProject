package com.cocoa.thread;

import org.junit.Test;

public class Base001 extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println(this.isAlive());
    }

    @Test
    public void test1(){
        System.out.println(Thread.currentThread().getName()); // main
    }

    @Test
    public void test2(){
        System.out.println(Thread.currentThread().getId());  //  1
    }

    @Test
    public void test3(){
        new Base001().start();
    }


}
