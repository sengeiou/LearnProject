package com.company;

import com.company.bean.Apple;
import java.util.*;


/*
* 在这个例子中，我们把过滤的条件放到了外部，由外部进行参数的传递，看起来比chapter1 灵活了很多
* 但还是存在着很多问题，比如像要过滤重量呢？
*
*
*
*
*
*
*
*
*/
public class Chapter2{
	
	public static List<Apple> filter(String color,List<Apple> mList){
	List<Apple> temp= new ArrayList<>();
	for(Apple apple : mList){
		if(color.equals(apple.getColor())){
			temp.add(apple);	
		}
	}
	return temp;
	}


    public static void main(String[] args){

	List<Apple> temp= new ArrayList<>();
	temp.add(new Apple("red",12));	
	temp.add(new Apple("yellow",22));	
	temp.add(new Apple("green",14));	

	List<Apple> result = filter("red",temp);
	System.out.println(result.size());
    }
}

