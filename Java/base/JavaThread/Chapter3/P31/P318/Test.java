public class Test{
	// wait(long) 
	// 等待某一时间内是否有线程对锁进行唤醒，如果超过这个时间就自动唤醒
	// 可以由定时器唤起，也可以由notify 唤起
	public static void main(String[] args){

		new ThreadA(new String()).start();
	}

}



class ThreadA extends Thread{

	String o ;
	public ThreadA(String o){
		this. o = o;
	}

	public void run(){
		try{
			synchronized(o){
				System.out.println("start");
				o .wait(3000);
				System.out.println("end");
			}
		}catch(InterruptedException e){
			System.out.println(e.toString());
		}
	}
}