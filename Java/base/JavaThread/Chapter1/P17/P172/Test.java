// 判断线程是否停止状态
// 有两种方法
// this.interrupted();  测试当前线程是否已经中断 （是一个静态方法）
// this.isIterrupted(); 测试线程是否已经中断
// 注意区分 ， 当前线程


public class Test extends Thread {

	public void run() {
		for (int i = 0 ; i < 99; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		try {
			Test t = new Test();

			t.start();

			Thread.sleep(1000);

			t.interrupt();

			System.out.println(t.interrupted()+"--");  // false 
			// 很奇怪，这里输出的是 false	
			// 在看下上面的话， 测试当前线程是否已经中断 ，当前线程，也就是main 线程，所以输出的值也就是这样了
		} catch (Exception e) {

		}
	}
}