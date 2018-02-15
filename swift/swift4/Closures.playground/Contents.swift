// Closures can capture and store references to any constants and variables from the context in which they are defined.


//1. global functions are closures that have a name and do not capture any values
//2. nested functions are closures that have a name and can capture values from their enclosing function.
//3. closure expressions are unnamed closure written in lightweight syntax that can capture values from their surrounding context

// closure expression have a clean, clear style
// 1. infering parameter and return value type from context
// 2. implicit returns from single-expression closure
// 3. shorthand argument names
// 4. trailing closure syntax

// sorted method

let name = ["Chris","Alex","Ewa","Barry","Daniella"]

func backward(_ s1 : String , _ s2 : String) -> Bool {
    return s1 > s2
}

var sortedName  = name.sorted(by: backward)





// closure expression syntax
    /**
{(parameters) -> return type in
        //code
}
*/

sortedName = name.sorted(by: {
    (s1 : String, s2 : String) -> Bool in
    return s1 > s2
 })
sortedName

// inferring type from context
sortedName = name.sorted(by: {
        s1 , s2 in return s1 > s2
})


// implicit retuern

sortedName = name.sorted(by: {
    s1 , s2 in s1 > s2
})


// shorthand argument names
sortedName = name.sorted(by: {
    $0 > $1
})

// operator method
sortedName = name.sorted(by: >)


//trailing closures
sortedName = name.sorted(){
    $0 > $1
}

let names =  ["cocoa","tt","okok"]

let result  = names.map({
    (_ s1 : String) -> String in
    print(s1)
    var s  = s1
    return s
})


// capturing values


// example

func makeIncrementer(forIncrement amount: Int) -> () -> Int {
    var runningTotal = 0
    func incrementer() -> Int {
        runningTotal +=  amount
        return runningTotal
    }
    return incrementer
}

var incrementer = makeIncrementer(forIncrement: 10)
incrementer() // 10
incrementer() // 20


// closures are reference type


// escaping closures

// A closure is said to escape a function when the closure is passed as an argument to the function, but it called  after the function returns. (当一个闭包作为参数传递到一个函数中，并且这个闭包在该函数执行后才被调用，则该闭包从函数中逃逸)

// example

var handlers : [() -> Void] = []
func addHandlers (_ hanlder : @escaping () -> Void){  // try to remove @escaping
    handlers.append(hanlder)
}



