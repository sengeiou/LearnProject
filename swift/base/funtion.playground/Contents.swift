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


// # 可选元组返回
//如果函数返回的元组类型有可能整个元组都“没有值”，你可以使用可选的（ optional ） 元组返回类型反映整个元组可以是nil的事实。你可以通过在元组类型的右括号后放置一个问号来定义一个可选元组，例如 (Int, Int)? 或 (String, Int, Bool)?




func minMax2(array : [Int]) -> (min : Int , max : Int)?{
    if( array.isEmpty ){
        return nil
    }
    let sortedArray : [Int] = array.sorted(by : < )
    
    var min  = 0
    var max  = 0
    
    if let hah = sortedArray.first {
        min = hah
    }
    if sortedArray.last != nil{
        max = sortedArray.last!
    }
    return (min , max)
}

if  let minMax = minMax2(array: [156,200,4,5,69,199,0]){
    print("get minmax from optional")
    print(minMax.min)
    print(minMax.max)
}





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



//可变参数, 一个函数只能有一个可变参数, 可变参数放在最后面
func test1(num : Int ...){
    print("\n  num count \(num.count) \n")
    
    for n in num{
        print(n)
    }
}

test1(num: 1,2,3,4)


// #输入输出参数
// 函数参数默认是常量。试图在函数体中更改参数值将会导致编译错误(compile-time error)。这意味着你不能错误地更改参数值。如果你想要一个函数可以修改参数的值，并且想要在这些修改在函数调用结束后仍然存在，那么就应该把这个参数定义为输入输出参数（In-Out Parameters）。

func test1(a : Int) -> Int{
   // a += 1 //会报错 cannot pass immutable value to mutating operator: 'a' is a 'let' constant
    return a
}
// 定义一个输入输出参数时，在参数定义前加 inout 关键字。一个输入输出参数有传入函数的值，这个值被函数修改，然后被传出函数，替换原来的值。

func test2( age : inout Int) -> Int{  // 加上  inout
    age += 1
    return age
}
var  age : Int = 10

//你只能传递变量给输入输出参数。你不能传入常量或者字面量，因为这些量是不能被修改的。当传入的参数作为输入输出参数时，需要在参数名前加 & 符，表示这个值可以被函数修改。
test2(age: &age)  // 传入age 时，要加上 & 符号， 输出11

// 一个经典的例子，交换两个变量的值
func swapTwoInts(_ a: inout Int, _ b: inout Int) {
    let temporaryA = a
    a = b
    b = temporaryA
}


// function types (函数类型)  结合闭包
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


// 官方例子
func stepForward(_ input: Int) -> Int {
    return input + 1
}
func stepBackward(_ input: Int) -> Int {
    return input - 1
}

func chooseStepFunction(backward: Bool) -> (Int) -> Int {
    return backward ? stepBackward : stepForward
}

// 直接调用
chooseStepFunction(backward: true)(10)
chooseStepFunction(backward: false)(11)

// 间接调用
let function = chooseStepFunction(backward: true)
function(10)


// 嵌套函数
// 到目前为止本章中你所见到的所有函数都叫全局函数（global functions），它们定义在全局域中。你也可以把函数定义在别的函数体中，称作 嵌套函数（nested functions）。

// 默认情况下，嵌套函数是对外界不可见的，但是可以被它们的外围函数（enclosing function）调用。一个外围函数也可以返回它的某一个嵌套函数，使得这个函数可以在其他域中被使用。

//  重新实现了chooseStepFunction 但是，个人不建议这么写， 没有复用性，代码乱, 跳过了

func chooseStepFunction1(backward: Bool) -> (Int) -> Int {
    func stepForward(input: Int) -> Int { return input + 1 }
    func stepBackward(input: Int) -> Int { return input - 1 }
    return backward ? stepBackward : stepForward
}
var currentValue = -4
let moveNearerToZero = chooseStepFunction1(backward: currentValue > 0)
// moveNearerToZero now refers to the nested stepForward() function
while currentValue != 0 {
    print("\(currentValue)... ")
    currentValue = moveNearerToZero(currentValue)
}

func calc(_ a: Int) -> (Int) -> Int{
    func iner(b: Int) -> Int{
        return a - b
    }
    return iner
}

var c = calc(10)
print(c(5))




