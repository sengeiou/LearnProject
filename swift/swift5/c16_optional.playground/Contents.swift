import UIKit

class Person {
    var residence : Residence?
}
class Residence{
    var numberOfRooms = 1
    
    func println(){
        print("just print")
    }
}

let p1 = Person()
// 下面的代码会报错
//p1.residence!.numberOfRooms

if let count  = p1.residence?.numberOfRooms {
    print("\(count)")
}else{
    print("get count failed")
}

//p1.residence = Residence()
if let re = p1.residence{
    re.println()
}else{
    print("error")
}

// 可选链调用没有返回值的普通方法
if p1.residence?.println() != nil {
    
}else{
    
}

// 可选连访问不可选的值，返回的是可选值，可选链访问可选的值，返回的是可选值


// 可选链上调用方法，且这个方法返回可选值，则可以继续使用可选链调用







//from optionals.org

//the optional
let opt1  : String? = nil
let opt2 : String? = "cocoa"


//多个变量
if let o1 = opt1 , let o2 = opt2 {
    print("\(o1)\(o2)")
}else{
    print("somthing error")
}

// boolean clause

if let value = opt2 , value.hasPrefix("c") {
    print("the result value is \(value)")
}else{
    print("else")
}

func check(params : String?){
    guard let re = params  else{
        return
    }
    print(re)
}
check(params: nil)
check(params: "cocoa")


//给 optional 设置默认值
var name = opt1 ?? "cocoa"

switch opt2 {
case .some(let value):
    print("\(value)")
case .none:
    print("none")
}


let str = opt1



























