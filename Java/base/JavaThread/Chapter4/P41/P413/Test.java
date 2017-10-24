import java.util.concurrent.locks.*;
/**
*   使用 condition 实现等待/通知 
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*/
public class Test{
	public static void main(String[] args){
			MyService service = new MyService();
			ThreadA threadA = new ThreadA(service);
			threadA.start();
	}
}