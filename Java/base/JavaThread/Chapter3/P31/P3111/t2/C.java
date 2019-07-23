public class C{

	private String lock;

	public C(String lock){
		this.lock = lock;
	}

	public void getValue(){
		System.out.println("C getValue start");
		try{
			synchronized(lock){
				if(ValueObject.value.equals("")){
					lock.wait();
				}
				System.out.println("get Value =" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}	
		}catch(Exception e){

		}
		System.out.println("C getValue end");
	}
}