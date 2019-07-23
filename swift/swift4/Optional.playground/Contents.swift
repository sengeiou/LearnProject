//: Playground - noun: a place where people can play

import UIKit


//可选链式调用
// 如果可选值有值，那么调用就会成功；如果可选值是nil，那么调用将返回nil。多个调用可以连接在一起形成一个调用链，如果其中任何一个节点为nil，整个调用链都会失败，即返回nil

class Residence{
    var number = 111
}
class Person{
    var residence : Residence?
}

let john = Person()

if let num = john.residence?.number {  // 因为链式调用， number 会被当成是 Int？
    print(num)
} else {
    print("error")
}

john.residence = Residence()

if let num = john.residence?.number {
    print(num)
} else {
    print("error")
}


// 然后接着往下 , 为 Residence 添加新的变量和方法 成为一个新的类
class Room{
    let name : String?
    init(name : String){
        self.name  = name
    }
}
class Address{
    var buildingName: String?
    var buildingNumber: String?
    var street: String?
    func buildingIdentifier() -> String? {
        if buildingName != nil {
            return buildingName
        } else if buildingNumber != nil && street != nil {
            return "\(buildingNumber) \(street)"
        } else {
            return nil
        }
    }
}

class Residence1 {
    var rooms : [Room] = []
    var numberOfRooms : Int {
        return rooms.count
    }
    subscript(i : Int) -> Room {
        get{
            return rooms[i]
        }
        set{
            rooms[i] = newValue
        }
    }
    func printNumberOfRooms(){
        print("number of rooms os \(numberOfRooms)")
    }
    var address : Address?
}

class Person1{
    var residence : Residence1?
}

var cocoa = Person1()

let someAddress = Address()
someAddress.buildingNumber = "29"
someAddress.street = "Acacia Road"
cocoa.residence?.address = someAddress
// 上面的一行会失败， 因为cocoa 的 residence 还是 nil
// 但是因为是可选连调用，address = someAddress 并没有被执行

// printNumberOfRooms 没有返回值，但是如果通过 可选连调用，则返回的是 Void？ 所以你可以这么去判断是否为 nil
if cocoa.residence?.printNumberOfRooms() != nil {
    print("It was possible to print the number of rooms.")
} else {
    print("It was not possible to print the number of rooms.")
}

// 同样的，可以据此判断通过可选链式调用为属性赋值是否成功，cocoa.residence 仍旧为 nil
// 所以 address = someAddress 的操作会返回 nil
if (cocoa.residence?.address = someAddress) != nil {
    print("It was possible to set the address.")
} else {
    print("It was not possible to set the address.")
}
// 打印 “It was not possible to set the address.”




// 下面是些练习和补充

var optional1 : String?
optional1 = "123"

print(optional1 as Any)
print(optional1!)


var optional2 : String! = "123"
print(optional2)

if let code = optional1 , let codeInt = Int(code) {
    print(codeInt)
    print(type(of: codeInt))
}

if let code = optional1 ,let codeInt = Int(code), 123 == codeInt {
    print("equals")
}


var optional3 : String?

var result = optional3 ?? "default"

print(result)

// 上面都是一些简单的操作

// 下面看下一些不好懂的

//原地修改可控实例
var optional4 : String?

// 如果optional4 有值，则加入新的字符，如果optional4 是 nil ，则不变
optional4?.append(" pleasr try again")

optional4


// 当然 ，你也可以这么操作, 但是当 optional4 为 nil 时，可能会引起奔溃
//optional4!.append("123")











