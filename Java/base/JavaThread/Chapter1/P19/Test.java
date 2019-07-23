
// yield  方法，作用是放弃当前的 cpu 资源， 将它让给其他任务去占用 cpu 的执行时间，
// 但是放弃的时间不确定， 有可能刚刚放弃， 马上又获得 cpu 的时间片。

public class Test extends Thread{


	public void run(){
		long beginTime = System.currentTimeMillis();
		int count = 0;
		for(int i = 0; i< 50000000; i++){
			Thread.yield();  // 试着加上或者注释掉这句话
			count = count + (1 +i); 
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime- beginTime)+" lost time");
	}

	public static void main (String[] args){
		Test t  = new Test();
		t.start();
	}
}