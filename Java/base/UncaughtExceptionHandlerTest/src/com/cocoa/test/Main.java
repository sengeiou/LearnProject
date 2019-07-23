package com.cocoa.test;



// 没有使用 UnCaughtExceptionHandler
public class Main implements Runnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new Main());
        thread.start();



    }

    @Override
    public void run() {
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("1234"));
        System.out.println(Integer.parseInt("1235"));
        System.out.println(Integer.parseInt("xxx"));
        System.out.println(Integer.parseInt("111"));
        System.out.println(Integer.parseInt("222"));


    }
}
