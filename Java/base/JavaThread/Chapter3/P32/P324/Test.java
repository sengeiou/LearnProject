public class Test extends Thread{

	// join(long) 参数是设定等待的时间
	public static void main(String[] args) throws Exception {
		

		Test t = new Test();
		t.start();

		t.join(2000);

		System.out.println(Thread.currentThread().getName() + "is end");

	}

// 查看输出：	
// Thread-0is running
// mainis end
// Thread-0is running
// Thread-0is running
// Thread-0is running


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