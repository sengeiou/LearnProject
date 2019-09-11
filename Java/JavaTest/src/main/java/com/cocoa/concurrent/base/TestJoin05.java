package com.cocoa.concurrent.base;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestJoin05 extends Thread {

    public TestJoin05(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

    /**
     *   test  join(long millis)
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        TestJoin05 testJoin05 = new TestJoin05(String.valueOf(1));
        testJoin05.start();
        testJoin05.join(2 * 1000);
        System.out.println("test2 这段代码会在哪里执行？？？？");
    }

    /**
     * test  join()
     * @throws InterruptedException
     */
    public static void test1() throws InterruptedException {
        List<TestJoin05> lt = IntStream.range(0, 2)
                .mapToObj(index -> new TestJoin05(String.valueOf(index)))
                .collect(Collectors.toList());
        for (TestJoin05 item : lt) {
            item.start();
        }
        for (TestJoin05 item : lt) {
            item.join();
        }

        System.out.println("");
    }


}
