/**
#function
* 160821 更新函数的基本用法
 
 */
import UIKit

// # 函数（Functions）
//


//函数的定义与调用
//当你定义一个函数时，你可以定义一个或多个有名字和类型的值，作为函数的输入，称为参数，也可以定义某种类型的值作为函数执行结束时的输出，称为返回类型。
func sayHello(personName : String) ->String{
    return "hello"+personName
}

sayHello(personName: "12")

//#函数参数和返回值
// 可以无参 也可以多参， 可以有返回值，也可以没返回值


//# 无参函数
func sayHelloWorld() ->String {
    return "HelloWorld"
}
sayHelloWorld()


// #多参数函数

func greet(person : String , alreadyGreeted : Bool) -> String{
    if alreadyGreeted {
            return person
    }else {
            return person+"==="
    }
}

print(greet(person: "shenjun", alreadyGreeted: true))


// #无返回值

func  greet(person : String){
    print("greet function")
}

greet(person: "cocoa")

//严格上来说，虽然没有返回值被定义，greet(person:) 函数依然返回了值。没有定义返回类型的函数会返回一个特殊的Void值。它其实是一个空的元组（tuple），没有任何元素，可以写成()。


// 多重返回值函数
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































