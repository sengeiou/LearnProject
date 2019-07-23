import java.util.concurrent.locks.*;
public class Service1 {
	public ReentrantLock lock = new ReentrantLock();
	public void serviceMethod1(){
		try{
			lock.lock();
			System.out.println("serviceMethod1===="+lock.getHoldCount());
			serviceMethod2();
		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}

	public void serviceMethod2(){
		try{
			lock.lock();
			System.out.println("serviceMethod2===="+lock.getHoldCount());
		}catch(Exception e ){

		}finally{
			lock.unlock();
		}
	}

}