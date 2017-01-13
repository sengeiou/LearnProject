import java.util.ArrayList;

public class Test{


	private static ArrayList<String> list = new ArrayList<String>();

	/**
	* 这个demo演示用了不停的遍历实现进程间通信
	* 有点消耗系统资源
	*/
	public static void main(String[] args){

		ThreadA threadA  = new ThreadA();
		ThreadB threadB  = new ThreadB();
		threadA.start();
		threadB.start();

	}


	static class ThreadA extends Thread{
		@Override
		public void run(){
			while(list.size()<10){
				try{
					Thread.sleep(1000);
				}catch(Exception e){}
				list.add("123");
			}

		}
	}


	static class ThreadB extends Thread{
		@Override
		public void run(){
			while(true){
				System.out.println(list.size());
			}	

		}
	}





}