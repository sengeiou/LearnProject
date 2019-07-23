//  java 的线程分两种，用户线程，守护线程
// 守护线程是一种特殊的线程，当进程中不存在非守护线程后，守护线程自动销毁
// 垃圾回收线程就是一个守护线程
public class Test extends Thread{

	private int i = 0;
	public void run(){
		try{
			while(true){
				i++;
				System.out.println("i="+i);
				Thread.sleep(1000);
			}

		}catch (Exception e) {
			
		}
	}


	public static void main(String[] args) throws Exception{
		Test t = new Test();
		t.setDaemon(true);
		t.start();
		Thread.sleep(4000);
		System.out.println("main thread is stop");
	}
}