// isAlive()
// 判断当前线程是否处于活动状态
public class Test extends Thread{

	public void run(){
		System.out.println("run method "+this.isAlive());
	}


	public static void main(String[] args) throws Exception {

		Test t  = new Test();
		t.start();

		Thread.sleep(2000);

		System.out.println("main method " + t.isAlive() );
	}
}