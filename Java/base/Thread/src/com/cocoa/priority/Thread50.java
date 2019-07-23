package com.cocoa.priority;

/**
 * Created by Administrator on 2016/7/1.
 */


public class Thread50 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i +"----"+getName()+"=====p"+getPriority());
        }

    }
}
