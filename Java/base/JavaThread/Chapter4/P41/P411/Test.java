
public class Test {

	public static void main(String[] args) {

		MyService myService  = new MyService();

		MyThread t1 = new MyThread(myService);
		MyThread t2 = new MyThread(myService);
		MyThread t3 = new MyThread(myService);
		MyThread t4 = new MyThread(myService);
		MyThread t5 = new MyThread(myService);
		MyThread t6 = new MyThread(myService);

		t1.start();		
		t2.start();		
		t3.start();		
		t4.start();
		t5.start();
		t6.start();
// 根据打印结果发现，只有当前线程全部打印完毕后，才将锁进行了释放， 其他线程才可以继续打印。
// 线程打印的数据是分组打印，因为当钱线程已经持有锁，但是线程间的打印的顺序是随机的。


		


	}
}