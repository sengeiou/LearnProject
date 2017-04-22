package com.company;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Main extends  Thread{
    static  String o  = new String("a");

    public static void main(String[] args)  {
//        try {
//
//
//                Main t = new Main();
//                t.start();
//                t.setName("hahah");
//                t.lock();
//                System.out.print("end");
//
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }

        String  s = "%7B%22jumpjson%22%3A+%7B%22clazz%22%3A+%22com.kqc.b2b.ui.user.carRes.CarResourceManagerActivity%22%2C%22name%22%3A+%22%E8%BD%A6%E6%BA%90%E7%AE%A1%E7%90%86%22%2C%22params%22%3A+%5B%5D%2C%22jump%22%3A+%220%22%7D%2C%22displaytext%22%3A+%22%5B%7B%22value%22%3A%22%E6%82%A8%E6%9C%89%22%2C%22color%22%3A%22FFFFFFF%22%2C%22font%22%3A%2217%22%7D%2C%7B%22value%22%3A%22%E5%A4%A9%E7%B1%81%C2%B7%E5%85%AC%E7%88%B5+2016%E6%AC%BE+2.5+%E6%97%A0%E7%BA%A7+XV+%E5%B0%8A%E4%BA%AB%E7%89%88%22%2C%22color%22%3A%22FFFFFFF%22%2C%22font%22%3A%2217%22%7D%2C%7B%22value%22%3A%22%E7%AD%89%22%2C%22color%22%3A%22FFFFFFF%22%2C%22font%22%3A%2217%22%7D%2C%7B%22value%22%3A28%2C%22color%22%3A%22FFFFFFF%22%2C%22font%22%3A%2217%22%7D%2C%7B%22value%22%3A%22%E4%B8%AA%E5%9C%A8%E5%94%AE%E8%BD%A6%E6%BA%90%E5%90%8C%E6%AD%A5%E5%88%B0%E4%BA%86%E8%BD%A6%E6%BA%90%E5%AE%9D%22%2C%22color%22%3A%22FFFFFFF%22%2C%22font%22%3A%2217%22%7D%5D%22%7D";
        try {
            System.out.println(URLDecoder.decode(s,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public synchronized  void lock() throws InterruptedException {
        while(isAlive()){
            wait(0);
        }
    }



    @Override
    public void run() {
        super.run();
        try {

            int i = 10;
            while( i > 5) {
                i--;
                System.out.println("===="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
