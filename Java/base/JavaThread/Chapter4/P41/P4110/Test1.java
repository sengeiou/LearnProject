
// lock.getHoldCount()  查询当前线程保持此锁定的个数， 也就是调用lock 方法的次数 

public class Test1{
	public static void main(String[] args){

		Service1 service1 = new Service();
		service1.serviceMethod1();

	}

}
