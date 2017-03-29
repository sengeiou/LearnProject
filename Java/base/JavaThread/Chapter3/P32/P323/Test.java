public class Test {
	// join 与 异常
	// 在 join 过程中，如果当前线程对象被中断， 则当前线程出现异常.

	public static void main(String[] args) {
		try{

			ThreadB  b = new ThreadB();
			b.start();

			// 在书中demo 中，此处要加上thread.sleep ，但是实际运行中发现，在 ThreadC 执行时， ThreadB 已经结束了
			// 	
			// Thread.sleep(1000);

			ThreadC c  = new ThreadC(b);
			c.start();

		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}