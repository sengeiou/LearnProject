//: Playground - noun: a place where people can play

import UIKit

// 属性
// 属性将值跟特定的类、结构或枚举关联。存储属性存储常量或变量作为实例的一部分，而计算属性计算（不是存储）一个值。计算属性可以用于类、结构体和枚举，存储属性只能用于类和结构体。

// #存储属性：存储在类或结构器体中的变量或常量（如果是常量，只允许在初始化时赋值，后面都不允许修改）
// 存储属性可以在定义的时候指定默认值，也可以在构造中设置修改值，甚至可以修改常量存储属性的值(如果已经有了默认值，那么构造方法就不能修改)
struct Person {
    var age : Int
    let familyName : String   // 在这里设置默认值看
    
}

class Dog {
    var name : String = ""
}

var shenjun  = Person(age: 29, familyName: "shen")

shenjun.age = 12
//shenjun.familyName = "wang" 报错




// #常量结构体的存储属性，
// 如果创建了一个结构体的实例并将其赋值给一个常量，则无法修改该实例的任何属性，即使有属性被声明为变量也不行：
// array 就是用 let 和 var 来区分不可变和可变的
// 结构体是值类型，当结构体被申明为常量的时候，它的属性也就成了常量
// class 则不一样，把一个class的引用赋值给一个常量时，仍然可以修改这个实例的变量


let p1 = Person(age:1,familyName:"ss")
//p1.age = 12   // p1 定义为let 后，就无法修改p1的任何属性
//p1.familyName = "aaa"  //这里会在编译期报错，因为p1 是常量，familyName 也不允许被修改

let bomei  = Dog()
bomei.name = "bomei"   // 类实例在这里是不会报错的



// # 延迟存储属性
// 当第一次被调用时才会计算其初始值的属性，在属性申明前 使用lazy 来标示
//必须将延迟存储属性声明成变量（使用 var 关键字），因为属性的初始值可能在实例构造完成之后才会得到。而常量属性在构造过程完成之前必须要有初始值，因此无法声明成延迟属性。

// 官方的demo
class DataImporter {
    /*
     DataImporter 是一个负责将外部文件中的数据导入的类。
     这个类的初始化会消耗不少时间。
     */
    var fileName = "data.txt"
    // 这里会提供数据导入功能
}

class DataManager {
    lazy var importer = DataImporter()
    var data = [String]()
    // 这里会提供数据管理功能
}

let manager = DataManager()
print(manager)

manager.data.append("Some data")
manager.data.append("Some more data")
// DataImporter 实例的 importer 属性还没有被创建

manager.importer.fileName = "123"
print(manager)

//如果一个被标记为 lazy 的属性在没有初始化时就同时被多个线程访问，则无法保证该属性只会被初始化一次。


// #存储属性和实例变量


// 计算属性 （类，结构体，枚举中都可以定义）
// 计算属性不直接存储值，而是提供一个getter 和一个可选的setter，来间接获取和设置其他属性或变量的值

// 官方demo

struct Point{
    var x = 0.0
    var y = 0.0
}
struct Size {
    var width = 0.0
    var height = 0.0
}
struct Rect{
    var origin  = Point()
    var size  = Size()
    var center : Point{
        get{
            let centerX = origin.x + (size.width / 2)
            let centerY = origin.y + (size.height / 2)
            return Point(x: centerX, y: centerY)
        }
    
        set(newCenter){
            origin.x = newCenter.x - (size.width / 2)
            origin.y = newCenter.y - (size.height / 2)
        }
    }
}



// 看了代码还是很好理解的
var rect = Rect(origin: Point(x:0.0,y:0.0), size: Size(width: 10.0, height: 10.0))

let initCenter  = rect.center
print(initCenter.x)
print(initCenter.y)

rect.center = Point(x: 11.0, y: 11.0)

print(rect.origin.x)
print(rect.origin.y)


// 自己测试计算属性的demo

