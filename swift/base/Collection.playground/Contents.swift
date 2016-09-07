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
//create set with an array
var set2 : Set<Double> = [11.11,12.11]
// 或者可以简写成  ,swift 自动推断set3 的类型 Set<String>
var set3 : Set = ["123","123","123"]



// add item 
set1.insert(1)
set1.insert(2)

// check  set count is equals to  0
print(set1.isEmpty)

// remove item 
set1.remove(1)

print(set1)

//check set contains item 

print(set1.contains(2))
print(set1.contains(122))

//iterator set
//just like array 

set1.insert(1)
for setItem in set1.sorted() {
    print(setItem)
}




//Dictionary
//swift 的Dictionary 是无序的
// create dictionary

var d1 = [Int : String]()
var d2 = [1: 1 , 2 : 2]
var d3 : [String : String] = ["1" : "1" ,"2":"2"]

d1 [0] = "china"


d1 = [:]    // 在这里d1 又成了一个空字典
// 实际中用playground 中查看刚创建的空字典d1 ，也是[:]的类型





















































































