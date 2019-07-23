public class ThreadB extends Thread {

	@Override
	public void run() {
		try {
			System.out.println("thread b is running" + System.currentTimeMillis());

			Thread.sleep(5000);

			System.out.println("thread b is running" + System.currentTimeMillis());
		} catch (Exception e) {

		}
	}

	synchronized public void bService (){
		System.out.println("bService" + System.currentTimeMillis());
	}

}