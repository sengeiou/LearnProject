package com.cocoa.P22.capter222;

/**
 * Created by sj on 16/9/7.
 */
public class Task {

    public void doLongTask() {


        System.out.println("start");
        synchronized (this) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {

            }
        }
        System.out.println("finish");

    }


}
