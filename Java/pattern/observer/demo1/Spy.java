public class Spy implements Runnable{


	private HanFeiZi  mHanFeiZi ;
	private LiSi mLiSi;

	public Spy(HanFeiZi hanFeiZi, LiSi liSi){
			this.mHanFeiZi = hanFeiZi;
			this.mLiSi = liSi;
	}

	@Override
	public void run(){
		while(true){
		try{
			Thread.sleep(2000);
			System.out.println(this.mHanFeiZi.fun+"");
		}catch(Exception e){

		}
			
			if(this.mHanFeiZi.fun){
				this.mLiSi.update("hanfeizi is haveFun liSi will report");
				this.mHanFeiZi.fun = false;
			}
		}
	}
}