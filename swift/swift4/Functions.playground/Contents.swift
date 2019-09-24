

//defining  functions

func greet(person : String) -> String{
    let greeting = "Hello " + person
    return greeting
}

print(greet(person: "shenjun"))


// without parameters
func sayHello() -> String {
    return "Hello"
}

print(sayHello())

// with multiple parameters
func greet(person : String , alreadyGreeted : Bool) -> String {

    if alreadyGreeted {
        return "1232"
    }else{
        return "123"
    }
}


// without  return value

func greet () {
    print("hello")
}


// the return type can be ignored

//with multiple return value

func multipleReturn() -> (a : Int , b : Int) {  // tuple
    return (1,2)
}
multipleReturn()
multipleReturn().a


// return optional tuple type

func optionalReturn(a : Int) -> (a : Int , b : Int)? {
    // optional tuple
    if a > 0 {
        return nil
    }
    return (1,2)
}

optionalReturn(a: 10)
optionalReturn(a: -1)

if let bounds = optionalReturn(a: -10){
    print(bounds.a)
}


// function argument labels and parameter names

// argument labels is used  when calling the functions
// parameter names is used in the implementation of the function

//  here is an example
func someFunction(argumentLabel parameterName : Int) {
     print(parameterName)
}

func someFunction(parameterName1 : Int , parameterName2 : Int) {
    print("\(parameterName1)--\(parameterName2)")
}


someFunction(argumentLabel: 1)
someFunction(parameterName1: 10, parameterName2: 10)


// omitting argument label
func someFunc1 (_ parameterName : Int){
    print(parameterName)
}
someFunc1(10)



// defaule parameter value

func someFunc2 (parameterWithDefault : Int = 20 ,_ other : Int){
    print(parameterWithDefault)
}
someFunc2(10)
someFunc2(parameterWithDefault: 30 , 10)


// in-out parameters
// 1. function parameters are constants by default, trying to change the value of a function parameter from within the body of thar function results in a complie-time error;

// like this
func test1(a : Int) {
    //   a = 10  // cannot assign to value: 'a' is a 'let' constant
}

// if you want modify parameter value at function body ,use in-out
// like this
func test2 (a : inout Int){  // use inout keywords
    a = 10
    print(a)
}

// call func
var a = 10
test2(a: &a)  // use&


// function type

// this example defines two funcitons, and both type is (Int,Int) -> Int , this can be read as  " A function that has two parameters, both type of Int ,and that return a value of type Int."

func add (a : Int , b : Int) -> Int
{
    return a + b
}

func multiply ( a : Int ,b : Int) -> Int
{
    return a * b
}

// here is another example
// and the type is  () -> Void

func printHello () {
    print("Hello")
}


// using function type
// you can function type like any other types in Swift.

// example
var mathFunction : (Int , Int) -> Int  = add

mathFunction(10,10)


// function types as parameter types


func printMath(_ mathFunc : (Int,Int) -> Int, _ p1 : Int, _ p2 : Int) {
    print(add(a: p1, b: p2))
}

printMath(add, 10, 10000)



// function type as retuen type

func t(addBool : Bool ) -> (Int,Int) -> Int {
    if addBool {
        return add
    }else{
        return multiply
    }
}

var t1  = t(addBool: true)
t1(10, 10)

t1 = t(addBool: false)
t1(10,10)













