//: Playground - noun: a place where people can play

// Control_flow

func test(test : String?) {
    guard let t = test else {
        print("test is null and method returned")
        return
    }
    print(t)
}

var s : String? = nil

test(test: s)


for i in 1..<10 {
    print(i)
}


var temp = 0

repeat{
    temp += 1
    print(temp)
}while temp < 2



func inoutMethod(a : inout Int) {
    a = 10
    print(a)
}
var intA : Int  = 1
inoutMethod(a: &intA)

print(intA)

func add(_ a : Int , _ b : Int) -> Int
{
    return a  +  b
    
}

let addMethod = add
print(type(of: addMethod))

func test(_ add : (Int,Int) -> Int, _ a : Int ,_ b : Int ) -> Int{
    return add(a,b)
}
test(add,10,20)




func test1 () -> (Int,Int) -> Int{
    return add
}
test1()(10, 22)




















