public class Test{
	public static void main(String[] args){
		// 多生产与多消费者 ： 操作值- 假死
		
		String lock = new String ("");

		P p = new P(lock);
		C c = new C(lock);

		ThreadP[] pThread = new ThreadP[2];
		ThreadC[] cThread = new ThreadC[2];

		for ( int i = 0 ; i < 2 ; i++ ){

		pThread[i] = new ThreadP(p);
		cThread[i] = new ThreadC(c);

		pThread[i].start();
		cThread[i].start();
		
		}
	}
}