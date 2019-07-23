import java.util.concurrent.locks.*;
public class Service{
	private ReentrantLock lock;
	public Service(boolean isFair){
		this.lock = new ReentrantLock(isFair);
	}
	public void serviceMethod(){
		try
		{
			lock.lock();
			System.out.println(Thread.currentThread().getName());
		}finally{
			lock.unlock();
		}
	}

}