public class ThreadA extends Thread{
	public MyService myService;

	public ThreadA(MyService myService ){
		this. myService = myService;
	}

	public void run(){
		myService.awaitA();
	}

}