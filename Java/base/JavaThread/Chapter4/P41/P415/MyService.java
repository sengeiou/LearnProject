import java.util.concurrent.locks.*;

public class MyService {
	public Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition(); 

	public void awaitA() {
		try {
			lock.lock();
			System.out.println("A" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
			condition.await();
			System.out.println("A" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}
	public void awaitB() {
		try {
			lock.lock();
			System.out.println("b" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
			condition.await();
			System.out.println("b" + Thread.currentThread().getName() + "===" + System.currentTimeMillis());
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}
	}


	public void signalAll(){
		try{
			lock.lock();
			condition.signalAll();			
		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}

}