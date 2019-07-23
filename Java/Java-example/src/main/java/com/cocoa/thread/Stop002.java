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





// 查看jdk 的源码发现，  interrupted 获取的是当前线程是否终止， 清除标记，多次调用后就会发现
//                    isInterrupted 获取的是调用线程的是否中，不清除标记

//    public static boolean interrupted() {
//        return currentThread().isInterrupted(true);
//    }
//
//    public boolean isInterrupted() {
//        return isInterrupted(false);
//    }
//    private native boolean isInterrupted(boolean ClearInterrupted);


}
