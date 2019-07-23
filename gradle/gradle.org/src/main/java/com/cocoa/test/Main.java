package com.cocoa.test;

import com.google.gson.Gson;



public class Main{

	private String name = "cocoa";


	public static void main(String[] args){
		Gson gson = new Gson();

		System.out.println(gson.toJson(new Main()));
	}
}
