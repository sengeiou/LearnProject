/**
* 在这个例子中
* 使用 condition 实现等待通知模式
* Object 中的 wait 等于 Condition 中的 await
* Object 中的 notify 等于 Condition 中的 signal
* Object 中的 notifyAll 等于 Condition 中的 signalAll
*
*/
public class Test{
	public static void main(String[] args) throws Exception{
		MyService myService = new MyService();
		ThreadA a = new ThreadA(myService);
		a.start();
		Thread.sleep(3000);
		myService.signal();
	}	
}