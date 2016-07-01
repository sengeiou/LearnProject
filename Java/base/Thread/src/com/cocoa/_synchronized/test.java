package com.cocoa._synchronized;

/**
 *
 *
 *
 *
 *
 *
 */
public class test {
    public static void main(String[] args) {

        Person p = new Person();

        for (int i = 0; i < 3; i++) {
            NameThread nameThread = new NameThread(p);
            nameThread.setName(i + "");
            nameThread.start();

        }

        // 这里输出了  0  2  2   因为1 到里面进行了 sleep ，而后面的2 修改了name 变量
        //解决这个问题的办法是在changeName 方法前 加synchronized
        // 两个线程访问同一对象的同步方法 一定是线程安全的


    }
}
