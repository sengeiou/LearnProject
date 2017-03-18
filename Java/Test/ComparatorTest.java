import java.util.*;

public class ComparatorTest implements Comparator<Person>{

	@Override
	public int compare(Person p1 , Person p2){
		return p1.age - p2.age;
	}

	public boolean equals(Object obj){ return true ;}



	public static void main(String[] args){

		Person  p1 = new Person(1);
		Person  p2 = new Person(2);
		Person  p3 = new Person(3);
	
		Person[] list = {p2, p3, p1};

		for(Person p : list){
			System.out.println(p);
		}


		Arrays.sort(list, new ComparatorTest());	

		for(Person p : list){
			System.out.println(p);
		}


	}

}