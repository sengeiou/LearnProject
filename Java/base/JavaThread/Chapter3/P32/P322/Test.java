public class Test extends Thread {
	// 使用 join 来解决上一章节出现的问题
	public static void main(String[] args)  {
		try {
			Test t = new Test();
			t.start();


			t.join();  // 注意这行代码 会抛出 InterruptedException
			// join 的作用就是使所属线程对象正常执行run 方法 ，而时当前线程进行阻塞，
			//  直到所属对象的run 方法执行完毕	

			// join 在内部使用 wait() 方法进行等待	

			System.out.println(Thread.currentThread().getName() + " is end");

		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}

// 运行的输出过程
// Thread-0is running
// Thread-0is running
// Thread-0is running
// Thread-0is running
// main is end

	@Override
	public void run() {
		try {
			int i = 5;
			while (i > 1) {
				i--;
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "is running");
			}
		} catch (Exception e) {

		}
	}


}