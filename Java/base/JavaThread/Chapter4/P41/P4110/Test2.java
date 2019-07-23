public class Test2{
	public static void main(String[] args) throws Exception{
		final Service2 service2  = new Service2();
		Runnable runnable = new Runnable(){
			public void run(){
				service2.serviceMethod1();
			}
		};

		for(int i = 0 ; i < 10 ; i++ ){
			Thread t = new Thread(runnable);
			t.start();
		}

		Thread.sleep(3000);
		// 方法 getQueueLength 是返回正在等待获取此锁定的线程估计数， 说明有多少线程正在等待lock 的释放
		System.out.println(service2.lock.getQueueLength());  // 9  
	}
}