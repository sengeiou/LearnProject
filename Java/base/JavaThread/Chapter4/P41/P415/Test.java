/**
* 共用一个 condition 唤醒多个线程
* 看代码，没什么好解释的
*  
*
*
*
*/
public class Test{
	public static void main(String[] args)throws Exception{
		MyService myService = new MyService();

		ThreadA a = new ThreadA(myService);
		a.setName("thread a");
		a.start();

		ThreadB b = new ThreadB(myService);
		b.setName("thread b");
		b.start();

		Thread.sleep(3000);
		myService.signalAll();
	}
}