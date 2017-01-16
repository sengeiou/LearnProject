public class Test{
	// notifyAll 唤醒所有线程
	
	public static void main(String[] args){
		String o  = new String();
		new ThreadA(o).start();
		new ThreadB(o).start();
		new ThreadC(o).start();
		new ThreadN(o).start();  

	}
}
class ThreadN extends Thread{
	String o;
	public ThreadN(String o){
		this.o = o ;
	}
	public void run(){
		try{
			synchronized(o){
				Thread.sleep(3000);
				o.notifyAll(); // 唤醒所有线程
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}


class ThreadA extends Thread{
	String o;
	public ThreadA(String o){
		this.o = o ;
	}
	public void run(){
		try{
			synchronized(o){
				System.out.println(Thread.currentThread().getName()+" start");
				o.wait();
				System.out.println(Thread.currentThread().getName()+" end");
			}
		}catch(Exception e){
		System.out.println(e.toString());
		}
	}
}
class ThreadB extends Thread{
	String o;
	public ThreadB(String o){
		this.o = o ;
	}
	public void run(){
		try{
			synchronized(o){ 
				System.out.println(Thread.currentThread().getName()+" start");
				o.wait();
				System.out.println(Thread.currentThread().getName()+" end");
			}
		}catch(Exception e){
		System.out.println(e.toString());
		}
	}
}

class ThreadC extends Thread{
	String o;
	public ThreadC(String o){
		this.o = o ;
	}
	public void run(){
		try{
			synchronized(o){
				System.out.println(Thread.currentThread().getName()+" start");
				o.wait();
				System.out.println(Thread.currentThread().getName()+" end");
			}
		}catch(Exception e){
		System.out.println(e.toString());
		}
	}
}
