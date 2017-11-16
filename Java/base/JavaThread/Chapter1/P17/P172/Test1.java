// 下面的代码让主线程中断,然后使用静态方法 interrupted 来判断主线程是否终止


public class Test1{
	public static void main(String[] args){

		Thread.currentThread().interrupt();

		System.out.println("the thread is shut down ？"+ Thread.interrupted());  // true
		System.out.println("the thread is shut down ？"+ Thread.interrupted());  // false


		// 这里又很奇怪，为什么第一次调用是 true ， 而第二次是 false 呢？
		// 因为 interrupted 方法具有清除状态的功能


		Test t = new Test();
		t.start();

		t.interrupt();

		System.out.println("the thread t is shut down ？"+ t.isInterrupted());  // true
		System.out.println("the thread t is shut down ？"+ t.isInterrupted());  // true

		// 可以看出 isInterrupted 是不会清除状态的

	}
}
