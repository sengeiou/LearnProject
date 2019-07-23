public class Test extends Thread{ 
	



	public static void main(String[] args)  {


        try{
            ThreadB b  =new ThreadB();
            ThreadA a  = new ThreadA(b);
            a.start();

            Thread.sleep(1000); 

            ThreadC c = new ThreadC(b);
            c.start();
// 输出结果            
// thread b is running1490877327018
// bService1490877328020
// thread b is running1490877332020
// 由于  ThreadA 释放了 ThreadB 的锁, 所以线程C 可以调用 ThreadB的 同步方法了
// 验证了 join 方法具有释放锁的特点。          

        }catch(Exception e){

        }
    }

    @Override
    public void run() {
        super.run();
    }
}