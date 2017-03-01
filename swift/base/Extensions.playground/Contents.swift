//: Playground - noun: a place where people can play

import UIKit

// #扩展（Extensions）

// 扩展就是为一个已有的类，结构体，枚举类型或者协议类型添加新功能。

extension Double {
    var mm : Double {
        get{
            return self * 1_000.0
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






