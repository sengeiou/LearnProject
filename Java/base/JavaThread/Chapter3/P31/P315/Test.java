public class Test{
	//interrupt    
	//当线程处于wait状态时，调用线程的interrupt方法，会出现InterruptedException
	public static void main(String[] args){
		String o = new String();
		ThreadA threadA = new ThreadA(o);
		threadA.start();
		threadA.interrupt();
	}

}


class ThreadA extends Thread{

	String o  ;
	public ThreadA(String o){
		this.o =  o;
	}
	public void run(){
		try{	
			synchronized(o){
				System.out.println("ThreadA is running");
				o.wait();
			}
		}catch(InterruptedException e){
			System.out.println(e.toString());
		}
	}
}