struct Bird{
    var x : Int
    var age : Int {
        get{
            return 11
        }
        
        set(newAge){
            x = newAge
        }

    }

}


var bird  = Bird(x:10)
bird.age = 101
var age  = bird.age



//经过自测，发现以下几点问题，
//1.计算属性在结构体内没有逐一构造器
//2.计算属性不能在结构体内设置默认值
//3.计算属性值能设置成var ，即使是只读计算属性（就是只定义了get的）




// 属性观察器
//每次属性被设置新值的时候，就会调用属性观察器
//除了延迟属性外，别的属性存储属性都可以添加属性观察期
//可以添加如下的一个或多个观察器
//1. willSet 在新值被设置前调用
//2. didSet  在新值被设置后调用


/**
 willSet 观察器会将新的属性值作为常量参数传入，在 willSet 的实现代码中可以为这个参数指定一个名称，如果不指定则参数仍然可用，这时使用默认名称 newValue 表示。
 
 同样，didSet 观察器会将旧的属性值作为参数传入，可以为该参数命名或者使用默认参数名 oldValue。如果在 didSet 方法中再次对该属性赋值，那么新值会覆盖旧的值。
 
 
 */

class SetpCounter{
    var step : Int = 0 {  //类中必须设置初始值？
        willSet{//这里使用默认值。也可以使用willSet(newExample)来自定义
            print("the newValue = \(newValue)")
        }
        didSet{
            print("the oldValue = \(oldValue)")
        }
    }
    
//    init(){
//        self.step = 1
//    }
    
}

var stepCounter = SetpCounter()

stepCounter.step = 10
//the newValue = 10
//the oldValue = 0
stepCounter.step = 101
//the newValue = 101
//the oldValue = 10

//结果很明显，不解释了

class PParent{
    var age : Int {
        willSet{
            print("PParent willSet  \(newValue)")

        }
        didSet{
            print("PParent didset  \(oldValue)")
        }
        
    }
    init(age : Int) {
        self.age  = age
    }
    
}

class CC : PParent{
       override init(age: Int) {
            super.init(age: age)
            self.age = age
       }
}

var cc = CC(age: 10)


//#全局变量和局部变量



//计算属性和属性观察器所描述的功能也可以用于全局变量和局部变量。（不是很理解？）
//全局变量是在函数、方法、闭包或任何类型之外定义的变量。
//局部变量是在函数、方法或闭包内部定义的变量。
//全局的常量或变量都是延迟计算的，跟延迟存储属性相似，不同的地方在于，全局的常量或变量不需要标记lazy修饰符。
// 局部范围的常量或变量从不延迟计算。


//# 类型属性（有点类似java static 变量）
//为类型本身定义属性，无论创建了多少个该类型的实例，这些属性都只有唯一一份。这种属性就是类型属性。
//存储型类型属性可以是变量或常量，计算型类型属性跟实例的计算型属性一样只能定义成变量属性。

//使用关键字 static 来定义类型属性。在为类定义计算型类型属性时，可以改用关键字 class 来支持子类对父类的实现进行重写。


//官方demo

struct SomeStructure {
    static var storedTypeProperty = "Some value."
    static var computedTypeProperty: Int {
        return 1
    }
}
enum SomeEnumeration {
    static var storedTypeProperty = "Some value."
    static var computedTypeProperty: Int {
        return 6
    }
}
class SomeClass {
    static var storedTypeProperty = "Some value."
    static var computedTypeProperty: Int {
        return 27
    }
    class var overrideableComputedTypeProperty: Int {
        return 107
    }
}







//跟实例属性一样，类型属性也是通过点运算符来访问。但是，类型属性是通过类型本身来访问，而不是通过实例

print(SomeClass.storedTypeProperty)

var someClass = SomeClass()
//print(someClass.storedTypeProperty)   //  居然是报错的
// swift 中类型属性只能由类去获取，并不能由类实例去获取
























