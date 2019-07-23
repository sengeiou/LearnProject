package com.cocoa.p23.capter232;

/**
 * Created by sj on 16/9/29.
 */
public class Runner {


    public boolean flag = true;

    public void setFlag(boolean flag){
        this.flag  =  flag;
    }


    public void run (){

        while(flag){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runner is running");
        }
        System.out.println("stop");
    }




}
