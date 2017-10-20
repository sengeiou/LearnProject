import java.util.concurrent.*;
import java.util.List;

public class Test2 {
	public static void main(String[] args) throws Exception {
		ExecutorService myExecutorService  = Executors.newFixedThreadPool(5);
		for (int i = 0 ;i< 10 ;i++){
			myExecutorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {

					}
				}
			});
		}
		System.out.println("start shutdown");
		List<Runnable> runnables = myExecutorService.shutdownNow();
				System.out.println(runnables.size());

		// myExecutorService.shutdown();
	}
}