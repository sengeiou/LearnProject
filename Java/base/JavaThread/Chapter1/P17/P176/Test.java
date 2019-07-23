public class Test extends Thread{

	// stop 方法会抛出 java.lang.ThreadDeath 异常，但是不需要显示的捕获
	// stop 方法可能会使一些清理性的工作得不到完成。
	// 另外一种情况，stop 方法会对锁定的对象进行解锁，导致数据的不一定性

	public void run(){
		try{	
			this.stop();
		}catch(ThreadDeath e){
			System.out.println(" in run catch ");
		}
	}

	public static void main(String[] args){
		Test t = new Test();
		t.start();
	}
}