//: Playground - noun: a place where people can play

import UIKit

// 协议
//协议 定义了一个蓝图，规定了用来实现某一特定任务或者功能的方法、属性，以及其他需要的东西。类、结构体或枚举都可以遵循协议，并为协议定义的这些要求提供具体实现。某个类型能够满足某个协议的要求，就可以说该类型遵循这个协议。



// 协议的定义
protocol SomeProtocol{
    
}

// 协议的使用
struct SomeStruct : SomeProtocol{

}

class SomeClass : SomeProtocol{

}


// 属性要求
//协议可以要求遵循协议的类型提供特定名称和类型的实例属性或类型属性。协议不指定属性是存储型属性还是计算型属性，它只指定属性的名称和类型。此外，协议还指定属性是可读的还是可读可写的。

//如果协议要求属性是可读可写的，那么该属性不能是常量属性或只读的计算型属性。如果协议只要求属性是可读的，那么该属性不仅可以是可读的，如果代码需要的话，还可以是可写的。

//协议总是用 var 关键字来声明变量属性，在类型声明后加上 { set get } 来表示属性是可读可写的，可读属性则用 { get } 来表示：


protocol FullyNamed{
    var fullName : String { get }
    }

struct Person : FullyNamed{
    
    internal var fullName: String
    var age  : Int
}

var john = Person(fullName: "john", age :12)

john.age = 13
john.fullName = "Sam"

// 测试 类型属性
























