public class TestJoin{

	public static void main(String[] args){

		Thread A = new Thread(new Runnable(){

			@Override
			public void run(){
				print();
			}

		});

		Thread B = new Thread(new Runnable(){

			@Override
			public void run(){
				try{
					A.join();
				}catch (Exception e) {
					
				}
				print();
			}
		});

		A.start();
		B.start();


	}
	public static void print(){

		for (int i  =0; i< 3 ; i++){
			try{
				Thread.sleep(1000);
			}catch(Exception e){

			}
			System.out.println("----="+i);
		}


	}


}