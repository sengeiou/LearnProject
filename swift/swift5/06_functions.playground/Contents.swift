import UIKit

var name : String = "cocoa"
print(name)



// 多个参数的函数
func greet(person:String , alreadyGreeted : Bool) -> String {
    if alreadyGreeted {
        return person
    }else{
        return "no \(person)"
    }
}

print(greet(person: "cocoa", alreadyGreeted: true))



func maxMin(array: [Int]) ->(min :Int ,max : Int){
    var min = array[0]
    var max = array[0]
    for item in array{
        if(item < min ){
            min = item
        }
        if(item > max){
            max = item
        }
    }
    return (min ,max)
}

var array  = [1,2,3,4,5,6]

let result = maxMin(array: array)
print("the min is \(result.min) and the max is \(result.max)")

func maxMin2(array: [Int]) ->(min :Int ,max : Int)?{
    if array.isEmpty {
        return nil
    }

    var min = array[0]
    var max = array[0]
    for item in array{
        if(item < min ){
            min = item
        }
        if(item > max){
            max = item
        }
    }
    return (min ,max)
}

array.removeAll()
if let array2Result = maxMin2(array: array){
    print(array2Result.max)
}else{
    print("array is empty")
}


// 指定参数标签
// argumentLabel 在外部调用时
// parameterLabel 在函数内部使用
func someFunction(argumentLabel parameterLabel : Int){
    print(parameterLabel)
}
someFunction(argumentLabel: 1)



// 默认值

func someFunction1(argLabel paramLabel: Int = 12){
    print(paramLabel)
}
someFunction1()// 打印12


// 可变参数
// 一个函数最多只有一个可变参数，可以放前面
func arithmeticMean(_ numbers: Double... , otherLabel : Double){
    for item in numbers{
        print(item)
    }
    print("the other label param is \(otherLabel)")
}
arithmeticMean(1.0,2.0,3.0, otherLabel: 11.11)


func add(_ a: Int ,_ b : Int) -> Int{
    return a + b
}

func printMathResult(_ mathFunction: (Int,Int) -> Int, a: Int , b : Int  ){
    print(mathFunction(a,b))
}

printMathResult(add, a: 12, b: 12)







































