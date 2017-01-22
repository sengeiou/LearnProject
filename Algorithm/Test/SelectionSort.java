public class SelectionSort{
	
	// public static int[] array ={1,3,4,2,7,9,8,0,5,0};
		public static int[] array ={9,8,6,7,5,4,3,2,1,0};

	public static void main(String[] args){

		change();

		for(int i =0 ;i <array.length;i++){
			System.out.println(array[i]);
		}

	}
	/**
	*选择排序 
	*/

	public static void change(){
		int length = array.length;
		int count = 0;	
		for(int i=0;i<length;i++){
			int min  = array[i];
			for(int j = i+1; j<length; j++ ){
				count ++;	
				if(array[j] < min){
					min = array[j];
					array[j] = array[i];
					array[i] = min;
					
				}	
			}
		}
		System.out.println("--"+count);
	}
}