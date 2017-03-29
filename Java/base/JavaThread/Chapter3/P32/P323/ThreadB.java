public class ThreadB extends Thread{

	@Override
	public void run(){
		try{
			ThreadA a  = new ThreadA();
			a.start();
			a.join();
			System.out.println(" thread b is end ");
		}catch(InterruptedException e){
			System.out.println(" thread b "+e.toString());
		}
	}
}