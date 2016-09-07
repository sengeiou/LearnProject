package com.cocoa.P22.capter221;

/**
 * Created by sj on 16/9/7.
 */
public class Task {

    public synchronized void doLongTask(){

        System.out.println("start");
        try{
            Thread.sleep(10000);
        }catch (Exception e){

        }
        System.out.println("finish");

    }


}
