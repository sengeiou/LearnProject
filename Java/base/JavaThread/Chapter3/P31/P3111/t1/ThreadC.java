public class ThreadC extends Thread{

	private C c;

	public ThreadC(C c){
		this. c = c;
	}

	@Override
	public void run(){
		while(true){
			// try{	
			// 	Thread.sleep(1000);
			// }catch(Exception e){}

			c.getValue();
		}
	}

}