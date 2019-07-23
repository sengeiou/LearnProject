
// 线程的优先级
// 线程的优先级具有继承性, 比如 a 线程启动 b 线程， 则 a b 线程的优先级一致
// 看例子

public class P1101{
	public static void main(String[] args){
			Thread1 t1 = new Thread1();
			t1.setPriority(9);
			t1.start();
	}


	static class  Thread1 extends Thread{
		public void run(){
			System.out.println("thread1 run priority "+ this.getPriority());
			Thread2 t2 = new Thread2();
			t2.start();
		}
	}

	static class Thread2 extends Thread{
		public void run(){
			System.out.println("thread2 run priority "+ this.getPriority());
		}
	}

}