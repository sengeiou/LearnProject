public class Test extends Thread{


	// 使用 stop 方法暴力停止线程
	// 这个方法已经被废弃了

	private int i = 0;

	public void run(){
		try{
			while(true){
				i++;
				System.out.println("i=="+ i);
				Thread.sleep(1000);
			}
		}catch (Exception e) {
			
		}
	}


	public static void main(String[] args){
		try{

			Test t = new Test();
			t.start();
			Thread.sleep(3000);
			t.stop();

		}catch (Exception e) {
			
		}
	}
}