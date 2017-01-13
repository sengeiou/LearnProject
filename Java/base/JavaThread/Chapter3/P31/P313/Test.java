public class Test{



	/**
	* P313使用等待通知机制
	* wait使线程停止运行， notify使停止的线程继续运行，这两个方法都是java.lang.Object中的方法
	* 在调用wait和notify前，线程必须获得该对象的对象级别锁，就是说只能在同步方法或者同步代码块中才能调用wait 和 notify 方法
	* 如果没有获得到该对象的对象级别锁，那么会抛出IllgalMonitorStateException
	* wait方法会将当前置入"与执行队列"中，并在wait 所在的代码处停止执行， 直到接到通知或中断
	* notify 用来通知那些等待对象锁的其他线程，对其发出通知, notify在执行后，不会马上发出
	* 通知，需要在notify所在线程执行完后才行
	*/
	public static void main(String[] args){

		//demo1  会报错 java.lang.IllegalMonitorStateException
		//错误的原因没有”对象监视器“，也就是没有同步加锁
		// try{
		// String str = new String();
		// str.wait();
		// }catch(InterruptedException e){}

		//demo2 ，增加对面级别的锁，但是只会执行wait 之前的代码，然后就一直阻塞

		// try{
		// 	String  o = new String();
		// 		System.out.println("out sync start...");
		// 	synchronized(o){
		// 		System.out.println("sync wait...");
		// 		o.wait();
		// 		System.out.println("sync wait end...");
		// 	}
		// 	System.out.println("out sync end...");

		// }catch(InterruptedException e){}



		//demo3 ，sleep2秒，增加notify的方法, 但是情况依旧，哈哈哈。原来一直阻塞在同步方法内

		// try{
		// 	String  o = new String();
		// 		System.out.println("out sync start...");
		// 	synchronized(o){
		// 		System.out.println("sync wait...");
		// 		o.wait();
		// 		System.out.println("sync wait end...");
		// 	}
		// 	System.out.println("out sync end...");

		// 	Thread.sleep(2000);
		// 	o.notify();	

		// }catch(InterruptedException e){}



		//demo4 ，开启子线程ThreadA 调用notify的方法, 
		// 还是不行
		// try{
		
		// 	String  o = new String();
		// 	new ThreadA(o).start();
		// 	System.out.println("out sync start...");

		// 	synchronized(o){
		// 		System.out.println("sync wait...");
		// 		o.wait();
		// 		System.out.println("sync wait end...");
		// 	}
		// 	System.out.println("out sync end...");

			

		// }catch(InterruptedException e){}


		// demo5 ，开启双线程,B 线程wait，A线程在运行2秒后，执行notify，运行成功
		// ok 了，现在不是很理解，为什么demo4的写法运行就是一直阻塞的
			String  o = new String();

			new ThreadB(o).start();
			new ThreadA(o).start();
	

        // 自己练习，使用wait 和 notify 实现P311的需求
			


			

	}




}
class ThreadB extends Thread{

		String o ;
		public ThreadB(String o){
			this.o = o ;
		}

		@Override
		public void run (){
			try{
				System.out.println("out sync start...");

				synchronized(o){
					System.out.println("sync wait...");
					o.wait();
					System.out.println("sync wait end...");
				}
			System.out.println("out sync end...");
			}catch(InterruptedException e){

			}

		}

}


class ThreadA extends Thread{

		String o ;
		public ThreadA(String o){
			this.o = o ;
		}

		@Override
		public void run (){
			try{
				synchronized(o){
					Thread.sleep(2000);
					o.notify();	
				}
			}catch(InterruptedException e){

			}

		}

}