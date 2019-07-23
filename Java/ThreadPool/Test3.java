import java.util.concurrent.*;
import java.util.List;

public class Test3 {
	public static void main(String[] args) throws Exception {
		ExecutorService myExecutorService  = Executors.newFixedThreadPool(5);
		for (int i = 0 ; i < 10 ; i++) {
			Future<String> future = myExecutorService.submit(new Callable<String>() {

				@Override
				public String call() {
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {

					}
					return Thread.currentThread().getName() + " callback";
				}
			});
			System.out.println(future.get());

		}
		System.out.println("start shutdown");
		myExecutorService.shutdown();

	}
}