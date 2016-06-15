package com.cocoa.test;

/**
 * Created by Administrator on 2016/6/15.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {



    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.toString());
        e.printStackTrace(System.out);
        new Thread(new Main()).start();
    }
}
