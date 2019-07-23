/**
*  使用reentrantLock 锁住m1方法，m1结束后释放锁，在调用m2方法
*			
*
*/
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class Test1 {

	volatile int a = 10;

	private Lock lock = new ReentrantLock();


	private void m1() throws Exception {
		
		lock.lock();
		System.out.println("m1 is start");
		Thread.sleep(2000);

		lock.unlock();
		//使用sychronized，如果程序中遇到异常退出，则解锁，
		//而reentrantLock则不会，所以unlock 一般要写在 finally 里面，但是我这里抛出了异常，所以。。。
		System.out.println("m1 is finish");
	}

	private void m2() throws Exception {
		lock.lock();
		System.out.println("m2 is start");
		Thread.sleep(2000);
		lock.unlock();
		System.out.println("m2 is finish");
	}


	public static void main(String[] args) throws Exception {

		Test1 t1 = new Test1();
		new Thread(new Runnable() {

			public void run() {
				try {
					t1.m1();
				} catch (Exception e) {

				}
			};
		}).start();


		new Thread(new Runnable() {

			public void run() {
				try {
					t1.m2();
				} catch (Exception e) {

				}
			};
		}).start();
	}
}