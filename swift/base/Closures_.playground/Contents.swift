//: Playground - noun: a place where people can play

import UIKit

// # 闭包 （ Closures ）

// 闭包是自包含的函数代码块，可以在代码中被传递和使用。

// 闭包可以捕获和存储其所在上下文中任意常量和变量的引用。被称为包裹常量和变量。 Swift 会为你管理在捕获过程中涉及到的所有内存操作。

// 在函数章节中介绍的全局和嵌套函数实际上也是特殊的闭包，闭包采取如下三种形式之一：

// 全局函数是一个有名字但不会捕获任何值的闭包
// 嵌套函数是一个有名字并可以捕获其封闭函数域内值的闭包
// 闭包表达式是一个利用轻量级语法所写的可以捕获其上下文中变量或常量值的匿名闭包

// Swift 的闭包表达式拥有简洁的风格，并鼓励在常见场景中进行语法优化，主要优化如下：

// 利用上下文推断参数和返回值类型
// 隐式返回单表达式闭包，即单表达式闭包可以省略 return 关键字
// 参数名称缩写
// 尾随闭包语法


// 闭包表达式
// 嵌套函数是一个在较复杂函数中方便进行命名和定义自包含代码模块的方式。当然，有时候编写小巧的没有完整定义和命名的类函数结构也是很有用处的，尤其是在你处理一些函数并需要将另外一些函数作为该函数的参数时。

// 闭包表达式是一种利用简洁语法构建内联闭包的方式。闭包表达式提供了一些语法优化，使得撰写闭包变得简单明了。下面闭包表达式的例子通过使用几次迭代展示了 sorted(by:) 方法定义和语法优化的方式。每一次迭代都用更简洁的方式描述了相同的功能。


// sorted 方法

let numbers  = [5,1,3,4,6,8,10,9,7]

func sort(_ s1 : Int , _ s2 : Int) -> Bool{
    return s1 > s2    // s1 大于 s2 返回 true 表示 s1 应该出现在 s2 前，降序
}


let resultArray = numbers.sorted(by: sort)

for value in resultArray {
    print(value)
}

// Swift 标准库提供了名为 sorted(by:) 的方法，它会根据你所提供的用于排序的闭包函数将已知类型数组中的值进行排序。一旦排序完成，sorted(by:) 方法会返回一个与原数组大小相同，包含同类型元素且元素已正确排序的新数组。原数组不会被 sorted(by:) 方法修改。

// 这个方法就是用了闭包， 产生了很大的灵活性


// #闭包表达式语法

//{  (parasms) -> returnType in
//    statment
//}

var  result = numbers.sorted(by:{ $0 > $1 })



// 闭包表达式参数 可以是 in-out 参数，但不能设定默认值。也可以使用具名的可变参数（译者注：但是如果可变参数不放在参数列表的最后一位的话，调用闭包的时时编译器将报错。可参考这里）。元组也可以作为参数和返回值。


//下面的例子展示了之前排序函数对应的闭包表达式版本的代码：

let resultArray2 = numbers.sorted(by: { (s1 : Int , s2 : Int) -> Bool in
    return  s2 > s1
})

//然而在内联闭包表达式中，函数和返回值类型都写在大括号内，而不是大括号外。

// 闭包的函数体部分由关键字in引入。该关键字表示闭包的参数和返回值类型定义已经完成，闭包函数体即将开始。



// # 根据上下文推断
// 因为排序闭包函数是作为 sorted(by:) 方法的参数传入的，Swift 可以推断其参数和返回值的类型。sorted(by:) 方法被一个字符串数组调用，因此其参数必须是 (Int, Int) -> Bool 类型的函数。这意味着 (Int, Int) 和 Bool 类型并不需要作为闭包表达式定义的一部分。因为所有的类型都可以被正确推断，返回箭头（->）和围绕在参数周围的括号也可以被省略：



let resultArray3 = numbers.sorted(by: { s1, s2 in return s1 > s2 })
resultArray3


// 实际上，通过内联闭包表达式构造的闭包作为参数传递给函数或方法时，总是能够推断出闭包的参数和返回值类型。这意味着闭包作为函数或者方法的参数时，你几乎不需要利用完整格式构造内联闭包。

// 尽管如此，你仍然可以明确写出有着完整格式的闭包。


// # 但表达式闭包隐式返回
// 单行表达式闭包可以通过省略 return 关键字来隐式返回单行表达式的结果，如上版本的例子可以改写为：


let resultArray4 = numbers.sorted(by: { s1, s2 in s1 > s2 })
resultArray4


// #参数名称缩写
//  Swift 自动为内联闭包提供了参数名称缩写功能，你可以直接通过 $0，$1，$2 来顺序调用闭包的参数，以此类推。

// 如果你在闭包表达式中使用参数名称缩写，你可以在闭包定义中省略参数列表，并且对应参数名称缩写的类型会通过函数类型进行推断。in关键字也同样可以被省略，因为此时闭包表达式完全由闭包函数体构成：


let  resultArray5 = numbers.sorted(by: { $0 > $1 })
resultArray5


