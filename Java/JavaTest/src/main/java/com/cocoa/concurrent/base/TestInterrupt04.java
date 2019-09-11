package com.cocoa.concurrent.base;

public class TestInterrupt04 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(interrupted()){
            System.out.println("interrupted");
        }
        if(isInterrupted()){
            System.out.println("isInterrupted");
        }

        System.out.println("exit");
    }

    public static void main(String[] args) {
            TestInterrupt04  thread = new TestInterrupt04();
            thread.start();
            thread.interrupt();
    }


}
