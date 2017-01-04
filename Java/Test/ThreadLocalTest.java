import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTest extends Thread {


	public static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

		@Override
		protected String initialValue() {
			// 设置初始值，这里使用当前thread的名字
			return Thread.currentThread().getName();
		}

	};

	public static void main(String[] args) {


		try {
			String DateStr1 = "2017-12-12";

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateTime1 = dateFormat.parse(DateStr1);
			Date dateTime2 = dateFormat.parse(dateFormat.format(new Date()));
			int i = dateTime1.compareTo(dateTime2);
			System.out.println(i);
		} catch (Exception e) {

		}



		// // threadLocal.set("main");

		// ThreadLocalTest test = new ThreadLocalTest();
		// test.start();//在子线程中获取

		// //在主线程中获取
		// String result = threadLocal.get();
		// System.out.println("main thread get str" + result);
	}


	public void run() {
		String result = threadLocal.get();
		System.out.println("ThreadLocalTest thread get str" + result);
	}



}