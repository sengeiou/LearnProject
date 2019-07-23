public class TestWait {

	public static void main(String[] args) {
		Object o = new Object();
		Thread a  = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o) {
					System.out.println("a start wait");
					try {
						o.wait();

					} catch (Exception e) {

					}
					System.out.println("a is running");
					System.out.println("a is finish");
				}
			}
		});

		Thread b  = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("b out start");
				synchronized (o) {

					System.out.println("b is start");
					try {
						Thread.sleep(2000);
						o.notify();

					} catch (Exception e) {

					}
					System.out.println("b is finish");
				}

			}
		});


		a.start();
		b.start();
	}

}