import java.lang.Integer;


public class test1 {
	public static void main(String[] args) {

		int a = 4;

		if (0 == (a & (a - 1))) {
			System.out.println("is 2 ");
		}



		System.out.println(Integer.toBinaryString(a));

		a = a & (a - 1) ;
		System.out.println(a );
		System.out.println(Integer.toBinaryString(a));


	}
}