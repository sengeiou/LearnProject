public class Test extends Thread{

	// 演示在线程sleep 的情况下， 调用 interrupt 会出现什么结果
	public void run(){
		try{
			System.out.println("run begin");
			Thread.sleep(200000);	
			System.out.println("run end");

		}catch(InterruptedException e){
			System.out.println(" exception "+ this.isInterrupted());
		}
	}

	public static void main(String[] args){
		try{
			Test t = new Test();
			t.start();
			Thread.sleep(200);
			t.interrupt();
		}catch(InterruptedException e){
			System.out.println("main catch");
		}
	}
}