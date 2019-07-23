//: Playground - noun: a place where people can play

import UIKit

// 扩展 就是为一个已有的类、结构体、枚举类型或者协议类型添加新功能。这包括在没有权限获取原始源代码的情况下扩展类型的能力（即 逆向建模 ）。扩展和 Objective-C 中的分类类似。

//Swift 中的扩展可以：

//添加计算型属性和计算型类型属性
//定义实例方法和类型方法
//提供新的构造器
//定义下标
//定义和使用新的嵌套类型
//使一个已有类型符合某个协议

// 计算属性
// 扩展可以为已有类型添加计算型实例属性和计算型类型属性。


// 构造器

//扩展可以为已有类型添加新的构造器。这可以让你扩展其它类型，将你自己的定制类型作为其构造器参数，或者提供该类型的原始实现中未提供的额外初始化选项。

//扩展能为类添加新的便利构造器，但是它们不能为类添加新的指定构造器或析构器。指定构造器和析构器必须总是由原始的类实现来提供。

//注意 如果你使用扩展为一个值类型添加构造器，同时该值类型的原始实现中未定义任何定制的构造器且所有存储属性提供了默认值，那么我们就可以在扩展中的构造器里调用默认构造器和逐一成员构造器。 正如在值类型的构造器代理中描述的，如果你把定制的构造器写在值类型的原始实现中，上述规则将不再适用。

// 方法
//扩展可以为已有类型添加新的实例方法和类型方法


//可变实例方法
//通过扩展添加的实例方法也可以修改该实例本身。结构体和枚举类型中修改 self 或其属性的方法必须将该实例方法标注为 mutating，正如来自原始实现的可变方法一样。

//下标
//扩展可以为已有类型添加新下标


//嵌套类型
//扩展可以为已有的类、结构体和枚举添加新的嵌套类型：




class SomeType {
    var x : String
    
    init(x : String) {
        self.x = x
    }
    
}

// 扩展的语法
extension  SomeType {
    
    // 也可以扩展存储型的类属性，文档里没有写
    static let text : String = "123"
    
    // 扩展计算属性
    var name : String {
        set(newValue) {
            x = newValue
        }
        get {
            return x
        }
    }
    
    // 扩展构造器
    // 扩展能为类添加新的便利构造器，但是它们不能为类添加新的指定构造器或析构器。指定构造器和析构器必须总是由原始的类实现来提供。
    convenience init(name : String, temp :String ){
        let t = name + temp
        self.init(x: t)
    }
    
    
}

// 也可以用来扩展多一个或多个协议
extension SomeType : Equatable {
    //协议实现写到这里
    static func ==(lhs: SomeType, rhs: SomeType) -> Bool{
        return lhs.name == rhs.name
    }

}

extension Int{
    //扩展可变实例
    mutating func square(){
        self = self * self
    }
}
var three : Int = 3
three.square()

// 下面的会报错 。cannot use mutating member on immutable value: literals are not mutable ，想来也是，你直接用3.square()，3本身肯定不是可变类型， 和 three 肯定不能比

// 3.square()


extension Int {
    // 扩展下标
    subscript(index : Int) -> Int {
        // 这里我好懒，直接返回了下标的值
        return index
    }
}

extension SomeType {
    // 扩展嵌套类
    class InnerClass {
        var name : String = "hahah"
    }
}

var some = SomeType.InnerClass()
some.name


1[10]  // 10

var p1 = SomeType(x:"123")
var p2 = SomeType(x:"223")

p1.name = "123"
p2.name = "12312"

print(p1.name)
print(p2.name)

p1 == p2


var p3 = SomeType(name: "cocoa", temp: " HELLO")
p3.name



var a : Int  = 10928423
var intStr  = "\(a)"






