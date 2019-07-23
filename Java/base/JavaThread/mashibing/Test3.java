import java.util.concurrent.locks.*;

/**
* 公平锁
*
*
*
*
*
*/
public class Test3 extends Thread {
	// ReentrantLock(true) ==> Creates an instance of ReentrantLock with the given fairness policy.
	// 创建一个具有公平政策的 ReentrantLock 实例 
	// 可以去掉 true 试下打印效果
	private static ReentrantLock lock = new ReentrantLock(true); 

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);	
			} catch (Exception e) {
					
			} finally {
				lock.unlock();
			}
		}
	}
	public static void main(String[] args) {
		Test3 t1 = new Test3();
		Test3 t2 = new Test3();
		Test3 t3 = new Test3();

		t1.start();
		t2.start();
		t3.start();
	}
}