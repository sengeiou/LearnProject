public class Test{
	//方法wait被执行后，锁被自动释放，但执行完notify方法后，锁却不自动释放
	//有点难理解,看ThreadA 和ThreadB的案例，在ThreadA 启动后，ThreadB的RUN一直在等待
	//而如果ThreadA 的synchronized中调用wait方法后，ThreadB则不需要等待ThreadA的synchronized方法执行完毕就可以运行
	public static void main(String[] args){
		String o  = new String();
		new ThreadA(o).start();
		new ThreadB(o).start();
	}
}


class ThreadA extends Thread{

	String o ;
	public ThreadA(String o){
		this.o =  o;
	}

	public void run(){
		synchronized(o){
			try{	
			System.out.println("ThreadA start");
			Thread.sleep(5000);
			System.out.println("ThreadA end");
			}catch(Exception e){

			}
		}
	}
}

class ThreadB extends Thread{

	String o ;
	public ThreadB(String o){
		this.o =  o;
	}

	public void run(){
		synchronized(o){
			try{	
			System.out.println("ThreadB start");
			Thread.sleep(5000);
			System.out.println("ThreadB end");
			}catch(Exception e){

			}
		}
	}
}

