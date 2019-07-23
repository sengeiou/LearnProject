//: Playground - noun: a place where people can play

import UIKit

// #扩展（Extensions）

// 扩展就是为一个已有的类，结构体，枚举类型或者协议类型添加新功能。




//  #计算型属性, 扩展可以为已有的类型添加计算型实例属性和计算型类属性
// 扩展可以添加新的计算型属性，但是不可以添加存储型属性，也不能为已有属性添加属性观察器

extension Double {
    //var aa : Double = 10.0   //不能添加存储型属性
    var mm : Double {
        get{
            return self * 1_000.0 // self就是他本身的值
        }
    }
}

extension Int{
    var mm : Int {
        return self * 10
    }
}

let one  = 1.mm
let two  = 0.2.mm


// #构造器，扩展可以为已有类型添加新的构造器。

//扩展能为类添加新的便利构造器，但是它们不能为类添加新的指定构造器或析构器。指定构造器和析构器必须总是由原始的类实现来提供。

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
    var size = Size()
}
//因为结构体 Rect 未提供定制的构造器，因此它会获得一个逐一成员构造器。又因为它为所有存储型属性提供了默认值，它又会获得一个默认构造器。详情请参阅默认构造器。这些构造器可以用于构造新的 Rect 实例：

let defaultRect = Rect()
let memberwiseRect = Rect(origin: Point(x: 2.0, y: 2.0),
                          size: Size(width: 5.0, height: 5.0))

extension Rect{
    init(center : Point , size : Size) {
        let originX = center.x - (size.width / 2)
        let originY = center.y - (size.height / 2)
        self.init(origin: Point(x : originX , y: originY),size : size)
    }
    // 下面是自己定义的，故意颠倒了参数
    init(size: Size , center : Point) {
        self.init(origin: center, size : size)
    }
}

let centerRect = Rect(center: Point(x: 4.0, y: 4.0),
                      size: Size(width: 3.0, height: 3.0))
// centerRect 的原点是 (2.5, 2.5)，大小是 (3.0, 3.0)

let myTest  = Rect(size: Size(width : 10, height : 10), center: Point(x : 10, y : 10))
// 发现myTest 也是可以的




// #方法 扩展可以为已有类型添加新的实例方法 和 类方法

//下面的例子为 Int 类型添加了一个名为 repetitions 的实例方法：

extension Int{
    //这个 repetitions(task:) 方法接受一个 () -> Void 类型的单参数，表示没有参数且没有返回值的函数。
    func repetitions(task:() -> Void){
        for _ in 0..<self{
            task()
        }
    }
}
// 写了两种调用的方法
// 1
var num : Int = 3
3.repetitions(task: {
    print("Hello")
})
func sayHello(){
    print("sayHello")
}
// 2 尾随闭包的写法，这样看起来比较简洁
4.repetitions {
    sayHello()
}


// #可变实例方法
//通过扩展添加的实例方法也可以修改该实例本身。结构体和枚举类型中修改 self 或其属性的方法必须将该实例方法标注为 mutating，正如来自原始实现的可变方法一样。

extension Int{
    mutating func square(){  //mutating必须加上，不然编译报错
        self = self * 10
    }
}

var someInt = 10
someInt.square()

print("someInt value is \(someInt)")



// # 下标，扩展可以为已有类型添加新下标。
//这个例子为 Swift 内建类型 Int 添加了一个整型下标。该下标 [n] 返回十进制数字从右向左数的第 n 个数字：

extension Int{
    subscript(digitIndex : Int) -> Int{
        var decimalBase = 1
        for _ in 0..<digitIndex{
            decimalBase *= 10
        }
        return (self / decimalBase) % 10
    }
}

1234567[0]
1234567[1]
1234567[2]
1234567[9] //如果该 Int 值没有足够的位数，即下标越界，那么上述下标实现会返回 0，犹如在数字左边自动补 0



// # 嵌套类型 扩展可以为已有的类、结构体和枚举添加新的嵌套类型：

extension Int{
    enum Kind{
        case Negative ,Zero ,Positive
    }
    
    var kind : Kind{
        switch self {
        case 0:
            return .Zero
        case let x where x > 0:
            return .Positive
        default:
            return .Negative
        }
    }
}

func printIntegerKind(array : [Int]) {
    for  a in array{
        switch a.kind {
        case .Negative:
            print("Negative")
        case .Zero:
            print("Zero")
        default:
            print("Positive")
        }
    }
}

printIntegerKind(array: [1,2,3,0,-1])





