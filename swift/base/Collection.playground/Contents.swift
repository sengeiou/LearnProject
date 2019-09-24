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


// ****** swift 高级 Array 用法
// 在 swift 中，不建议用下标去访问, 比如

//array3[100]  调用这个语句会直接报错，因为 array3 根本没有100个元素
// 除非调用者手动去检查数组,
array3[array3.endIndex - 1]
// 用 type 去查看 返回的类型

type( of : array3[array3.endIndex - 1]) // 发现是Strting 类型，并不是optionals

//此外，在别的操作中也可以看出   

type ( of : array3.remove(at: 0) )  // 也是String 类型

type ( of : array3.popLast() )     // Optional

// 那么，其实也就是swift 不建议你去使用这些， 而是有用一些更加高级的操作去   advance

//比如，现在有一个数组 advancedArray ，我们要输出数组上的每个值的平方
//那么我们可以这么做
 let advancedArray =  [0, 1, 2, 3, 4, 5]
var result : [Int] = []
//
for value in advancedArray{
    result.append(value * value)
}

print (result)
// 如果，我们将 result 定义为 let ，那么这样的操作根本不可能实现
// 因为 swift 中 array 的可变和不可变，是由 let 和 var 取决的
// 更高级的操作是

let advancedResult  = advancedArray.map { $0 * $0 }

print(advancedResult)  // 结果是一样的
type ( of : advancedResult )

let two  = advancedArray.map ({ $0 * 2})
print(two)

// 通过扩展 自己来实现下 map 方法
// 通过这个扩展的方法，也可以知道闭包和泛型的强大
extension Array {
    func myMap <T> (_ tran : (Element) -> T ) ->[T] {
        var temp : [T] = []
        
        for value in self {
            temp.append(tran(value))
        }
        return temp
    }
}

let myMapArray = advancedArray.myMap({ $0 * $0 })
print(myMapArray)

// swift 还给我们定义很多这样的函数
// 如果 数组中元素都遵循了 Equaltable 协议 , 那么你还可以这么操作

advancedArray.min()
advancedArray.max()

type( of : advancedArray.max() )  // 而且返回的是很安全的 optional 类型

// 过滤器方法
// 我们尝试来过滤掉数组中奇数,
let even  = advancedArray.filter({ $0 % 2 == 0 })
print(even)  // [0,2,4]  超级方便

// 还有很多这样的方法   elementsEqual()  starts() forEach()  sorted  

let sortedArray = advancedArray.sorted( by : { $0 > $1 })
print(sortedArray)  // [5,4,3,2,1,0]

for value in advancedArray where value % 2 == 0{ // for 循环的条件判断，很实用
    print("for in where ------\(value)")
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





















































































