import java.util.concurrent.locks.*;
public class MyService{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public void await(){
		try{
			lock.lock();	//java.lang.IllegalMonitorStateException
			System.out.println("A");
			condition.await();	
			System.out.println("B");
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}