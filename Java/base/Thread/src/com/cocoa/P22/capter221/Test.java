package com.cocoa.P22.capter221;

import com.cocoa.priority.Thread50;

/**
 * Created by sj on 16/9/7.
 * synchronized 是有弊端的,A线程调用同步方法执行很长时间的任务,B 就必须等待这段时间
 * 碰到这样的情况,可以用同步语句块解决
 *
 *
 *
 */
public class Test {

    public static void main(String[] args) {

        // 首先创建有弊端的程序  synchronized 修饰方法
        Task task = new Task();
        CocoaThread t1 =  new CocoaThread(task);
        CocoaThread t2 =  new CocoaThread(task);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();

        // 从打印中可以看出,第2个线程的执行,需要等第一个线程的结束后才能开始




    }


}
