//: Playground - noun: a place where people can play

import UIKit

// 下标，下标可以定义在类，结构体，枚举中，是访问集合，列表或序列中元素的快捷方式.
// 简单的说，用下标访问Array，可以这么写，Array[index]

//subscript(index : Int) -> Int
//{
//    get{
//    
//    }
//    
//    set(newValue){
//    }
//}

// 如果只读计算属性，可以省略get 关键字
//
//subscript(index: Int) -> Int {
//    // 返回一个适当的 Int 类型的值
//}

struct TimesTable{
    let multiplier : Int
    subscript(index : Int) -> Int{
        return index * multiplier   
    }
}

var timer = TimesTable(multiplier: 12)
timer[3]



// 下标用法

// 下标通常作为访问集合，列表或序列中元素的快捷方式，可以针对自己的类或结构体的功能来自由的定义下标



//  下标可以接受任意数量的入参，并且这些入参可以是任意类型。下标的返回值也可以是任意类型。下标可以使用变量参数和可变参数，但不能使用输入输出参数，也不能给参数设置默认值。

//  一个类或结构体可以根据自身需要提供多个下标实现，使用下标时将通过入参的数量和类型进行区分，自动匹配合适的下标，这就是下标的重载。







