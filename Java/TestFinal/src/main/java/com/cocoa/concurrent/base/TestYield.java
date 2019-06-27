package com.cocoa.concurrent.base;

public class TestYield extends Thread {

    public TestYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        if (Thread.currentThread().getName().equals("cocoa")) {
            Thread.yield();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            TestYield testYield = null;
            if (i == 0) {
                testYield = new TestYield("cocoa");
            } else {
                testYield = new TestYield("thread" + i);
            }
            testYield.start();
        }
    }


}
