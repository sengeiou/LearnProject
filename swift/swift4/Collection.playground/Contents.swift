// colltection  =  array set Dictionary
// var collection = ......   this collection is mutable
//*** let collection = ......   this collection is immutable


// why?   cuz :  collection =  struct

// Arrays
//  var arrayName : [TYPE] = [TYPE]()

var intArray : [Int] = [Int]()

print(intArray.count)

intArray.append(1)
intArray.append(1)
intArray.insert(0, at: 0)

print(intArray)

var threeDouble =  Array(repeating: 1.0, count: 3)

print(threeDouble)


var sixDouble = threeDouble + threeDouble

print(sixDouble)


// create array with literal
var shoppingList = ["milk", "eggs"]
print(shoppingList)

print(shoppingList.count)
print("shoppinglist is empty \(shoppingList.isEmpty)")

var firstItem = shoppingList[0]

var lastItem =  shoppingList.last


var emptyArray = [String]()

emptyArray.append("sss")

if let first = emptyArray.first {
    print(first)
}

// iterating over an array
for item in shoppingList{
    print(item)
}

for (index, value) in shoppingList.enumerated(){
    print("the index is \(index + 1) and value is \(value)")
}

for item in 0..<shoppingList.count{
    print(shoppingList[item])
}



// set
class Person : Hashable, Equatable{
    var hashValue: Int {
        return 1
    }
    static func ==(lhs: Person, rhs: Person) -> Bool{
        return true
    }
}

var strSet = Set<String>()

strSet.insert("a")
strSet.insert("a")

print(strSet)


var favoriteGenres : Set<String> = ["eggs","eggs","milk","phone"]

print(favoriteGenres)

print(type(of: favoriteGenres.remove("eggs")))


// value binding
// optional
if let removeResult = favoriteGenres.remove("milk123"){
    print("the \(removeResult) has been removed")
}else{
    print("remove filed")
}































