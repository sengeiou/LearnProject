import Foundation
//存储属性存储常量或变量作为实例的一部分，而计算属性计算（不是存储）一个值。
//计算属性可以用于类、结构体和枚举，存储属性只能用于类和结构体。



// 存储属性可以是变量存储属性（var 定义），常量存储属性（let 定义）
// 可以在定义存储属性的时候指定默认值，请参考默认构造器一节。也可以在构造过程中设置或修改存储属性的值，甚至修改常量存储属性的值

// 简单的说，常量存储属性只能指定默认值或者在构造器中赋值，变量存储属性则可以指定默认值或者在构造器中赋值或外部赋值

struct FixedLengthRnage{
    var firstValue : Int
    let length  : Int
}

var rangOfThreeItems = FixedLengthRnage(firstValue: 0, length: 3)
rangOfThreeItems.firstValue = 6
//rangOfThreeItems.length = 12    // 不能修改，因为 length 是let


// 常量结构存储体
let rangeOfFourItems = FixedLengthRnage(firstValue: 0, length: 4)
//rangeOfFourItems.firstValue = 1     // 这里会报错

//因为 rangeOfFourItems 被申明为了 letm，即使firstValue 是变量，也无法修改
// 主要原因是因为 结构体是值类型，值类型被定义成常量的时候的，所有的属性也就成了值类型
// 而引用类型则没有这个限制



// 延迟存储属性
// 延迟存储属性是指当第一次被调用的时候才会计算其初始值的属性。在属性声明前使用 lazy 来标示一个延迟存储属性。
// 延迟属性必须用 var 定义

class DataImporter{
    var fileName = "data.txt"
}
class DataManager{
    lazy var importer = DataImporter()
    var data : [String] = []
}

let manager = DataManager()
manager.data.append("123")
manager.data.append("223")
// 直到这里，DataManager 中的 importer 并没有初始化

print(manager.importer.fileName)
// 到这里，才会被真正的创建


// 计算属性
//类，结构体，枚举，可以定义计算属性
struct Circle{
    var r = 0.0
    var area : Double {
        get{
            return 3.1415 * r * r
        }
        set{   // 当没有定义参数的时候，可以用newValue 来取值，你也可以自定义参数 ，比如  set(myValue) {   // use myValue }
            self.r = newValue
        }
    }
    
}

var c1 = Circle()
c1.area = 10.0
print(c1.area)
// 上面这个例子定义了计算属性 area ，但是 set 方法有点不合理，可以忽略，只看计算属性的定义和使用



//只读计算属性
//只有 getter 没有 setter 的计算属性就是只读计算属性。只读计算属性总是返回一个值，可以通过点运算符访问，但不能设置新的值。
// 这里不写例子了




// 属性观察器
class StepCounter{
    var total : Int {
        willSet(newStep){
            print("will set \(newStep)")
        }
        didSet{
            print("did set and the oleValue\(oldValue)")
        }
    }
    init(total : Int) {
        self.total = total
    }
}


var step = StepCounter(total:12)
step.total = 111
step.total = 111 // 即使新值和旧值一样，也回触发 willSet didSet

// 全局变量 和局部变量
//全局的常量或变量都是延迟计算的，跟延迟存储属性相似，不同的地方在于，全局的常量或变量不需要标记 lazy 修饰符。
//局部范围的常量或变量从不延迟计算。



//类型属性和实例属性
//无论创建了多少个该类型的实例，这些属性都只有唯一一份。这种属性就是类型属性。
//类型属性必须制定默认值，因为类型属性没有构造器
//类型属性是只读的

class SomeClass1 {
    static var typeNmae = "item"
    static var orderName : String{
        return "saleOrder"
    }
}

print(SomeClass1.orderName)
//SomeClass1.orderName = "changed 123"    //cannot assign to property: 'orderName' is a get-only property






