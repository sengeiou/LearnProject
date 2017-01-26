//: Playground - noun: a place where people can play

import UIKit
// 构造过程


// #存储属性的初始赋值

//类和结构体在创建实例时，必须为所有存储属性设置合适的初始值,存储属性的值不能处于未知状态
// 可以在构造器中为存储属性赋值，也可以在定义属性时设置默认值, 注意，前面的两种赋值不会触发属性观察器



// # 构造器
// 某个特定类型的新实例创建的时候被调用，最简单的形式就是无参构造器，构造器以关键字 init() 命名

// example

//init(){
// 写构造过程
//}


// demo 用构造器给存储属性设置默认值

struct FFF{
    var temprature : Double
    
    init(){
    temprature = 12.12
    }
}

var f = FFF()
f.temprature



// # 默认属性值，即在属性申明时为其设置默认值
// 如果在一个属性总是使用相同的初始值，那么建议使用申明时就设置默认值，这样会使构造器更加简洁明了


// demo

struct SSS{
    var temp = 0.0   //直接设置默认值
}



// #自定义构造过程
//你可以通过输入参数和可选类型的属性来自定义构造过程，也可以在构造过程中修改常量属性（这个都行，有点牛逼的）


// # 构造参数
// 自定义构造过程时，可以在定义中提供构造参数，指定所需值的类型和名字
// 其实就是自定义init() 



struct Person1{
    var age : Int
    var name : String
    // 这段代码之所以不会报错，因为结构体有自己的逐一构造器
}

struct Person2{
    var age : Int
    var name : String
 

    
    init(withAge age : Int){
        self.age = age
        self.name = "nunu" // 去掉这句话试试，就会报错，因为name这个储存属性没有默认值，所以就会报错,除非定义name的设置默认值
    }
}


//var p = Person2(10,"") 从这里看到，如果重新定义结构体的构造器，那么原本的逐一构造器就消失了

var p = Person2(withAge: 10)
p.age
p.name




// # 参数的内部名称和外部名称
struct Color{
    let red, green ,blue : Double
    init(red : Double , green : Double ,blue : Double ){
        self.red = red
        self.green = green
        self.blue = blue
    }
    init(white : Double ){
        red = white
        green = white
        blue = white
    }
}

// 使用构造器初始化
let c1 = Color(red: 0.0, green: 0.0, blue: 0.0)
let c2 = Color(white: 0.0)


// let c3 = Color(0.0, 0.0, 0.0)  编译报错，需要外部名称
// Swift 会为构造器的每个参数自动生成一个跟内部名字相同的外部名。（当然你也可以显示的指定）


// #不带外部名的构造器参数
// 如果不想为构造器的某个参数设置外部名，你可以使用下划线(_)来显式描述它的外部名
//（通俗的将就是可以Color(0.0, 0.0, 0.0)这样调用）
// demo 以上面的Color举例

struct CC{
    var red , green : Double
    
    init(_ red : Double , _ green : Double){
        self.green = green
        self.red = red
    }
}

let cc1 = CC(0.0,0.0)  //不带外部名的构造器，个人不建议使用，java就是这样，搞的什么参数都不知道了


// # 可选属性类型
//当你不知道参数的默认值时，可以把属性定义为可选属性类型，可选类型的属性将自动初始化为nil，表示这个属性是有意在初始化时设置为空的。


class XXX{
    var name : String
    var info : String?
    
    init(_name : String){
        name  = _name
    }
}

var xx = XXX(_name: "shenjun")
xx.info
xx.info == nil
xx.info = "sure info"
xx.info


// #构造过程中常量属性的修改
// 构造过程的任意时间都可以修改常量，只要在构造过程结束时是一个固定的值

class SurveyQuestion{
    let text : String
    init(text : String){
        self.text = text
    }
}


var s  = SurveyQuestion(text: "ha")
s.text
//s.text = "123"  编译报错


// # 默认构造器
// 如果结构体或类的所有属性都有默认值，同时没有自定义的构造器，那么系统就会提供一个默认构造区（测试结构体和类）


struct Human1{
    var name : String?
    var age = 0
}

let h1 = Human1()
let h2 = Human1(name: "shenjun", age: 12)
//关于struct，系统会提供一个无参的构造器和一个逐一参数构造器

class Human2{
    var name : String?
    var age : Int?
}
let h21 = Human2()
// 关于class，系统只会提供一个无参数的构造器


// # 结构体的逐一成员构造器（只有struct 有）
//除了上面提到的默认构造器，如果结构体没有提供自定义的构造器，它们将自动获得一个逐一成员构造器，即使结构体的存储型属性没有默认值。
//逐一成员构造器是用来初始化结构体新实例里成员属性的快捷方法。我们在调用逐一成员构造器时，通过与成员属性名相同的参数名进行传值来完成对成员属性的初始赋值。




// # 值类型的构造器代理（结构体和枚举）类类型因为涉及到继承，比较复杂
// 构造器可以通过调用其它构造器来完成实例的部分构造过程。可以减少构造器间的代码重复
// 对于值类型，可以在自定义的构造器中调用self.init，（只能在构造器中调用）
// 为某个值类型定义一个自定义的构造器，将无法访问到默认构造器（结构体将无法访问逐一成员构造器）
// demo

struct Size{
    var width = 0.0
    var height = 0.0
}

struct Point{
    var x = 0.0
    var y = 0.0
}

struct Rect{
    var origin = Point()
    var size  = Size()
    init(){}   //如果自己不写，那么就会被自定义构造器覆盖
    init(origin : Point ,size : Size){
        self.origin = origin
        self.size  = size
    }
    
    init(center : Point, size : Size){
        let originX = center.x - (size.width / 2)
        let originY = center.y - (size.height / 2)
        self.init(origin: Point(x: originX, y: originY), size: size)  // 调用了另一个构造器
    }
    
    
}


// # 类的继承和构造过程
// 类里面的所有存储型属性——包括所有继承自父类的属性——都必须在构造过程中设置初始值。
//Swift 为类类型提供了两种构造器来确保实例中所有存储型属性都能获得初始值，它们分别是指定构造器和便利构造器。


// #指定构造器和便利构造器
//一个指定构造器将初始化类中提供的所有属性，并根据父类链往上调用父类的构造器来实现父类的初始化。
//每一个类都必须拥有至少一个指定构造器。在某些情况下，许多类通过继承了父类中的指定构造器而满足了这个条件。具体内容请参考后续章节构造器的自动继承。

//便利构造器是类中比较次要的、辅助型的构造器。你可以定义便利构造器来调用同一个类中的指定构造器，并为其参数提供默认值。你也可以定义便利构造器来创建一个特殊用途或特定输入值的实例。

// 便利构造器的语法
//convenience init(parameters) {
//    statements
//}


// # 类的构造器代理原则
//规则 1
//指定构造器必须调用其直接父类的的指定构造器。
//规则 2
//便利构造器必须调用同类中定义的其它构造器。
//规则 3
//便利构造器必须最终导致一个指定构造器被调用。

//一个更方便记忆的方法是：
//指定构造器必须总是向上代理
//便利构造器必须总是横向代理























































