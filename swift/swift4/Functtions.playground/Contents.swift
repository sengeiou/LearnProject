//: Playground - noun: a place where people can play

import UIKit

func greet(person: String) -> String {
    let greeting = "hello ," + person
    return greeting
}

func greet(person: String , alreadyGreeted: Bool) -> String{
    if alreadyGreeted {
        return "123"
    } else {
        return "223"
    }
}


func printAndCount(string: String) -> Int{
    print(string)
    return string.count
}


func minMax (array : [Int]) -> (min : Int ,max : Int){
    var min =  array[0]
    var max = array[0]
    for item in array{
        if item < min {
            min = item
        }else if item > max {
            max = item
        }
    }
    return (min,max)
}


var array :[Int] = [1,2,3,4,5,6,6,100,-10]

let (min , max) = minMax(array: array)
print(min , max)





