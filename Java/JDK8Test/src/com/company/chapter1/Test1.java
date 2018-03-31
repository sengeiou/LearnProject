package com.company.chapter1;


import java.util.*;
import com.company.bean.*;


public class Test1{
	public static void main(String[] args){
		List<Apple> list = new ArrayList<Apple>();
		list.add(new Apple("red",12));
		list.add(new Apple("green",13));
		
		List<Apple> result = filterApple(list);		
		System.out.println(result.size());
	}

	public static List<Apple> filterApple(List<Apple> invent){
		List<Apple> temp = new ArrayList<Apple>();
		for(Apple apple : invent){
			if("red".equals(apple.getColor())){
				temp.add(apple);
			}	
		}	
		return temp;
	}
 
}

