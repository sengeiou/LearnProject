import java.util.concurrent.locks.*;
public class MyService {
	private Lock lock = new ReentrantLock();

	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();


	public void awaitA() {
		try {
			lock.lock();
			System.out.println("a" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
			conditionA.await();
			System.out.println("a" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}

	public void awaitB() {
		try {
			lock.lock();
			System.out.println("b" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
			conditionB.await();
			System.out.println("b" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());

		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}


	public void signalAll_A() {
		try {
			lock.lock();
			conditionA.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void signalAll_B() {
		try {
			lock.lock();
			conditionB.signalAll();
		} finally {
			lock.unlock();
		}
	}
}