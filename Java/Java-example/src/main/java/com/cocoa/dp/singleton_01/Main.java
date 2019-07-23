package com.cocoa.dp.singleton_01;

public class Main{
	public static void main(String[] args){
	
	Singleton[] sinArray = new Singleton[10];
	for (int i = 0 ; i< 10 ;i++){
		sinArray[i] = Singleton.getInstance();		
	}
	}
}
