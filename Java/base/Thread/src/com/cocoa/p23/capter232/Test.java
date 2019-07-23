package com.cocoa.p23.capter232;

/**
 * Created by sj on 16/9/29.
 */
public class Test {

    public static void main(String[] args) {

        Runner runner = new Runner();

        new Thread() {
            @Override
            public void run() {
                super.run();
                runner.run();
            }
        }.start();

        runner.setFlag(false);


    }


}
