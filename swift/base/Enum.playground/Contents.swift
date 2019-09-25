//: Playground - noun: a place where people can play

import UIKit

// # 枚举

// 枚举为一组相关的值定义了一个共同的类型
// swift 中的枚举很灵活，不需要给每一个枚举成员提供一个值
// 如果给枚举成员提供一个初始值，则该值的类型可以是 字符串，字符，整型 或浮点型

//此外，枚举成员可以指定任意类型的关联值存储到枚举成员中，就像其他语言中的联合体（unions）和变体（variants）。你可以在一个枚举中定义一组相关的枚举成员，每一个枚举成员都可以有适当类型的关联值。（不是很理解）



// 枚举语法
enum SomeEnum {
    
}

//demo 
enum CompassPoint{
    case north , south , east , west
}


// 也可以写成
enum OtherCompassPoint{
    case north  //不同于C 语言，north，south，east和west不会被隐式地赋值为0，1，2和3
    case south
    case east
    case west
}

var tt  = CompassPoint.east
print(tt)

//一旦tt被声明为CompassPoint类型，你可以使用更简短的点语法将其设置为另一个CompassPoint的值

tt = .west
print(tt)


// 使用switch 语句匹配枚举值
switch tt{
case .west :
    print(tt)
case .north :
    print(tt)
default:
    print("default")
}

// #关联值
//有时候能够把其他类型的关联值和成员值一起存储起来会很有用。这能让你连同成员值一起存储额外的自定义信息，并且你每次在代码中使用该枚举成员时，还可以修改这个关联值。


// demo 举了例子，一个商品有两种码，一个条形码和一个二维码
enum Barcode {
    case upc(Int , Int , Int , Int )
    case qrcode(String)
}

//“定义一个名为Barcode的枚举类型，它的一个成员值是具有(Int，Int，Int，Int)类型关联值的upc，另一个成员值是具有String类型关联值的qrCode。”


var productBarCode = Barcode.upc(1, 1, 1, 1)
productBarCode = .qrcode("http://item.taobao.com/id=1")

//像先前那样，可以使用一个 switch 语句来检查不同的条形码类型。然而，这一次，关联值可以被提取出来作为 switch 语句的一部分。你可以在switch的 case 分支代码中提取每个关联值作为一个常量（用let前缀）或者作为一个变量（用var前缀）来使用：

switch productBarCode {
case .upc(let num1, let num2, let num3, let num4):
// let 也可以申明为var 如果全部的参数都是var 或者let 可以这么写
//case let .upc(num1, num2, num3, num4):
        print(num1)
case .qrcode(let qrcode):
        print(qrcode)
default://当不需要匹配每个枚举成员的时候，你可以提供一个default分支来涵盖所有未明确处理的枚举成员  这里会出现黄色感叹号是因为我们的switch 已经匹配了所有的情况，不会到这个default中了
    print("default")
}

// 这个demo 个人的理解就是，枚举的每个成员不用类型一致


// # 原始值
// 枚举成员可以被默认值（称为原始值）预填充，这些原始值的类型必须相同。

enum ASCII : Character{
    //enum case cannot have a raw value if the enum does not have a raw type  如果不显示申明类型，就会报这个错
    case tab = "\t"
    case line = "\n"
    case carr = "\r"
//    case tt = "\r"  会报错  raw value previously used here因为值是位置的， carr 已经了 “\r”
//    case ss  =  1   会报错，类型错误
    
}

//原始值可以是字符串，字符，或者任意整型值或浮点型值。每个原始值在枚举声明中必须是唯一的。


// 原始值的隐式赋值
// 在使用原始值为整数或者字符串类型的枚举时，不需要显式地为每一个枚举成员设置原始值，Swift 将会自动为你赋值。

enum Planet : Int{
    case mercury = 1, venus, earth, mars, jupiter, saturn, uranus, neptune
}
//在上面的例子中，Plant.mercury的显式原始值为1，Planet.venus的隐式原始值为2，依次类推。

//当使用字符串作为枚举类型的原始值时，每个枚举成员的隐式原始值为该枚举成员的名称。(上面的CompassPoint 就是这样的，不过必须要申明为有原始值的，就是带上类型)


// 可以用.rawValue 来查看原始值
//let eastRawValue = CompassPoint.east.rawValue  居然会报错，原来是没有申明为原始值

// 重新定义一个带有原始值的指南针类
enum CompassPoint2 : String {
    case north , south , east , west
}

let eastRawValue = CompassPoint2.east.rawValue
let neptuneRawValue = Planet.neptune.rawValue



// 使用原始值初始化枚举类型
// 如果在定义枚举类型的时候使用了原始值，那么就会自动获得一个初始化的方法，这个方法接收一个rawValue的参数，参数类型即为原始值类，返回则是枚举成员或nil

if let c = CompassPoint2(rawValue:"north1"){
    print(c)
}else {
    print("no")
}

if let p  = Planet(rawValue : 7){   //注意这个类型，原始值类型
    print(p)
}

// 根据 rawValue 生成的 enum 是一个 Optional 类型
print( type(of: Planet(rawValue : 112)))


// 另一种写法
if let p  = Planet(rawValue : 6){
    switch p {
    case .earth:
        print("p is earth")
    case .saturn:
        print("p is saturn")
    default:
        print("p is default")
    }
}else {
    print("p is nil")

}


// 递归枚举
//递归枚举是一种枚举类型，它有一个或多个枚举成员使用该枚举类型的实例作为关联值。使用递归枚举时，编译器会插入一个间接层。你可以在枚举成员前加上indirect来表示该成员可递归。

enum ArithmeticExpression{
    case number(Int)
    indirect case add(ArithmeticExpression,ArithmeticExpression)
    indirect case mult(ArithmeticExpression,ArithmeticExpression)
}

// 使用
let five = ArithmeticExpression.number(5)
let four = ArithmeticExpression.number(4)

let sum  = ArithmeticExpression.add(five, four)
let product  = ArithmeticExpression.mult(five, four)

func evaluate(_ expression: ArithmeticExpression) -> Int {
    switch expression {
    case let .number(value):
        return value
    case let .add(left, right):
        return evaluate(left) + evaluate(right)
    case let .mult(left, right):
        return evaluate(left) * evaluate(right)
    }
}

evaluate(sum)
evaluate(four)
evaluate(product)
// 搞不懂，为什么要搞这么复杂，递归枚举等要用的时候再看吧






































