//: Playground - noun: a place where people can play

import UIKit

let array = Array(repeating: 0.0, count: 12)

print(array.count)



let s = "Hello"
let s1 = "Hello"
print(s1.hashValue)
print(s.hashValue)

struct Person : Hashable, Equatable{
    var name : String
    var age : Int
    
    var hashValue: Int{
        return Int(arc4random())
    }
    
    static func ==(lhs: Person, rhs: Person) -> Bool {
        return false
    }
    
    
}

var cocoa  = Person(name: "cocoa", age: 12)
var zhangsan  = Person(name: "zhangsan ", age : 31)

var ps = Set<Person>()
ps.insert(cocoa)
ps.insert(zhangsan)
ps.insert(cocoa)

print( ps.count )

for item in ps {
    print(item.age)
}

for (index , value) in ps.enumerated(){
    print(index,value)
}

var array1 = [1,2,3]
var set = Set(array1)
for item in set {
    print(item)
}
















