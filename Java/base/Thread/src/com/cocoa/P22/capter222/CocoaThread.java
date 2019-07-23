package com.cocoa.P22.capter222;

/**
 * Created by sj on 16/9/7.
 */
public class CocoaThread implements Runnable {


    private Task task;

    public CocoaThread(Task task) {
        this.task = task;
    }


    @Override
    public void run() {
        task.doLongTask();
    }


}
