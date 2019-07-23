//: Playground - noun: a place where people can play

import UIKit

// create an empty array

var array1 : Array<Int>  = Array<Int>()
var array2 : [Int] = []
var array3 = array2

var arrayTest : [()] = []
print(arrayTest.count)



//initialization with values

var threeDoubles  = Array(repeating:1.1 , count :3)


//用数组字面量构造数组

var shoppingList : [String] = ["eggs","milks"]


//访问和修改数组
print(shoppingList.count)  // 数组元素的数量
print(shoppingList.isEmpty)  //数组是否为空


shoppingList[0]   // 获取数组第一个元素
shoppingList.append("book")  //数组添加元素

shoppingList[0] = "six eggs"
shoppingList

//不可以用下标访问的形式去在数组尾部添加新项。
shoppingList.insert("bike", at: 1)  // 在指定位置添加元素

let removeValue = shoppingList.remove(at: 0)  // 删除某个位置的元素，并返回删除的值


shoppingList.removeLast()  // 删除最后一个元素


shoppingList

shoppingList.removeAll()  // 删除所有元素

shoppingList


// #数组的遍历

// 循环添加数组
for index in 0...5 {
    shoppingList.append("\(index)")
}

//循环获取数组的元素
for item in shoppingList{
    print(item)
}

// 如果同时需要索引和数组的值


for (index,value) in shoppingList.enumerated(){
    print("index is \(index) and value is \(value)")
}




/**
 总结，数组还是比较简单的，主要就是数组的初始化，要记住！
 1.数组使用有序列表存储同一类型的多个值。相同的值可以多次出现在一个数组的不同位置中。
 2.Swift 的Array类型被桥接到Foundation中的NSArray类。

 */











