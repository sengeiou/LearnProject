public class P{

	private String lock;

	public P(String lock ){
		this.lock = lock ;
	}

	public void setValue(){	
		System.out.println("setValue start");
		try{
			synchronized(lock){
				if(!ValueObject.value.equals("")){
					lock.wait();
				}
				String value  = System.currentTimeMillis()+"";
				System.out.println(" set value = "+ value);
				ValueObject . value = value;
				lock.notify();
			}
		}catch(Exception e){}
		System.out.println("setValue end");
	}

}