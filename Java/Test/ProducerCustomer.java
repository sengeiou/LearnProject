import java.util.List;
import java.util.ArrayList;


public class ProducerCustomer {

	static final int MAX_SIZE = 100;

	private static List<String> list = new ArrayList<String>();

	static class Producer implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (list) {
					try {
						list.wait();
					} catch (Exception e) {

					}

					if (list.size() == 0) {
						try {
							Thread.sleep(500);
							list.add(System.currentTimeMillis());
							list.notifyAll();
						} catch (Exception e) {

						}

					}
				}
			}
		}
	}


	static class Customer  implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (list) {
					if (list.size() > 0) {
						String result = list.remove(0);
						System.out.println( getName() + "--have been removed-" + result)

					} else {
						try {
							list.notifyAll();
							list.wait();
						} catch (Exception e) {}
					}
				}
			}
		}
	}


	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();
	
		Producer p1 = new Producer();
		Producer p2 = new Producer();
		Producer p3 = new Producer();

		c1.start();
		c2.start();
		c3.start();



	}
}