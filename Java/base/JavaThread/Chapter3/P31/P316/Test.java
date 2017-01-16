public class Test{
	// 调用notify方法一次只随机通知一个线程进行唤醒
	// 如果想到唤醒所有线程，那么你需要对线程进行多次唤醒
	public static void main(String[] args){
		String o  = new String();
		new ThreadA(o).start();
		new ThreadB(o).start();
		new ThreadC(o).start();
		new ThreadN(o).start();   //ThreadN第一个在3秒后运行
		new ThreadN(o).start();
		new ThreadN(o).start(); //  后面两个几乎是同时运行结束的，很奇怪
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
				o.notify();
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
