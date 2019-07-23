public class Test implements Runnable {

	public static ThreadLocal<String> t1 = new ThreadLocal<String>() {
		// 通过重写 initialValue 方法，改变默认值
		@Override 
		protected String initialValue() {
			return "DEFAULT";
		}

}
		;


		/**
		* P331  P332  P333 P334 合在了一起 ，主要介绍了 ThreadLocal 的基本使用 和 线程变量的隔离性
		*
		*
		*
		*
		*  ThreadLocal 主要用来让每个线程都是属于自己的值。可以把它比喻成全局存放数据的盒子，盒子中可以存储每个线程的私有数据。
		*  1. ThreadLocal的基本使用
		*  使用起来非常简单，创建 ——》  set  ——》 get
		*  如果当前线程没有对 ThreadLocal 对象设置过值，那么获取到的值就是null, 除非你重写的初始值
		*
		*  2. 重写 protected T initialValue() 方法来设置 ThreadLocal 的默认值。
		*
		*
		*
		*
		*
		*
		*/
		public static void main(String[] args) {

			t1.set(Thread.currentThread().getName());

			System.out.println(t1.get());

			new Thread(new Test()).start();

		}


		@Override
		public void run() {

			// 通过线程测试 ThreadLocal 的隔离性
			System.out.println(t1.get());
			t1.set(Thread.currentThread().getName());
			System.out.println(t1.get());
		}


	}

