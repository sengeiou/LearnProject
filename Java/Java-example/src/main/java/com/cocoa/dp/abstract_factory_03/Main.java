package com.cocoa.dp.abstract_factory_03;

public class Main{
	public static void main(String[] args){
		HumanFactory femaleFactory  = new FemaleFactory();

		Human whiteFemaleHuman  =  femaleFactory.createWhiteHuman();
		
		whiteFemaleHuman.getColor();

		whiteFemaleHuman.talk();
		whiteFemaleHuman.getSex();

	}

}
