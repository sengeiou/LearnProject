import UIKit

class Counter{
    var count =  0
    func increment(){
        count += 1
    }
    
    func increment(by amount : Int){
        count += amount
    }
    
    func reset(){
        count = 0
    }
}

let counter = Counter()
counter.increment()
counter.increment(by : 10)
counter.reset()

struct Poin{
    var x = 0.0
    var y = 0.0
    
    // 在实例方法中修改值类型 ，加上mutating
    mutating func move(x deltaX : Double , y deltaY : Double){
        x += deltaX
        y += deltaY
    }
    
    // 上面的方法还可以写成这样的形式
    mutating func moveBy(x deltaX : Double , y deltaY : Double){
        self = Poin(x: x + deltaX, y: y + deltaY)
    }
    

}

// 类型方法
// 可以用 static 和 class 来修改
// 类型方法中的 self 指的是类型本身。而不是某一个实例
class SomeClass{
    static func func1(){
        print("\(self)")
    }
    class  func func2(){
        print("\(self)")
    }
}





