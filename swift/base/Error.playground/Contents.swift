//: Playground - noun: a place where people can play

import UIKit

// Error
// 错误处理（Error handling）是响应错误以及从错误中恢复的过程。Swift 提供了在运行时对可恢复错误的抛出、捕获、传递和操作的一等公民支持。

// 某些操作无法保证总是执行完所有代码或总是生成有用的结果。可选类型可用来表示值缺失，但是当某个操作失败时，最好能得知失败的原因，从而可以作出相应的应对。


// # 表示并抛出异常
// 在 Swift 中，错误用符合Error协议的类型的值来表示。这个空协议表明该类型可以用于错误处理。

// Swift 的枚举类型尤为适合构建一组相关的错误状态，枚举的关联值还可以提供错误状态的额外信息。例如，你可以这样表示在一个游戏中操作自动贩卖机时可能会出现的错误状态：

//   自定义错误， 就是去扩展 Error 这个空协议
//   然后写各类的错误
enum VendingMachineError: Error {
case invalidSelection                    //选择无效
case insufficientFunds(coinsNeeded: Int) //金额不足
case outOfStock                          //缺货
}



// 处理错误
// Swift 中有4种处理错误的方式。你可以把函数抛出的错误传递给调用此函数的代码、用do-catch语句处理错误、将错误作为可选类型处理、或者断言此错误根本不会发生。



// 用 throwing 函数传递错误
// 为了表示一个函数，方法或构造器可以抛出异常， 在函数的参数列表之后 加 上 throws 关键字，如果这个函数有返回值，那么 throws 就要写在箭头之前

// 比如这样：  下面的代码表明，如果你把方法定义成了throwing 函数，不一定要抛出异常, 但是调用的时候一定要捕获
func canThrowErrors() throws -> String
{
    return ""
}
// 一个 throwing 函数可以在其内部抛出错误，并将错误传递到函数被调用时的作用域。





// 用  Do-Catch 处理错误
// 可以使用一个do-catch语句运行一段闭包代码来处理错误。如果在do子句中的代码抛出了一个错误，这个错误会与catch子句做匹配，从而决定哪条子句能处理它。



// 基本使用形式
//do {
//    try expression
//    statements
//} catch pattern 1 {
//    statements
//} catch pattern 2 where condition {
//    statements
//}


// #将错误转换成可选值
// 可以使用 try？ 通过讲错转换成一个可选值来处理错误。 如果在评估 try？ 表达式时一个错误被抛出， 那么表达式的值就是 nil 



func someThrowingFunction(p : Bool ) throws -> Int{
    if( p){
     throw VendingMachineError.insufficientFunds(coinsNeeded: 0)
    }
    return 1
}


let x  = try? someThrowingFunction(p: true)
let y  = try? someThrowingFunction(p: false)



// # 禁用错误传递
// 有时你知道某个throwing函数实际上在运行时是不会抛出错误的，在这种情况下，你可以在表达式前面写try!来禁用错误传递，这会把调用包装在一个不会有错误抛出的运行时断言中。如果真的抛出了错误，你会得到一个运行时错误。

// 例如，下面的代码使用了loadImage(atPath:)函数，该函数从给定的路径加载图片资源，如果图片无法载入则抛出一个错误。在这种情况下，因为图片是和应用绑定的，运行时不会有错误抛出，所以适合禁用错误传递：

// let photo = try! loadImage(atPath: "./Resources/John Appleseed.jpg")

// 个人不推荐这样的写法


// # 指定清理操作
// 可以使用defer语句在即将离开当前代码块时执行一系列语句。该语句让你能执行一些必要的清理工作，不管是以何种方式离开当前代码块的——无论是由于抛出错误而离开，还是由于诸如return或者break的语句。例如，你可以用defer语句来确保文件描述符得以关闭，以及手动分配的内存得以释放。

//  defer语句将代码的执行延迟到当前的作用域退出之前。该语句由defer关键字和要被延迟执行的语句组成。延迟执行的语句不能包含任何控制转移语句，例如break或是return语句，或是抛出一个错误。延迟执行的操作会按照它们被指定时的顺序的相反顺序执行——也就是说，第一条defer语句中的代码会在第二条defer语句中的代码被执行之后才执行，以此类推。

//func processFile(filename: String) throws {
//    if exists(filename) {
//        let file = open(filename)
//        defer {
//            close(file)
//        }
//        while let line = try file.readline() {
//            // 处理文件。
//        }
//        // close(file) 会在这里被调用，即作用域的最后。
//    }
//}

// 个人觉得 defer 类似于 java 中 finally，用来处理资源的清理很合适，稍后会在最下面的代码测试





// 自定义错误 并使用
// 学驾照要年满18岁，在代码中，我们判断未满18岁。就抛出 Error , 满足18岁 ，就返回 true 
// 虽然有点不合理，但是主要是学习如果使用 Error

enum ConfromError : Error{
    case AgeNotConfrom
}


class Person {
    var age : Int = 0
    
    func canLearnDirve() throws -> Bool{
        defer{
            print(self.age) // 查看这行代码的输出结果
        }
        
        if self.age < 18{
            throw ConfromError.AgeNotConfrom
        }
        return true
    }

}

var p = Person()
p.age = 19

do {
    var  result : Bool = try p.canLearnDirve()
    print( result )
} catch ( ConfromError.AgeNotConfrom ){
    print("AgeNotConfrom")
}


