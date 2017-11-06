public class Test extends Thread{


	// 利用 return 停止线程
	// 其实道理和 P173 一样的

	public void run(){
		while(true){
			if (this. interrupted()){
				System.out.println("stop");
				return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Test t  = new Test();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}
}