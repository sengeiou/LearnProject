package com.cocoa.concurrent.base;

import java.util.concurrent.TimeUnit;

public class TestSleep02 {


    public static void main(String[] args) {

        try {
            Thread.sleep(1000);
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
