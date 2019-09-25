//: Playground - noun: a place where people can play

import UIKit


// the basics

// 一般情况下，使用 Int 就行了，尽量不要使用 UInt 和 Int32 或 Int64
// 关于 int 和 doudle

Int.min
Int.max

Int64.min
Int64.max

// 可以这样申明
let million = 1_000_000


//浮点数  
// 指的是有小数部分的数字 

// Double 表示 64 位浮点数。 当需要存储很大或者高精度的浮点数时可以用这个
// Float 表示 32 位浮点数。 精度要求不高时可以用这个类型



// 类型安全和类型推断

var  a = 1
var  b = 1.00
// type inference  a 和 b 被分别推算为 int 和double 类型
type(of : a)
type(of : b)


// 会报错  
//var c  = a + b
// 如果要将两个类型不一致的变量相加，比如要统一变量的类型
var c = Double(a) + b



//布尔值
// Bool

var isOk : Bool  = true


// 元组 
// 元组 （tuples ）把多个值组合成一个复合值。 元组内的值可以是任意类型，不要求是同类型


// demo

let httpError = (404,"Not Found")  // 定义了 （Int，String）的元组

// 元组的使用

let (code , msg) = httpError
print(code)
print(msg)

// 如果你只需要 元组的一部分，分解的时候可以忽略 

let (num, _) = httpError
print(num)


// 还可以在定义元组时给单个元素命名


let httpOk = (code : 200, msg : "ok")

httpOk.code
httpOk.msg

// 元组非常有用，但是只局限于简单数据，如果数据的结构很复杂，可以使用 class 或 struct


// # 可选类型
// 使用可选类型 （optionals） 来处理值课呢那个确实的情况。

// 当可选类型有值时 等于 x  ; 没有时，等于 nil

let possibleNumber = "123"

let convertedNumber = Int(possibleNumber)

type(of : convertedNumber )

if let a = convertedNumber {
    print(a)
}

if( nil != convertedNumber){
    print(convertedNumber!)
}


if let actualNumber = Int(possibleNumber) {
    print("\(actualNumber)")
}   else {
    print("could not convert")
}


// 隐式解析可选值
// 上面说了，可选类型暗示了变量 或没有值的
// 但是有的可选类型在第一次赋值后，我们总能确定他是有值的，那么就可以将类型后的问号改成感叹号
let possibleString : String? = "123"
let forcedString : String   = possibleString! // 需要！ 来强制取值

let assumedString : String! = "123"
print(assumedString)    //不需要强制





// 错误处理

// 你可以使用 错误处理 （error handing ） 来处理对应程序执行中可能会会遇到的错误条件

// 如果是一个函数，可以使用 throws 来抛出错误
func canThrowsAnError() throws {
   // for index in 0 ... 10 {   // 貌似不能抛出 除0 的错误
   //     print(" \(10 / index) ")
   // }
}


do {
    try canThrowsAnError()

}catch{
    print("an error")
}





















