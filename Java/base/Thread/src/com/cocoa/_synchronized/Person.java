package com.cocoa._synchronized;

/**
 * Created by Administrator on 2016/7/1.
 */
public class Person {

    private String name;

    public  void changeName(String pname ){

        if("1".equals(pname)){
            this.name = pname;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{
            this.name = pname;


        }

        System.out.println(this.name);


    }



}
