import java.util.concurrent.locks.*;


/*
* 如果m1 方式始终不释放锁，m2方法则无法运行，可以调用 lockInterruptibly() 方法来打断m2 
*
*
*/

public class Test2 {

	private ReentrantLock lock = new ReentrantLock();

	private void m1() {
		lock.lock();
		try {
			//getHoldCount ===> Queries the number of holds on this lock by the current thread.	
			System.out.println("the hold counnt "+ lock.getHoldCount());

			Thread.sleep(3000);
		} catch (Exception e) {

		} finally {
			lock.unlock();
			System.out.println("the hold counnt "+ lock.getHoldCount());

		}
	}

	private void m2() {

		boolean locked = lock.tryLock();  // 尝试去锁，如果拿不到锁，也可以执行，根据返回的值来执行后续的操作
//还可以使用这个重载的方法，等待一定的时间，尝试去锁
// public boolean tryLock(long timeout,   
//               TimeUnit unit)
//                 throws InterruptedException

		System.out.println("the locked is %s" + locked);
	
		if (locked){
			lock.unlock();
		}

	}



	public static void main (String[] args) throws Exception {
		Test2 t2 = new Test2();
		new Thread(new Runnable() {
			public void run() {
				t2.m1();
			}
		},"cocoa Thread 2").start();

		new Thread(new Runnable() {
			public void run() {
				t2.m2();
			}
		}).start();
	}

}