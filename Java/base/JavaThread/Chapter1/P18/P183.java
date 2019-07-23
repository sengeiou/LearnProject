

// suspend 和 resume 方法的缺点，容易出现因为线程的暂停而导致数据不同步的情况
// 貌似是一定的啊，早知道不敲这些代码了


public class P183{
	public static void main(String[] args) throws Exception{
		final MyObject object  = new MyObject();
		Thread thread1 = new Thread(){
			public void run(){
				object.setValue("a","aa");
			}
		};

		thread1.setName("a");
		thread1.start();

		Thread.sleep(1000);

		new Thread(){
			public void run(){
				object.printUsernamePassword();
			}
		}.start();
	}


	public static class MyObject{
		private String username = "1";
		private String password = "11";
		public void setValue(String u , String p){
			this. username= u;
			if(Thread.currentThread().getName().equals("a")){
				System.out.println("stop a thread");	
				Thread.currentThread().suspend();
			}	
			this. password = p;
		}
		public void printUsernamePassword(){
			System.out.println(username +"   "+ password);
		}
	}


}