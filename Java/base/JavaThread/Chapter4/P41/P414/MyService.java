import java.util.concurrent.locks.*;

public class MyService{

	private Lock lock = new ReentrantLock();

	public Condition condition = lock.newCondition();

	public void await(){
		try{
			lock.lock();
			System.out.println("await time =" + System.currentTimeMillis());
			condition.await();
		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}

	public void signal(){
		try{
			lock.lock();
			System.out.println("signal time = "+ System.currentTimeMillis());
			condition.signal();
		}finally{
			lock.unlock();
		}
	}

}