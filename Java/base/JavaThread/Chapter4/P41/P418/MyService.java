import java.util.concurrent.locks.*;
public class MyService{


		// 暂时放下P
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;

	public void set(){
		try{
			lock.lock();
			while(hasValue == true ){
				System.out.println("**");
				condition.await();
			}
			System.out.println("*");
			hasValue = true;
			condition.signal();

		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}
	}

	public void get(){
		try{
			lock.lock();
			while(hasValue == false){
				System.out.println("&&");
				condition.await();
			}
			System.out.println("&");
			hasValue = false;
			condition.signal();

		}catch (Exception e) {
			
		}finally{
			lock.unlock();
		}

	}


}