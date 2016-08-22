/**
#Collection
* 160821
 

 */

import UIKit

//Swift 语言提供Arrays、Sets和Dictionaries三种基本的集合类型用来存储集合数据。数组（Arrays）是有序数据的集。集合（Sets）是无序无重复数据的集。字典（Dictionaries）是无序的键值对的集。

// swift 中 集合也会受到 let 和var 的影响 let 申明的集合无法改变集合的长度和数据，如果，程序用的集合不需要去改变，最好申明为 let ，这样，编译器会优化我们创建的集合

// 数组 array
// cerate empty array
var array1 = [Int]()
// create default element&count array
var array2 = [Double](repeatElement(0.0, count: 10))
// 
var array3 : [String] = ["China" , "Other","...."]
// 通过swift 类型推断机制
var array4 = [1,2,3,4]


//access & modify an array
//using count  

print(array1.count)
print(array2.count)

// isEmpty

print(array1.isEmpty)
print(array2.isEmpty)

// add new item to the end of  an array 

array2.append(12.12)

array3 += ["cocoa"]
array4 += [6]

// get value

var a =  array2[0]    //at swift the first item is zero index


// insert item at a specified index
array2.insert(11.11, at: 1)


//remove 

array2.remove(at: 0)
array2.removeLast()
print(array2)
array2.removeAll()

//  interating an array 

for item in array3
{
print(item)
}

for (index , value ) in array3.enumerated(){
    print("index = \(index) and the value = \(value)")
}


// sets 集合

var set1 = Set<Int>()
var set2 : Set<Double> = [11.11,12.11]


// add item 
set1.insert(1)
























































