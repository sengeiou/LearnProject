public class ThreadB extends Thread{

	public MyService myService;
	public ThreadB(MyService myService){
		this. myService = myService;
	}

	public void run(){
		myService.awaitB();
	}
}