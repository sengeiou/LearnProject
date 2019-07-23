package com.cocoa.test;



// 使用 UnCaughtExceptionHandler
public class Main2 implements Runnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new Main2());
        thread.start();



    }

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new CrashHandler());
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("1234"));
        System.out.println(Integer.parseInt("1235"));
        System.out.println(Integer.parseInt("xxx"));
        System.out.println(Integer.parseInt("111"));
        System.out.println(Integer.parseInt("222"));
    }
}
