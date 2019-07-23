
//实例方法
class Counter {
    var count = 0
    
    func increment(){
        count  += 1
    }
    
    func imcrement(by amount : Int){
        count += amount
    }
    
    func rest(){
        count = 0
    }
}

var counter  = Counter()
counter.imcrement(by: 10)
print(counter.count)

// 上面是实例方法在类中的使用

// 但是在结构体和枚举中，属性是不能在实例方法中被修改的
// 如果一定要修改，则需要加上mutating
struct Pointer{
    var x = 0.0
    var y = 0.0
    mutating func moveBy(_ x: Double , _ y : Double){ // 可以尝试去掉 mutating
        self.x += x
        self.y += y
    }
}
// 然而还要注意的一点是，不能把 pointer 的实例定义为常量，不然，也不能调用 moveBy 方法，因为常量结构体的属性也是常量，无法修改


//下面看类型方法
//在方法的 func 关键字之前加上关键字 static，来指定类型方法。类还可以用关键字 class 来允许子类重写父类的方法实现。

class SomeClass{
    var name = "ccc"
    class func someTypeMethod(){
//        self.name = "changed"   // 类型方法中不能使用 self 
        print("this is class method")
    }
    
}

SomeClass.someTypeMethod()







