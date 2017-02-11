//: Playground - noun: a place where people can play

import UIKit

// 可选链式调用
// 可选链式调用 是一种可以在当前值可能为nil的可选值上请求和调用属性，方法及下标的方法

// 如果有可选值，调用就成功
// 如果可选值是nil， 那么调用就返回nil

// 多个调用可以串成一个调用链，如果其中任意一个节点为nil，整个调用链就会失败，返回nil



// # 使用可选链式调用代替强制展开
//**通过在想调用的属性、方法、或下标的可选值后面放一个问号（?），可以定义一个可选链。这一点很像在可选值后面放一个叹号（!）来强制展开它的值。它们的主要区别在于当可选值为空时可选链式调用只会调用失败，然而强制展开将会触发运行时错误。


// demo
class Person{
    var residence : Residence?
}

class Residence{
    var nuumberOfRooms = 1
}

var john = Person()
//let num = john.residence!.nuumberOfRooms  // 运行时错误


//可选链式调用提供了另一种访问numberOfRooms的方式，使用问号（?）来替代原来的叹号（!）：
if let roomCount = john.residence?.nuumberOfRooms{
    print(roomCount)
} else {
    print("the residence is nil")
}


// 通过赋值来改变
john.residence = Residence()

if let roomCount = john.residence?.nuumberOfRooms{
    print("the residence is \(roomCount)")
} else {
    print("the residence is nil")
}



// #为可选链式调用定义模型类
// 通过使用可选链式调用可以调用多层属性、方法和下标。这样可以在复杂的模型中向下访问各种子属性，并且判断能否访问子属性的属性、方法或下标。


// demo

class Person1{
    var residence : Residence1?
}

class Residence1{
    var rooms  = [Room]()

    var numberOfRooms : Int {
        return rooms.count
    }
    
    subscript(i : Int) -> Room{// 没搞明白
        
        get{
            return rooms[i]
        }
        
        set{
            rooms[i] = newValue
        }
        
    }
    
    subscript(s : String) -> String{
    
    get{
        return "---"
    }
    
    set{
        
    }
    
    }
    
    
    func printNumberOfRooms(){
        print("The number of rooms is \(numberOfRooms)")
    }
    
    var address : Address?

}

class Room {
    let name : String
    init(name : String){
        self.name  = name
    }
}

class Address{
    var buildingName : String?
    var buildingNumber : String?
    var street : String?
    func buildingIdentifier () -> String?{
        if buildingName != nil{
            return buildingName
        }else if buildingNumber != nil && street != nil {
            return "\(buildingNumber) \(street)"
        }else{
            return nil
        }
    }
    
}



// # 通过可选链式调用访问属性

let json  = Person1()

if let roomCount  = json.residence?.numberOfRooms{
    print(roomCount)
} else {
    print("nil")
}

json.residence =  Residence1()
// #通过可选链式调用方法


if json.residence?.printNumberOfRooms() != nil{
    print("can use")
    // 都可以调用，暂时看不出区别
    json.residence!.printNumberOfRooms()
    json.residence?.printNumberOfRooms()

}else{
    print("cant use")
}

json.residence?.rooms.append(Room(name : "longjuwu"))

// #通过可选链式调用访问下标
if let firstRoomName = json.residence?[0].name{
    print("\(firstRoomName)")
}else{
    print("firstRoomName is nil")
}

// 测试下标访问
if let tt  = json.residence?[""]{
    print(tt)
}




// #访问可选类型的下标 （字典暂时没学）



// # 连接多层可选链式调用
// 可以通过连接多个可选链式调用在更深的模型层级中访问属性，方法以及下标，

//通过可选链式调用访问一个Int值，将会返回Int?，无论使用了多少层可选链式调用。
//类似的，通过可选链式调用访问Int?值，依旧会返回Int?值，并不会返回Int??。


// demo
if let jsonStreet = json.residence?.address?.street{
    print(jsonStreet)
}else{
    print("jsonStreet is nil")
}


// 这章节的demo 有点奇怪，不是很明白，后续再看下


















