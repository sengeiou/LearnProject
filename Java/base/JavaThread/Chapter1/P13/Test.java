// currentThread()
// 可以获取正在调用的线程
// 书中还介绍了别的一种方式, 既在线程的构造中调用此方法，获得的一定是主线程
public class Test{
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
	}
}