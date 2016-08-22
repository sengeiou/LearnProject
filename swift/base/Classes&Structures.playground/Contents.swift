/**
 class & struct


*/
import UIKit



struct PersonStruct{
    var x = 0
    var y = 0
}

class PersonClass{
    var person =  PersonStruct()
    var isH = true
    var name : String?
}


var ps = PersonStruct()
var pc = PersonClass()


print(ps.x)
print(pc.person.x)


// 结构体成员逐一构造器,只有结构体有，类没有这个逐一构造器
var ps1 = PersonStruct(x: 10, y: 10)
print(ps1.x)


//在swift中，整数，浮点数，布尔，字符串，数组，字典，结构体，枚举都是值类型

//类则是引用类型，做个小实验来看下

func change(var ps:PersonStruct){
    ps.x = 11
}


change(ps)

print(ps.x)

//发现结构体并没有因为change方法而改变，但是不知道为什么，在change方法的参数中，var ps:PersonStruct  ps必须设置为var


func change(pc :PersonClass){
    pc.name = "123"
}

change(pc)

print(pc.name)

// 类的name 因为change方法而改变了


















