

// 暂停线程意味着此线程还可以恢复运行

// 介绍 suspend 和 resume 的使用方法  ，但是这两个方法已经被废弃了

public class P181 extends Thread{

	private long i = 0;

	public long getI(){
		return i;
	}

	public void setI(long i ){
		this.i = i;
	}

	public void run(){
		while(true){
			i++;
		}
	}

	public static void main(String[] args) throws Exception{
		P181 test = new P181();
		test.start();

		Thread.sleep(1 * 1000);

		test.suspend();
		System.out.println(test.getI());

		Thread.sleep(10 * 1000);
		test.resume();

		System.out.println(test.getI());


		Thread.sleep(10 * 1000);
		System.out.println(test.getI());

	}
}		
