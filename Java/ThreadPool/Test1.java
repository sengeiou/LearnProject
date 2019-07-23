import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1{
	public static void main(String[] args) {
			
		AtomicInteger ai = new AtomicInteger();

		System.out.println(ai.getAndIncrement());
		System.out.println(ai.getAndIncrement());
		System.out.println(ai.getAndIncrement());
		System.out.println(ai.getAndIncrement());
	}
}