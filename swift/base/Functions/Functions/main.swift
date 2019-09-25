//
//  main.swift
//  Functions
//
//  Created by shenjun on 16/2/24.
//  Copyright © 2016年 shenjun. All rights reserved.
//

import Foundation

//定义函数

//申明了sayHello的方法，接收一个string类型的参数name，返回string类型
func sayHello(name : String) -> String {
    return name
}
print(sayHello("shenjun"))



//申明了一个无参函数,没有参数，也没有返回值
//这里还说明一个问题，swift是只支持方法重载的，即可以存在同样的方法名但是参数不同，返回类型不同的方法
func sayHello(){
    print("no return value")
}


//申明了一个函数,接收一个数组
//返回多个参数，这里用的是tuple（元组）
//这个函数的作用是在数组中找出最大值和最小值
func minMax(array : [Int]) -> (min:Int , max:Int){
    
    var cMin = array[0]
    var cMax = array[0]
    
    for a in array {
        if a < cMin {
            cMin = a
        } else if a > cMax {
            cMax = a
        }
    }
    return (cMin,cMax)
}

  var array : [Int] = [12,3,31,23,3,12,31,23,123,12,3,1287]
//调用minMax方法
  let result   = minMax(array)
//元组的使用
  print(result.max)
  print(result.min)


//形参别名  name s1 :String   name就是别名
func printAgeName(name s1 :String ,age s2 :Int)-> String{

    return s1 + "\(s2)"
}
//调用的时候有点特殊，但是很清楚，比java，c 要好很多

print(printAgeName(name: "shen", age: 28))



//但是2.0以后，swift 就放弃了别名的形式，因为在第2个参数后默认开启了别名
//比如这个例子
//2.0之前，可以使用这样的写法func printAN(#name :String,#age : Int) 就等于上面复杂的写法
func printAN( name :String,age : Int) {
    print(name + "\(age)")
}
//这里的age 就有了别名
printAN("SHENJUN", age: 12)






