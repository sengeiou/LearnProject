/**
#function
* 160821 更新函数的基本用法
 
 
 */
import UIKit

var str = "Hello, playground"



func sayHello(personName : String) ->String{
    return "hello"+personName
}

sayHello(personName: "12")

func minMax(array:[Int])-> (min:Int, max:Int){
   var cMin = array[0]
    var cMax = array[0]
    for v in array[1..<array.count]{
        if v < cMin{
            cMin = v
        } else if v > cMax{
            cMax = v
        }
    
    }
    return  (cMin,cMax)
}

var minMaxArray = minMax(array: [1,2,4,5,69,199])

print(minMaxArray.max)

//自定义参数别名
// 这里的person 和 to 就是别名
func sayHi(person p : String , to p1 : String) -> String{

    return p + "say hi to " + p1
}
sayHi(person: "SHENJUN", to: "COCOA")

//  系统默认
func sayBye(p1 :String , p2 : String){
    print(p1 + p2)
}
//  默认的情况下，调用时是都要进行参数的申明的
sayBye(p1: "123", p2: "123")




// default params value 
func getAge(age : Int = 12){
    print(age)
}

getAge()
getAge(age: 11)    // 不要忘记写参数名



//可变参数, 一个函数只能有一个可变参数
func test1(num : Int ...){
    print("\n  num count \(num.count) \n")
    
    for n in num{
        print(n)
    }
}

test1(num: 1,2,3,4)



// function types (函数类型)
func add(a : Int , b : Int) -> Int{
    return a + b
}
func multiply (a : Int , b : Int) -> Int{
    return a - b
}
// 定义一个addType的变量， 它的类型是接受两个int参数，并且返回Int 值的函数类型
var addType : (Int,Int) -> Int =  add
print(addType(1,2))

func testFunctiontype( tt : ( Int, Int) -> Int , a : Int , b : Int) -> Int {
    return tt(a ,b)
}
// 有点强大，用起来比较奇怪
testFunctiontype(tt: addType, a: 1, b: 12)
// 这个用法有点类似java 的匿名函数，使用时要记得设置匿名函数的参数
testFunctiontype(tt: { (x, y) -> Int in
    x + y
    }, a: 12, b: 12)































