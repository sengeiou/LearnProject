package com.cocoa.thread.mashibing;

public class Base01 {

    private Object o  = new Object();
    private int count = 10;

    public void start(){
        synchronized(o){
            count--;
            System.out.printf("exit");
        }
    }

    public static void main(String[] args){
            Base01  base01 = new Base01();
            base01.start();
    }

}
