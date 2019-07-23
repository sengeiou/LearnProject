public class Test{
	
	// 等待通知最经典的案例就是 “生产者/ 消费者” 模式,
	// t1 的代码主要展示了 1个消费者 和 1个生产者的例子 

	// 1.消费者等待
	// 2.生产者生产，唤醒消费者，进入等待
	// 3.消费者消费后，唤醒生产者，进入等待
	// 如此的重复循环

	public static void main(String[] args){


		String lock = new String ("");

		P p = new P(lock);
		C c = new C(lock);
		ThreadP  tp = new ThreadP(p);
		ThreadC  tc = new ThreadC(c);

		tc.start();
		tp.start();
	}
}