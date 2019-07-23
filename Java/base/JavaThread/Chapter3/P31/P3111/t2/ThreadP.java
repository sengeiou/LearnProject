public class ThreadP extends Thread{

	private P p ;

	public ThreadP(P p){
		this.p = p;
	}


	@Override
	public void run (){
		while(true){
			// try{	
			// 	Thread.sleep(1000);
			// }catch(Exception e){}
			p.setValue();
		}
	}	

}