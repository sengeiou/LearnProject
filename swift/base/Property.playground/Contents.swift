//: Playground - noun: a place where people can play

import UIKit


//存储属性：存储在类或结构器体中的变量或常量

struct Person {
    var age : Int
}

class Dog {
    var name : String = ""
}





// 常量结构体

let p1 = Person(age:1)

//p1.age = 100  这里会在编译期报错，因为p1 是常量


let bomei  = Dog()

bomei.name = "bomei"   // 类实例在这里是不会报错的，很神奇







