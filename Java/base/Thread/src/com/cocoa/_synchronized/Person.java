package com.cocoa._synchronized;

/**
 * Created by Administrator on 2016/7/1.
 */
public class Person {

    private String name;

    public synchronized void changeName(String pname ){
        //String name = "";
        if("1".equals(pname)){
            name = pname;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{
            name = pname;
        }

        System.out.println(name);


    }



}
