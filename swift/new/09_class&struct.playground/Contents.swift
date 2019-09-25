




// 类和结构体的不同
// 1. 类允许继承
// 2. 类可以转换
// 3. 类有析构器
// 4. 类有自动计数器

// 结构体是值传递， 类是引用传递
// 两者的定义

class SomeClass{
    var name = ""
    var age  = 0
}
struct SomeStruct{
    var name = ""
    var age  = 0
}


// 创建实例

var someClass = SomeClass()
var someStruct = SomeStruct()

// 访问属性
someClass.age
someStruct.name


//结构体的成员逐一构造器
let someStruct1 = SomeStruct(name: "coco", age: 12)




