package com.company;

public class Main extends  Thread{
    static  String o  = new String("a");

    public static void main(String[] args)  {
        try {


                Main t = new Main();
                t.start();
                t.setName("hahah");
                t.lock();
                System.out.print("end");

        }catch (Exception e){
            System.out.println(e.toString());
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
