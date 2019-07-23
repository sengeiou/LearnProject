
// suspend 和 resume 方法的缺点，如果使用不当，会造成公共的同步对象的独占，使得其他线程无法访问公共同步对象。
public class P182 {
	public static void main(String[] args){

		try{
			final SynchronizedObject object = new SynchronizedObject();
			Thread  thread1 = new Thread(){

				public void run(){
					object.printString();
				}
			};
			thread1.setName("a");
			thread1.start();
			Thread.sleep(1000);
			Thread thread2 = new Thread(){

				public void run(){
					System.out.println("thread2 is start , but printString method not execute ");
					object.printString();
				}
			};
			thread2.start();

			// 如果不恢复 thread1, thread2的 object 永远无法执行  printString 		
			// new Thread(){

			// 	public void run(){
			// 		try{
			// 			Thread.sleep(5 * 1000);
			// 			thread1.resume();
			// 		}catch (Exception e) {
					
			// 		}
			// 	}

			// }.start();

		}catch (Exception e) {
			
		}

	}


	static class SynchronizedObject {

		synchronized public void printString(){
			System.out.print("begin");
			if("a".equals(Thread.currentThread().getName())){
				System.out.println(" a was suspend");
				Thread.currentThread().suspend();
			}
			System.out.println("end");
		}
	}



}