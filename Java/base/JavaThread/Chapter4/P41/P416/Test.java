public class Test{
	public static void main(String[] args)throws Exception{
		MyService myService = new MyService();

		ThreadA  a  = new ThreadA(myService);
		a.setName("a");
		a.start();

		ThreadB  b  = new ThreadB(myService);
		b.setName("b");
		b.start();

		Thread.sleep(3000);
		myService.signalAll_A();
   
		// 在这个demo 中，只有线程 a 被唤醒了P		


	}
}