public class Test extends Thread{

	// stop 释放锁后导致数据的不一致性的问题

	private SynchronizedObject object;

	public Test(SynchronizedObject object){
		this.object = object;
	}

	public void run(){
		object.printString("b","bb");
	}


	public static void main(String[] args){
		try{
			SynchronizedObject object = new SynchronizedObject();
			Test t = new Test(object);
			t.start();
			Thread.sleep(500);
			t.stop();
			System.out.println(object.getUsername() +"   "+ object.getPassword());  // b aa

		}catch (Exception e) {
			
		}
	}
}