// 运算符方法

// 实际上还有一种更简短的方式来编写上面例子中的闭包表达式。Swift 的 Int 类型定义了关于大于号（>）的字符串实现，其作为一个函数接受两个 Int 类型的参数并返回 Bool 类型的值。而这正好与 sorted(by:) 方法的参数需要的函数类型相符合。因此，你可以简单地传递一个大于号，Swift 可以自动推断出你想使用大于号的字符串函数实现：

let resultArray6 = numbers.sorted(by: < )


// 尾随闭包
// 如果你需要将一个很长的闭包表达式作为最后一个参数传递给函数，可以使用尾随闭包来增强函数的可读性。尾随闭包是一个书写在函数括号之后的闭包表达式，函数支持将其作为最后一个参数调用。在使用尾随闭包时，你不用写出它的参数标签：


func someFunctionThatTakesAClosure(closure: () -> Void) {
    // 函数体部分
}

// 以下是不使用尾随闭包进行函数调用
someFunctionThatTakesAClosure(closure: {
    // 闭包主体部分
})

// 以下是使用尾随闭包进行函数调用
someFunctionThatTakesAClosure() {
    // 闭包主体部分
}

// 所以， 上面的 sorted 方法可以改成这样

var resultArray7 = numbers.sorted(){ $0 > $1 }
resultArray7

// 如果闭包表达式是唯一的参数，可以省掉() 
var  resultArray8  = numbers.sorted{ $0 > $1 }
resultArray8



// # 值捕获

// 闭包可以在其被定义的上下文中捕获常量或变量。即使定义这些常量和变量的原作用域已经不存在，闭包仍然可以在闭包函数体内引用和修改这些值。

// Swift 中，可以捕获值的闭包的最简单形式是嵌套函数，也就是定义在其他函数的函数体内的函数。嵌套函数可以捕获其外部函数所有的参数以及定义的常量和变量。


func makeIncrementer(forIncrement amount: Int) -> () -> Int {
    var runningTotal = 0
    func incrementer() -> Int {
        runningTotal += amount
        return runningTotal
    }
    return incrementer
}

let incrementByTen = makeIncrementer(forIncrement: 10)
// 理解这里犯了一个错误，为什么这里返回10 而不是20，因为上面的代码并没有调用incrementer ，所以runningTotal就是0
incrementByTen() // 返回10 这里才是真正的第一次调用
incrementByTen() // 返回20

// 但是这个函数真正神奇的是，incrementByTen() 单独调用后， 居然还能访问runningTotal 的值，因为返回的值在不断的累加，这就是上面的解释：即使定义这些常量和变量的原作用域已经不存在，闭包仍然可以在闭包函数体内引用和修改这些值。

// 当然你也可以创建另一个 increment ， 它会有自己的引用，指向一个全新的，独立的 runningTotal 变量

let incrementByOne = makeIncrementer(forIncrement:1)
incrementByOne()
incrementByOne()


// # 闭包是引用类型
// incrementByOne 和 incrementByTen都是常量，但是这些常量指向的闭包仍然可以增加其捕获的变量的值。这是因为函数和闭包都是引用类型。


// # 逃逸闭包
// 当一个闭包作为参数传到一个函数中，但是这个闭包在函数返回之后才被执行，我们称该闭包从函数中逃逸。当你定义接受闭包作为参数的函数时，你可以在参数名之前标注 @escaping，用来指明这个闭包是允许“逃逸”出这个函数的。


// 一种能使闭包“逃逸”出函数的方法是，将这个闭包保存在一个函数外部定义的变量中。举个例子，很多启动异步操作的函数接受一个闭包参数作为 completion handler。这类函数会在异步操作开始之后立刻返回，但是闭包直到异步操作结束后才会被调用。在这种情况下，闭包需要“逃逸”出函数，因为闭包需要在函数返回之后被调用。例如：


var completionHandlers : [() -> Void] = []

func someFunctionWithEscapingClosure(completionHandler : @escaping () -> Void){
    completionHandlers.append(completionHandler)
}

// 将一个闭包标记为 @escaping 意味着你必须在闭包中显式地引用 self。

func someFunctionWithNonescapingClosure(closure: () -> Void) {
    closure()
}

class SomeClass {
    var x = 10
    func doSomething() {
        someFunctionWithEscapingClosure { self.x = 100 } // 去掉 self 试试看
        someFunctionWithNonescapingClosure { x = 200 }//非逃逸闭包就不需要加self
    }
}

let instance = SomeClass()
instance.doSomething()
print(instance.x)
// 打印出 "200"

completionHandlers.first?()
print(instance.x)
// 打印出 "100"

// #自动闭包(!!! 不好理解，后面再看)

// 自动闭包是一种自动创建的闭包，用于包装传递给函数作为参数的表达式。这种闭包不接受任何参数，当它被调用的时候，会返回被包装在其中的表达式的值。这种便利语法让你能够省略闭包的花括号，用一个普通的表达式来代替显式的闭包。

// 我们经常会调用采用自动闭包的函数，但是很少去实现这样的函数。

