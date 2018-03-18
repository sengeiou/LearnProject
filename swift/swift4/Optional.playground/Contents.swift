//: Playground - noun: a place where people can play

import UIKit



var optional1 : String?
optional1 = "123"

print(optional1)
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

print(optional4)


// 当然 ，你也可以这么操作, 但是当 optional4 为 nil 时，可能会引起奔溃
//optional4!.append("123")










