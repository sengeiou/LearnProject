import UIKit

let names = ["lily","coco","tom"]


for item in names{
    print(item)
}
let map : [String:Int] = ["one":1]

for (item ,index) in map{
    print("\(item) and index = \(index)")
}

for index in 1...4{
    print(index)   // print 1234
}

var index : Int = 1
while index < 5{
    print(index)  // print 1234
    index = 1+index
}

var score =  19

switch score {
case 1..<10:
    print("the score is 1-9")
case 10..<20:
    print("the score is 10-19")
default:
    print("default")
}

//

func greet(person :[String: String]) -> String{
    guard let name = person["no"] else{
        return ""
    }
    return name
}

let nameDict = ["cocoa":"im cocoa!"]

greet(person: nameDict)    // 输出 ""
