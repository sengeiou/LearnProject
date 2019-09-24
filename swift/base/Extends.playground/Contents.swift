//: Playground - noun: a place where people can play

import UIKit
// 继承  extends
// 类可以继承另一个类的方法,属性和其它特性


//可以为类中继承的属性添加属性观察器，（存储属性和计算属性都可以）



// # 定义一个基类（基类就是不继承于其它的类）
// swift中的类并不是从一个通用的基类继承而来，如果你不为自定义的类制定一个超类，那么这个类就是基类，（有点区别与java，java 中的类都是继承于java.lang.Object）

//官方demo

class Vehicle{
    var currentSpeed = 0.0
    var description  :String{
        return "at \(currentSpeed)"
    }
    func makeNoise(){
        //让子类去实现
    }
}

let someVehicle = Vehicle()

someVehicle.description


//创建子类

class Bicycle : Vehicle{
    //在这里写子类的定义
    var hasBasket  = false
}

var mBicycle  = Bicycle()

mBicycle.currentSpeed = 12.12

print(mBicycle.description)
print(mBicycle.hasBasket)

//mBicycle.description = "123"   只读属性

//someVehicle.hasBasket   父类的实例无法调用子类的方法


// #重写

//子类可以为继承来的实例方法，类方法，实例属性，或下标提供自己定制的实现。我们把这种行为叫重写。
//在重写前定义的前面加上override关键字，去告诉编译器，你是重写了这个定义，而不是重复定义


// #访问超类的方法，属性和下标
// 在重写父类的定义的时候，也可以使用super 关键字来调用父类的定义
// 比如：在方法someMethod 中， 调用 super.someMethod
//      在属性someProperty的getter 和setter 中 ，调用 super.someProperty
//      在下表重写的实现中，调用super[someIndex]


// 官方demo 重写方法

class Train : Vehicle{
    
    override func makeNoise() {   // 重写这个方法
        print("wu~~~~ wu~~~~~")
    }

}

let train = Train()
train.makeNoise()


// 重写属性
// 可以重写继承来的实例属性或类属性，提供自己的setter 和 getter，或者添加自己的属性观察器



class Car : Vehicle{
    var gear = 1
    
    override var description: String{   // 重写只读属性
        return super.description + "  override add \(gear)"
    }
    
    //添加属性观察器
    override var currentSpeed: Double{
        
        willSet(newValue){
            print("the newValue is \(newValue)")
        }
        didSet{
            print("oldValue is \(oldValue)")
        }
    
    }
    
}

let mCar = Car()
mCar.currentSpeed = 123
mCar.description



// #防止重写
// 使用final 关键字来防止被重写
// 如果重写了 带有final 的定义，那么编译器会报错
// 如果在类前面添加final ，那么这个类就不能被继承


//类型方法可以用static或者class来修饰，如果父类的类型方法使用static修饰的话，子类不能重写；如果父类的类型方法使用class修饰的话，子类能够重写。但是如果父类的类型方法是同时使用final class修饰的话，子类就不能重写。也就是说，static自带final性质，希望子类能够重写使用class修饰，不希望子类重写使用static修饰，final class修饰看起来别扭，因为一个允许重写（class），另一个不允许重写（final）。



































