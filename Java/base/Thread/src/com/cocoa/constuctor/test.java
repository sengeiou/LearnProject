package com.cocoa.constuctor;

/**
 * 线程的创建 总结
 * 1 实现runnable 接口  比如下面的thread，
 * 2 继承Thread  比如下面的myThread
 *
 * thread1对象（thrad1 创建比较不常见，因为MyThread继承了Thread 从而也实现了Runnable 接口）
 */
public class test {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new MyRunnable());
        thread.start();

        Thread thread1 = new Thread(new MyThread());
        thread1.start();


    }
}
