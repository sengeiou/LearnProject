import java.util.concurrent.locks.*;
public class Service2{
	public ReentrantLock lock = new ReentrantLock();
	public void serviceMethod1(){
		try{
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"==== in ");
			Thread.sleep(Integer.MAX_VALUE);
		}catch (Exception e) {
			
		}finally{

		}
	}
}