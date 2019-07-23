//: Playground - noun: a place where people can play

import UIKit


//## 表示并抛出错误
// 错误用符合Error协议的类型的值来表示。这个空协议表明该类型可以用于错误处理。
// 定义错误
enum VendingMachineError: Error {
    case invalidSelection                    //选择无效
    case insufficientFunds(coinsNeeded: Int) //金额不足
    case outOfStock                          //缺货
}

//抛出错误使用throw关键字
//throw VendingMachineError. insufficientFunds(coinsNeeded: 5)


//Swift 中有4种处理错误的方式。你可以把函数抛出的错误传递给调用此函数的代码、用do-catch语句处理错误、将错误作为可选类型处理、或者断言此错误根本不会发生。每种方式在下面的小节中都有描述。


//1. 用 throwing 函数传递错误 ，其实就是调用层抛出错误
// 但是在 throwing 传递的时候，要配合 try 使用的，看 test1 中的 testTemp，可以去掉 try 看看

//2. do-catch 处理
//do {
//    try expression
//    statements
//} catch pattern 1 {
//    statements
//} catch pattern 2 where condition {
//    statements
//}

//3. 将错误转换成可选值
// 可以使用try?通过将错误转换成一个可选值来处理错误。如果在评估try?表达式时一个错误被抛出，那么表达式的值就是nil

//4. 禁用错误传递
// 有时你知道某个throwing函数实际上在运行时是不会抛出错误的，在这种情况下，你可以在表达式前面写try!来禁用错误传递，这会把调用包装在一个不会有错误抛出的运行时断言中。如果真的抛出了错误，你会得到一个运行时错误。
// 这个还是要谨慎使用


// 用 defer 指定清理操作，
// 使用 抛出错误，return、break 等操作后，可以用 defer 定义代码块来执行清理工作，比如用来关闭文件

// defer语句将代码的执行延迟到当前的作用域退出之前。该语句由defer关键字和要被延迟执行的语句组成。延迟执行的语句不能包含任何控制转移语句，例如break、return语句，或是抛出一个错误。延迟执行的操作会按照它们声明的顺序从后往前执行——也就是说，第一条defer语句中的代码最后才执行，第二条defer语句中的代码倒数第二个执行，以此类推。最后一条语句会第一个执行

// 查看详细的 调用顺序，请查看  test3


// test1
enum CustomError : Error {
    case nullPointer
}

func test(msg : String) throws{
    if msg == "" {
            throw CustomError.nullPointer
    }
    print(msg)
}

// 测试用 throwing 函数传递错误
func testTemp(msg: String) throws{
    try test(msg:"")  // 一定要加上 try
}

//try test(msg: "")  // 测试只有 try 没有 do-catch 时的情况，发现出错


do{
    try test(msg: "Hello world")
}catch CustomError.nullPointer {
    print("find error ")
}

// test2

enum NumberError : Error {
    case numToSmall // the num will > 0
}

func numberFormat( num : Int) throws -> Int{
    if num < 0{
        throw NumberError.numToSmall
    }
    return num
}



let result1 = try? numberFormat(num: -10)
print(result1)

let result2 = try? numberFormat(num: 10)
print(result2)

let result3 : Int?
do{
    result3 = try numberFormat(num: -1)
}catch {
    result3 = nil
}

// 上面的写法中， result1 和 result3 的写法等价，将错误值转换成了可选值



// test3 测试 defer
func deferTest() throws{
    defer{
        print("defer1")
    }
    print("do somethings1")
    
    defer{
        print("defer2")
    }
    print("do somethings2")
    
}
try deferTest()
//do somethings1
//do somethings2
//defer2
//defer1









