//: Playground - noun: a place where people can play

import UIKit



let someString  =  "some strings"

let quotation = """
111
123
111
"""



let singleLineString = "These are the same."
let multilineString = """
These are the same.
"""

print(singleLineString ==  multilineString)


let softWrappedQuotation = """
The White Rabbit put on his spectacles.  "Where shall I begin, \
please your Majesty?" he asked.

"Begin at the beginning," the King said gravely, "and go on \
till you come to the end; then stop."
"""


print(softWrappedQuotation)


// init empty string

var emptyString = ""
var anthorEmptyString = String()

print("emptyString is empty ? \(emptyString.isEmpty)!")

anthorEmptyString.isEmpty



// String mutability
var varoableString = "Horse"
varoableString  += " and carriage"

print(varoableString)


// string are value type




//working with Characters

print("-----working with characters-------")
for char in varoableString{
    print(char)
}

print("concatenating string and characters")
let string1 : String = "hello"
let string2 : String = " world"

let welcome  = string1 + string2

print(welcome)


// String interpolation
let count : Int = 3
print("the count = \(count)")
print("the count * 2 = \(count * 2 )")



// counting characters

let countStr  = "this is count string"
print(countStr.count)
print("the countStr count = \(countStr.count)")



// string indices

let greeting = "Guten Tag!"
greeting[greeting.startIndex]



// insert  and removing
var welcome1  = "welcome"
welcome1.insert("!", at: welcome1.endIndex)
welcome1.remove(at: welcome1.index(before: welcome1.endIndex))


































