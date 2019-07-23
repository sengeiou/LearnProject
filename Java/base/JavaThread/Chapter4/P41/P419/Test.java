public class Test{
	public static void main (String[] args){

		// 构造公平锁， 打印的顺序也一致的，看打印的顺序
		final Service service = new Service (true);
		Runnable runnable = new Runnable (){

			public void run(){
				System.out.println("runnable="+Thread.currentThread().getName());
				service.serviceMethod();
			}

		};

		Thread[]  threadArray  = new Thread[10];

		for (int i = 0; i < 10 ; i++ ){
			threadArray[i] = new Thread(runnable);
			threadArray[i].start(); 
		}

	}
}