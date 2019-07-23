public class ThreadC extends Thread{

	public ThreadB b;

	public ThreadC(ThreadB b){
		this.b = b;
	}

	@Override
	public void run(){
		b.bService();
	}

}