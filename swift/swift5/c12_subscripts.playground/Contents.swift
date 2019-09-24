import UIKit

// 可以定义在类，结构体 和枚举中
// 一个类可以定义多个下标，下标不限于一纬

// 标准的定义
//subscript(index: Int) -> Int {
//    get{
//
//    }
//    set(newValue){
//
//    }
//}

struct TimeTable{
    let multiplier : Int
    subscript(index: Int) -> Int {
//        只有只读属性，可以省略 get
        return multiplier * index
    }
}

var timeTable = TimeTable(multiplier: 10)
print("the subscript \(timeTable[2])")












