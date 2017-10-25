public class Test{

	
	public static void main(String[] args) throws Exception{
		MyService myService  = new MyService();




	//	 这个程序还是没想明白 ，感觉笨死了

		MyThread threadSet = new MyThread(myService, true);
		threadSet.start();

		Thread.sleep(500);


		MyThread threadGet = new MyThread(myService , false);
		threadGet.start();

	}
}