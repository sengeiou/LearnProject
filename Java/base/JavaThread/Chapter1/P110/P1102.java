import java.util.Random;
// 虽然可以用 setPriority 设置线程的优先级，但是还是没发现设置线程优先级所带来的效果。
// 理论上，线程的优先级和执行顺序无关，只和优先级有关，但是也不是完全的说优先级高就先执行完成了
// 因为优先级具有随机性
public class P1102 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++){
			Thread1 t1 = new Thread1();
			t1.setPriority(10);
			t1.start();


			Thread2  t2 = new Thread2();
			t2.setPriority(1);
			t2.start();
		}

	}


	static class Thread1 extends Thread {
		public void run() {
			long beginTime = System.currentTimeMillis();
			long addResult = 0;
			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < 500000; i++) {
					Random random = new Random();
					random.nextInt();
					addResult = addResult + i;
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println(" thread1 is lost time "+(endTime - beginTime));
		}
	}

	static class Thread2 extends Thread{
		public void run(){
			long beginTime = System.currentTimeMillis();
			long addResult = 0;
			for(int j = 0; j < 10; j ++){
				for (int i = 0; i < 500000; i++){
					Random random = new Random();
					random.nextInt();
					addResult = addResult + i ;
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("thread2 is lost time "+(endTime - beginTime));
		}
	}

}