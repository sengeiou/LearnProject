package com.cocoa.dp.factory_02;

/*
工厂方法
<br>
定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到其子类。
<br>
工厂方法属于创建型的设计模式，提供了一种创建对象的最佳方法

<br>
在本章的例子中
抽象类 Human 负责定义人类的共性，实现对人类的最抽象的定义
抽象类 AbstractHumanFactory 就是抽象工厂， 人类的创建由 HumanFactory 来具体实现。
HumanFactory 通过参数 Class 来进行反射，创建对象

<br>
在很多情况下，你可以不需要创建 AbstractHumanFactory 类，而直接定义 HumanFactory 来创建对象，
这样就是传说中的简单工厂模式

<br>
工厂方法的好处有很多，比如封装性，代码结构清晰，很好的降低模块间的耦合，你不需要知道产品的创建过程，
你只需要知道类名就可以了。

扩展性非常好。

屏蔽产品类，调用者不要关心产品类，只需要关心产品接口，接口不变，产品类就不需要改变，



 */
public class Main {
    public static void main(String[] args) {

        AbstractHumanFactory humanFactory = new HumanFactory();


        Chinese chinese = humanFactory.createHuman(Chinese.class);

        System.out.println(chinese.getColor() );
        System.out.println(chinese.getName() );

    }
}
