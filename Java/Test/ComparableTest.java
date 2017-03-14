import java.util.*;

public class ComparableTest implements Comparable<ComparableTest>{

	public  int age ;

	public ComparableTest(int age){
		this.age  = age ;
	}

	public static void main(String[] args){

		ComparableTest t1  = new ComparableTest(1);
		ComparableTest t2  = new ComparableTest(2);
		ComparableTest t3  = new ComparableTest(3);
		
		ComparableTest[]  mList = {t1 ,t3, t2};

		for (ComparableTest c : mList){
			System.out.println(c);
		}		

		Arrays.sort(mList);

		System.out.println("start change");

		for (ComparableTest c : mList){
			System.out.println(c);
		}	

	}
	@Override
	public String toString(){
		return "person age ="+ age;
	}

	@Override
	public int compareTo(ComparableTest o){
		return this.age - o.age;
	}




}