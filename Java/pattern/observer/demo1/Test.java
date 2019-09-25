public class Test{
	public static void main(String[] args){
		HanFeiZi hanFeiZi  = new HanFeiZi();
		LiSi liSi = new LiSi();
		Spy spy = new Spy(hanFeiZi,liSi);
		hanFeiZi.haveFun();
		new Thread(spy).start();

		try{
			Thread.sleep(4000);

		}catch(Exception e){

		}
		
		hanFeiZi.haveFun();
	}
}