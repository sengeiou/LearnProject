package com.cocoa.concurrent.base;


public class TestConstructor01 {

    public static void main(String[] args) {

        //阿实践活动好
        ThreadGroup threadGroup = new ThreadGroup("group-name");

        Thread thread = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(100 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getThreadGroup());
                System.out.println(Thread.currentThread().getName());
            }
        });


        thread.start();
        System.out.println("thread.getId==" + thread.getId());


    }

}
