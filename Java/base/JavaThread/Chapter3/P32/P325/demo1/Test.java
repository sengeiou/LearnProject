public class Test extends Thread{ 
	



	public static void main(String[] args)  {


        try{
            ThreadB b  =new ThreadB();
            ThreadA a  = new ThreadA(b);
            a.start();

            Thread.sleep(1000); 

            ThreadC c = new ThreadC(b);
            c.start();

            // 在 ThreadA 中 使用 Thread.sleep 方法，一直持有 ThreadB 对象的锁， 时间达到了6秒
            // 所以 ThreadC 只有在 ThreadA 释放掉 ThreadB 的锁时，才可以调用 ThreadB 中的同步方法 bService
            // 所以验证 sleep 不释放锁


        }catch(Exception e){

        }
    }

    @Override
    public void run() {
        super.run();
    }
}