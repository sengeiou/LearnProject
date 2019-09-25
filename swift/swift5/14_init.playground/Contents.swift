



// 存储属性的初始赋值

//类和结构体在创建实例时，必须为所有存储型属性设置合适的初始值。存储型属性的值不能处于一个未知的状态。
//你可以在构造器中为存储型属性赋初值，也可以在定义属性时为其设置默认值。 看下面的 demo1 和 demo2

// 构造器
//init(){
//
//}


//demo1
struct Fahrenheit{
    var temperature : Double
    init(){
        temperature = 22.22
    }
}

let f = Fahrenheit()
f.temperature

// 默认属性值
struct Fahrenheit1{
    var temperature = 22.22
}

// 自定义构造过程

// 构造参数
struct Player{
    var name : String
    init(_ name : String){   // 使用 _ 来隐藏外部名
        self.name = "Mr: \(name)"
    }
}

let cocoa  = Player("cocoa")
cocoa.name


//可选属性类型
struct Player1{
    var name : String
    var addr : String?
    init(name : String){    // 尝试去掉这个初始化，看看执行
        self.name = name
    }
}

var player1 = Player1(name: "123")
player1.name
player1.addr

//构造过程中常量属性的赋值
//你可以在构造过程中的任意时间点给常量属性指定一个值，只要在构造过程结束时是一个确定的值。一旦常量属性被赋值，它将永远不可更改。

struct Player2{
    var name : String
    let Number : Int
    init(name : String){    // 尝试去掉这个初始化，看看执行
        self.Number = 0x1123
        self.name = name
    }
}

var player2 = Player2(name: "123")
//player2.Number = 123    // 报错
player2.Number



// 默认构造器
//如果结构体或类的所有属性都有默认值，同时没有自定义的构造器，那么 Swift 会给这些结构体或类提供一个默认构造器（default initializers）。这个默认构造器将简单地创建一个所有属性值都设置为默认值的实例。

class ShopingListClass{
    var count : Double = 12.0
    var name : String = "egg"
}

var shopingListClass  = ShopingListClass()


//结构体的逐一成员构造器
//除了上面提到的默认构造器，如果结构体没有提供自定义的构造器，它们将自动获得一个逐一成员构造器（memberwise initializer），即使结构体的存储型属性没有默认值。
//
//逐一成员构造器是用来初始化结构体新实例里成员属性的快捷方法。我们在调用逐一成员构造器时，通过与成员属性名相同的参数名进行传值来完成对成员属性的初始赋值。






