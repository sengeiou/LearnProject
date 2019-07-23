public class ThreadA extends Thread {

	private ThreadB  b;
	public ThreadA(ThreadB b) {
		this.b = b;
	}

	@Override
	public void run() {
		try {
			synchronized (b) {
				b.start();
				b.join();
				for (int i = 0 ; i < Integer.MAX_VALUE; i++) {
					String s  = new String(i + "");
				}
			}
		} catch (Exception e) {

		}
	}
}