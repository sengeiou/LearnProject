public class Test{
	public static void main(String[] args){
		Test t= new Test();
		String result =t.test();
		System.out.println(result);

		t.test2();

	}


	public  String test(){
		try{
			return "123";
		}catch(Exception  e){

		}finally{
			System.out.print("finally");	
		}
		return "out";
	}




	public void test2(){
		switch("123"){
			case "123":
			System.out.println("123");
			break;
			default:
			break;	
		}	

	}




}