//: Playground - noun: a place where people can play

import UIKit
/**
 
 Swift Methods

 http://wiki.jikexueyuan.com/project/swift/chapter2/11_Methods.html

 swift 中，在结构体，类，枚举中都可以定义方法
 
 
 */



// # 实例方法
// 实例方法是属于某个特定类，结构体或者枚举类型实例的方法

// self 等同于java 中的this,相当于该实例本身


class Counter{
    var count :Int = 0

    func increment(){
        count += 1
    }
    
    func increment(by count : Int){
        self.count += count  //self 最主要的作用
    }
    
    func reset(){
        count = 0
    }

}


var xiaoli = Counter()

xiaoli.increment(by: 10)

print(xiaoli.count)



//# 在实例方法中修改值类型
// 结构体和枚举是值类型，默认情况下，值类型的属性不能在它的实例方法中被修改
//如果想要这么操作，可以在方法前加入  可变(mutating)

struct T1{
    var x = 0
    var y = 0
    
    mutating func change(withX x:Int , withY y :Int){
        self.x += x
        self.y += y
    }
}

var t1 = T1(x: 10, y: 10)

t1.change(withX: 101, withY: 202)

print(t1.x)



//# 在可变方法中给self赋值
//奇葩用法

struct T2{
    var x = 0
    var y = 0
    
    mutating func change(withX x:Int , withY y :Int){
       self =  T2(x: x, y: y)
    }
}

var t2 = T2(x: 1, y: 2)
t2.change(withX: 1000, withY: 2000)

print(t2.x)



//#类型方法

//实例方法是被某个类型的实例调用的方法。
//你也可以定义在类型本身上调用的方法，这种方法就叫做类型方法。
//在方法的func关键字之前加上关键字static，来指定类型方法。类还可以用关键字class来允许子类重写父类的方法实现。(不是很理解)

class SomeClass{
    static func someTypeMethod(){
        print("...")
    }
    
    class func otherTypeMethod(){
        print("other")
        }
    
}

SomeClass.someTypeMethod()
SomeClass.otherTypeMethod()











