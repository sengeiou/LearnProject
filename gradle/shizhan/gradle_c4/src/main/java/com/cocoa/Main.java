package com.cocoa;

import java.util.concurrent.locks.ReentrantLock;

public class Main extends Thread {

    static final ReentrantLock reentrantLock1 = new ReentrantLock();

    public Main(String name) {
        setName(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            if (reentrantLock1.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " get lock !!");
                Thread.sleep(10 * 1000);
            } else {
                System.out.println(Thread.currentThread().getName() + "not get lock !!");
            }

        } catch (Exception e) {

        } finally {
            if (reentrantLock1.isHeldByCurrentThread()) {
                reentrantLock1.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " is done !!");
        }
    }

    public static void main(String[] args) {
        new Main("Thread1").start();
        new Main("Thread2").start();
        new Main("Thread3").start();
    }

}
