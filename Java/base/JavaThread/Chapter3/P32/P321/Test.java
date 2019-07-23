public class Test extends Thread {

	/**
		*  很多情况下， 主线程创建并启动了子线程，如果子线程晚于主线程结束，而主线程又想等待子线程结束再做操作，就比较麻烦了
		*  看下面的代码
		*  
		*
		*/

	public static void main(String[] args) {

		Test t = new Test();
		t.start();

		// main已经结束了， 子线程还在运行，解决这个问题，需要看下一章节
		System.out.println(Thread.currentThread().getName()+"is end");

	}



	@Override
	public void run(){
		try{
			int i = 5;
			while (i > 1){
				i--;
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+"is running");
			}
		}catch(Exception e){

		}
	}


}