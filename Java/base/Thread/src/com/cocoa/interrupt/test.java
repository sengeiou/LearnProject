package com.cocoa.interrupt;

/**
 *  线程的中断
 *  1可以调用 interrupt()方法来终止线程
 *  2在java 早期版本中，可以使用stop()方法来终止线程，但是这个方式是不安全的，所以后来被弃用了
 *  3当对一个线程调用 interrupt的时候， 该线程的《中断状态》将被改变，调用interrupt的时候，线程并不会停止，需要在线程中配合调用 isInterrupted()方法来判断
 *  4方法interrupted()是对判断当前的线程是否中断的，在主线程中，哪怕你对一个具体的线程调用，打印的也是主线程的状态，interrupted有清除状态的功能，调用一次后，状态会重置,
 *  查看代码块<1>thread5000.interrupted() 一直是输出 false  因为打印的是main线程的状态，除非加上Thread.currentThread().interrupt();
 *  5
 *
 *  总结
 *  -终止线程的方法
 *  1 使用退出标志
 *  2 调用 interrupt()  和   isInterrupted() ,搭配使用
 *
 *  - interrupted 是查看当前线程的终止状态，是一个静态方法，调用一次后，状态会被重置
 *  -  isInterrupted 是查看线程对象的终止状态，调用后，状态不会被重置
 *
 *
 */
public class test {

    public static void main(String[] args){

       /***************************<1>**********************/
        Thread5000 thread5000 = new Thread5000();
        thread5000.start();
        thread5000.interrupt();

      //  Thread.currentThread().interrupt();
        System.out.println(thread5000.interrupted());
        System.out.println(thread5000.interrupted());




        /***************************<1>**********************/

    }

}
