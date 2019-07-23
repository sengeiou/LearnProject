package com.company.lambda.t2;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Test{
	public static void main(String[] args){

		List<String> list = Arrays.asList(null, "hello", "world", "A", null, null);

		List<String> result = filter(list,(String s) -> s != null);

		for(String s :result){
			System.out.println(s);
		}

		forEach(list ,(String s) -> {
			if(s != null && s.length() > 2){	
				System.out.println("forEach=> "+s);
			}
		});

	}

	public static <T> void forEach(List<T> list, Consumer<T> c){
		for(T t : list){
			c.accept(t);
		}
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
		List<T> resultList = new ArrayList<>();
		for(T t : list){
			if(predicate.test(t)){
				resultList.add(t);
			}
		}
		return resultList;
	}
}





