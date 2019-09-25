package com.cocoa.dp.singleton_01;

//保证一个类仅有一个实例，并提供一个访问它的全局访问点。
public class Singleton {

    private Singleton(){

    }
    private static Singleton instance  =null;

	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
