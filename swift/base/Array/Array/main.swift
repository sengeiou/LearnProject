//
//  main.swift
//  Array
//
//  Created by shenjun on 16/2/21.
//  Copyright © 2016年 shenjun. All rights reserved.
//

import Foundation

//创建数组的三种方法
var strArray =  [String]()
var intArray = [1,2,3]
var array = Array<String>()

// 数组的常用方法

print(intArray.count)  //数组的长度
intArray.append(4)     //在数组的最后增加元素
intArray.insert(5, atIndex: 0) //在数组的指定位置增加元素

print(intArray.isEmpty)

intArray.removeFirst()  //各种删除的方法
intArray.removeLast()
intArray.removeAll()
//intArray.removeAtIndex(0)  //注意，这里会报错，因为前面已经调用了removeAll

print(intArray)


intArray.append(1)
intArray.append(2)
intArray.append(3)

//interation

for number in intArray {
    print(number)
}

for (index,value) in intArray.enumerate(){
    print("index @ \(index) valuse= \(value)")
}





















