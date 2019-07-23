
// 看一个排序方法


let names = ["Chris", "Alex", "Ewa" ,"Barry", "Deaniella"]

func backward (_ s1 : String , _ s2 : String) -> Bool{
        return s1 < s2
}

names.sorted(by: backward)


// 当然可以用闭包来写
// 闭包的函数体部分由 in 引出 ，分割函数的参数返回值 和 函数体部分
names.sorted(by :{ (s1 : String, s2 :String) -> Bool in
        return s1 < s2
})


// 闭包可以推荐上下文类型, 所以呢，可以省略类型

names.sorted(by: { (s1, s2)  in
        return s1 > s2
})

// 单表达式闭包可以省略return
var result = names.sorted(by:{ s1, s2  in s1 > s2})

// 参数名字可以胜率成  $0 $1.....
result = names.sorted(by :{ $0 > $1})

// 又因为 > < 刚好有接受两个string 返回 bool 的方法，所以可以简写成
result = names.sorted(by: >)

// 然后又可以简写成尾随闭包
result  = names.sorted(){
    $0 > $1
}

// 如果闭包是唯一的参数，还可以省略 ()
result  = names.sorted{
    $0 > $1
}

//有了闭包，就可以很多简化的操作，比如用 map 方法把名字变成小写
result = names.map{
    $0.lowercased()
}
print(result)

// 过滤名字的长度大于4 的名字
result = names.filter{
    $0.count > 4
}
print(result)

// 官方 API 内置了很多这样的操作，用来进行函数式编程


// 下面来看值捕获
//闭包可以在其被定义的上下文中捕获常量或变量。即使定义这些常量和变量的原作用域已经不存在，闭包仍然可以在闭包函数体内引用和修改这些值。

func  makeIncrementer(foIncrement amount : Int) -> () -> Int {
    
    var total  = 0;
    
    func increment() -> Int {
        total += amount
        return total
    }
    return increment
}

var total = makeIncrementer(foIncrement: 10)
 total()
 total()
 total()


// 闭包在没有调用前是不会被执行的


var cusyomerInline = ["11","22","33"]
print(cusyomerInline)

var removeFunc = { cusyomerInline.remove(at: 0)}
print(cusyomerInline)

removeFunc()
print(cusyomerInline)


//

//func serve(c : @autoclosure () -> String){
//    print(c())
//}
//serve(c: cusyomerInline.remove(at: 0))  //不知道这里为什么报错


























