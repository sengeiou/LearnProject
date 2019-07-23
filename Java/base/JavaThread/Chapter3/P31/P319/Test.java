public class Test{
	// 通知过早
	//
	public static void main(String[] args){
		// Test t = new Test();	
		// Thread threadA = new Thread(t.runnableA);
  //   	Thread threadB = new Thread(t.runnableB);
  //      	threadA.start();
		// threadB.start();
		// // 上面的代码，这样的操作是不会造成错误


		// 如果执行下面的代码.notify 在 wait 之前执行，就会造成永远wait
		Test t = new Test();	
		Thread threadA = new Thread(t.runnableA);
    	Thread threadB = new Thread(t.runnableB);
		threadB.start();

		try{
			Thread.sleep(1000);
		}catch(Exception e){
		}
 		threadA.start();

 		// 要解决上面的问题，主要还在是编写代码时去解决，如果提早通知了，就没必要去wait 了
 		// 主要是去 线程中处理， 当notify后改变标示，就不再 wait，这里就不给出代码了
	}

	private String lock = "lock";

	private Runnable runnableA = new Runnable(){

		@Override
		public void run(){
			try{
				synchronized(lock){
					System.out.println("A start");
					lock.wait();
					System.out.println("A end");
				}
			}catch(Exception e){}
		}
	};

	private Runnable runnableB = new Runnable(){

		@Override
		public void run(){
			try{
				synchronized(lock){
					System.out.println("B start notify");
					lock.notify();
					System.out.println("B end notify");
				}
			}catch(Exception e){}

		}


	};


}