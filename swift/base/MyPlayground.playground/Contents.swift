//: Playground - noun: a place where people can play

import UIKit



struct Person : Codable {
    var name : String
    var age : Int
}

var person = Person(name: "cocoa", age : 30)

var jsonEncoder = JSONEncoder()

let jsonData = try jsonEncoder.encode(person)

var result = String(data: jsonData, encoding : .utf8)

print(type(of: result))

if let t = result {
    print(t)
}
