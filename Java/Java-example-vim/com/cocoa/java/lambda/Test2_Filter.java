package com.cocoa.java.lambda;

import java.util.function.Predicate;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Test2_Filter{
	public static void main(String[] args){
		IntStream intStream = IntStream.range(0,100);
		intStream.filter( i -> i%2==0 ).forEach(System.out::print);
		
		System.out.println("");
		
		
		IntStream intStream1 = IntStream.range(0,100);
		IntPredicate pre1 = ( item ) -> item %2 != 0 ;
		intStream1.filter(pre1).forEach(System.out::print);
		System.out.println("");


		List<TestItem> mList = new ArrayList<>();
		mList.add(new TestItem("cocoa",12));
		mList.add(new TestItem("lily",22));
		mList.add(new TestItem("wangliu",32));
		mList.add(new TestItem("lisi",11));
		
		Predicate<TestItem> numPre = (item) -> item.getNumber() > 20;
		Predicate<TestItem> namePre = (item) -> item.getName().contains("co");

		mList.stream().filter(numPre.or(namePre)).forEach(System.out::println);



	}

}

