//: Playground - noun: a place where people can play

import UIKit

// 字典类型

// Swift 字典使用Dictionary<Key,Value>定义
// 字典的key必须遵循 hashable 协议， 就像 Set 的值类型



// 创建一个空的字典

var namesOfIntegers = [Int:String]()

namesOfIntegers[6] = "six"

namesOfIntegers

namesOfIntegers[0] = "zero"

namesOfIntegers

namesOfIntegers = [:]  //字面量来创建一个空字典

namesOfIntegers



// 使用字面量创建字典
var  airports : [String : String]  = ["11":"111","22":"222"]

// 可以不用显示申明
var test = [1:1,2:2]



// 访问和修改字典
airports.count
airports.isEmpty

// 修改
airports["11"] = "1212"
airports

airports.updateValue("1313", forKey: "22")
airports

//updateValue返回对应值的类型的可选值

if let result = airports.updateValue("111", forKey: "11"){
    print(result)
} else {
    print("no update")
}

//通过给某个键的对应值赋值为nil来从字典里移除一个键值对：

airports["11"] = nil

airports

// 也可以使用removeValue 删除一个键值对
//removeValue 也是返回对应值的类型的可选值
airports.removeValue(forKey: "22")
airports


airports["11"] = "111"
airports["22"] = "222"

// for in 方法
for (code , name) in airports{
    print("key is \(code) and value is \(name)")
}

//airports.keys 方法
for code in airports.keys{
    print("key is \(code) and value is \(airports[code])")
}

// 总结
// 通过下标访问字典获取到的是Optional 注意
// 字典是无序的，如果需要做有序，那么要对字典的key 或 value 使用sorted 方法










































