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

sixDouble += threeDouble

print(sixDouble)

sixDouble[1] =  12

sixDouble.endIndex

// create array with literal
var shoppingList = ["milk", "eggs"]
print(shoppingList)

print(shoppingList.count)
print("shoppinglist is empty \(shoppingList.isEmpty)")

var firstItem = shoppingList[0]

var lastItem =  shoppingList.last

var emptyArray = [String]()

emptyArray.append("sss")
emptyArray.append("hhhh")
emptyArray.append("hhhh")

type(of: emptyArray.index(of: "hhh"))

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

for it in shoppingList.makeIterator() {
    print("hahahahah\(it)")
}



class Person : Hashable, Equatable{
    var hashValue: Int {
        return 1
    }
    static func ==(lhs: Person, rhs: Person) -> Bool{
        return true
    }
}

// set
var strSet = Set<String>()

strSet.insert("a")
strSet.insert("a")

print(strSet)


var favoriteGenres : Set<String> = ["eggs","eggs","milk","phone","apple"]

print(favoriteGenres)

print(type(of: favoriteGenres.remove("eggs")))


// value binding
// optional
if let removeResult = favoriteGenres.remove("milk123"){
    print("the \(removeResult) has been removed")
}else{
    print("remove failed")
}


// check whether a set contains a particular item
if favoriteGenres.contains("Funk") {
    print("get some foot ")
}else{
    print("no funk here")
}


// iterating set
// use for-in loop

for item in favoriteGenres{
    print(item)
}

// swift set does not have a defined ordering.

// order iteraring set

for item in favoriteGenres.sorted(){
    print(item)
}




// Dictionaries
// 1. same type key and same type value
// 2. with no defined ordering
// 3. each value is associated with a unique key
// 4. syntax   Dictionary<Key,Value>

// 5. ***** A dictionary key  must conform to the Hashable protocol


// create empty dictionary
var nameOfIntegers = [Int : String]()

nameOfIntegers[10] = "ten"

print(nameOfIntegers[10])  // return optional


// create dictionary with literal

var numbers: [Int: String] = [1 : "one" , 2 : "two" , 3 : "three"]



// access and modify dictionary

numbers.count
numbers.isEmpty

//modify
numbers[1] = "ONE"

// use updateValue to modify value and get old value , the oldvalue type is optional
if let oldValue  = numbers.updateValue("TWO", forKey: 2){
    print("update the 2 value \(oldValue)")
}


// remove

numbers.remove(at: numbers.index(forKey: 1)!)
numbers

numbers.removeValue(forKey: 2)
numbers

// iteraror dict

for (key , value ) in numbers {
    print("\(key)------\(value)")
}

for key in numbers.keys{
    print("key is \(key)")
}

// also can use Dictionary.vlaues ,to get the set of all values

























