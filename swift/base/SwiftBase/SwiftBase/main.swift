//
//  main.swift
//  SwiftBase
//
//  Created by shenjun on 16/2/20.
//  Copyright © 2016年 shenjun. All rights reserved.
//

import Foundation

//1.创建空字符串的两种方法

var str1 = ""
var str2 = String()

//2.可以用string的isEmpty()方法判断字符串是否为空

if str1 .isEmpty{
    print("str1 is empty string")   //will print
}

//3.var字符串具有可变性   let则没有

var str3 =  "123"

    str3 = "456"   // 正确， str3的值被修改为456

let str4 = "123"

    //str4 = "456"   //编译出错,let定义的常量在定义后不允许修改


//4.字符串是值类型Strings are value type

//5.可以用for-in 来循环遍历string

for s in str4.characters {
    print(s)
}


//5.字符串差值，官方的说法，类似于在字符串中使用其他类型的变量

var pi  = 3.1415926

let message = " pi is \(pi) "

print(message)  //pi is 3.1415926


//6.字符串除了可以重新赋值和+= 增加元素外，还有别的方法进行元素的增加和删除

var addStr = "123"

addStr.insert("4", atIndex: addStr.endIndex) //当然还有startIndex

print(addStr)  //1234


addStr.removeAtIndex(addStr.startIndex)

print(addStr)  //234


//大小写转换
let  strlowercase  = "cocoa"
let  struppercase  = "HAHA"

print(strlowercase.uppercaseString) //COCOA
print(struppercase.lowercaseString) //haha

//字符串输出

let intValue = 3

print(String(intValue))//  3

typealias a = Int

var s  : a = 1



























