//interrupt 停止线程
// 但是这个方法只是在当前线程中打了一个停止的标记, 不是真正的停止线程
// 运行程序， 发现并没有真正的停止线程

public class Test extends Thread{

	public void run(){
		for(int i = 0; i < 4000; i++ ){
			System.out.println(i + "");
		}
	}

	public static void main(String[] args){
			try{
				Test t = new Test();
				t.start();
				Thread.sleep(1000);
				t.interrupt();
			}catch (Exception e) {
				
			}
	}
}