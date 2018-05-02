package com.company.lambda;

public class Test1 {
	public static void main(String[] args){
		new Thread(
			() ->  System.out.println("im lamb")
		).start();	
		
	}
}