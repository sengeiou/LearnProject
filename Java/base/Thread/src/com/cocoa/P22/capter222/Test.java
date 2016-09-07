package com.cocoa.P22.capter222;

/**
 * sychronized 同步代码块的使用
 *
 *
 *
 *
 */
public class Test {


    public static void main(String[] args) {


        // 修改了task 的方法 只对部分代码进行同步
        // 223 和  224的例子就不写了,其实都是类似的
        Task task = new Task();
        CocoaThread t1 =  new CocoaThread(task);
        CocoaThread t2 =  new CocoaThread(task);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);

        thread1.start();
        thread2.start();




    }

}
