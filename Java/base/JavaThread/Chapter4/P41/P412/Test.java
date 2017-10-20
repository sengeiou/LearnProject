import java.util.concurrent.locks.*;
public class Test{

	static class MyService{
		private Lock lock = new Lock();
		public void methodA(){
			try{
				System.out.println("method a running");
				lock.lock();
				Thread.sleep(5000);
			}catch (Exception e) {
				
			}finally{
				lock.unlock();
			}
		}

		public void methodB(){
			try{
				System.out.println("method b running");
				lock.lock();
				Thread.sleep(5000);
			}catch (Exception e) {
				
			}finally{
				lock.unlock();
			}
		}

	}






	public static void main(String[] args){

	}
}