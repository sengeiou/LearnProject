package com.company;

import java.util.*;
import com.company.bean.Apple;

public class Chapter3 implements ApplePredicate{
	
	@Override
	public boolean test(Apple a){
		if("red".equals(a.getColor())){
			return true;
		} 	
		return false;
	}
		

	public List<Apple> filter(ApplePredicate ap, List<Apple> mList){
		List<Apple> temp = new ArrayList<>();
		for(Apple apple : mList){
			if(ap.test(apple)){
				temp.add(apple);
			}
		}		
		return temp;
	}


	public static void main(String[] args){
		List<Apple> temp = new ArrayList<>();	
		temp.add(new Apple("red",12));
		temp.add(new Apple("yellow",12));
		temp.add(new Apple("red",13));
		
		Chapter3 test = new Chapter3();
		List<Apple> result = test.filter(test,temp);
		System.out.println(result.size());
	}

	

}


interface ApplePredicate{
	boolean test(Apple a);
}
