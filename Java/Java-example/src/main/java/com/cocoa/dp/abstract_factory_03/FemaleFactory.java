package com.cocoa.dp.abstract_factory_03;


public class FemaleFactory implements HumanFactory{
	
	public Human createWhiteHuman(){
		return new FemaleWhiteHuman();
	}
}
