//: Playground - noun: a place where people can play

import UIKit


// class 和 struct 的定义
class Person1{
    var name = ""
    var age : Int = 0
    
}

struct Person2{
    var height = 10
    var width  = 10
}


// class 和 struct 的创建和调用，语法都是一致的
let p1  = Person1()
let p2  = Person2()

print("person age is \(p1.age)")
print(p2.height)



// 结构体的成员逐一构造器, 而class则没有这个构造器
let p22 = Person2(height:1000,width:10000)
print(p22.height)

// 结构体和枚举是值类型
// 值类型在进行传递的时候会被复制
// 这里我们将p22赋值给一个新的变量p33，然后改变p33的height

var p33 = p22

p33.height = 333

print(p22.height)
print(p33.height)
// p33修改的height对p22没有产生影响



//class 是引用类型
//与值类型不同，引用类型在被赋予到一个变量、常量或者被传递到一个函数时，其值不会被拷贝。因此，引用的是已存在的实例本身而不是其拷贝。

var p111  = Person1()

var p123 = p111


p123.age = 123

print(p111.age)
print(p123.age)

//p123对age的修改，对p111的age 产生了影响


//判断两个class 的变量是否是同一个实例，可以使用=== 和!==

print(p111 === p123)
print(p111 !== p1)




/**
总结：
1 class 和 struct 的定义和创建几乎一致
2 class 是引用类型， struct则是值类型
3 官方给的class 和 struct 的选择，只要符合下面的一条，就可以使用struct
 3.1该数据结构的主要目的是用来封装少量相关简单数据值。
 3.2有理由预计该数据结构的实例在被赋值或传递时，封装的数据将会被拷贝而不是被引用。
 3.3该数据结构中储存的值类型属性，也应该被拷贝，而不是被引用。
 3.4该数据结构不需要去继承另一个既有类型的属性或者行为。
 
 
 
*/









































































