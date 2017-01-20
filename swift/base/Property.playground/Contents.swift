//: Playground - noun: a place where people can play

import UIKit


//存储属性：存储在类或结构器体中的变量或常量（如果是常量，只允许在初始化时赋值，后面都允许修改）
// 存储属性可以在定义的时候指定默认值，也可以在构造中设置修改值，甚至可以修改常量存储属性的值(如果已经有了默认值，那么构造方法就不能修改)
struct Person {
    var age : Int
    let familyName : String
    
}

class Dog {
    var name : String = ""
}





// 常量结构体，结构体是值类型，当结构体被申明为常量的时候，它的属性也就成了常量

// class 则不一样，把一个class的引用赋值给一个常量时，仍然可以修改这个实例的变量

//var pp = Person()   // 结构体的默认构造器

let p1 = Person(age:1,familyName:"ss")

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















