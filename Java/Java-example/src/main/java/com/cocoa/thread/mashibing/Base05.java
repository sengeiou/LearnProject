package com.cocoa.thread.mashibing;

public class Base05 implements Runnable {

    private int count = 10;

    @Override
    public void run() {
        count--;
        System.out.println("count=" + count);
    }

    /**
     * 输出 88765   ,解决办法，run 方法加锁
     * @param args
     */
    public static void main(String[] args) {
        Base05 base05 = new Base05();
        for (int i = 0; i < 5; i++) {
            new Thread(base05).start();
        }
    }

}
