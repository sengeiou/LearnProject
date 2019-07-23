public class MyThread extends Thread{

	private MyService mMyService;

	public MyThread(MyService service){
		this.mMyService = service;
	}

	public void run(){
		mMyService.testMethod();
	}
}
