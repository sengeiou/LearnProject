package com.cocoa.dp.factory_02;

public class Main {
    public static void main(String[] args) {

        AbstractHumanFactory humanFactory = new HumanFactory();


        Chinese chinese = humanFactory.createHuman(Chinese.class);

        System.out.println(chinese.getColor() );
        System.out.println(chinese.getName() );

    }
}
