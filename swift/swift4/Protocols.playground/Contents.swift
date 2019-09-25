//??? line-121 class可以有可变方法吗




// 协议 定义了一个蓝图，规定了用来实现某一特定任务或者功能的方法、属性，以及其他需要的东西。类、结构体或枚举都可以遵循协议，并为协议定义的这些要求提供具体实现。某个类型能够满足某个协议的要求，就可以说该类型遵循这个协议。

// 也可以扩展协议

// 协议的定义
protocol SomeProtocol {
    // 定义协议的内容
}

protocol AnotherProtocol {
    // 定义协议的内容
}

class FatherClass {
    
}


//要让自定义类型遵循某个协议，在定义类型时，需要在类型名称后加上协议名称，中间以冒号（:）分隔。遵循多个协议时，各协议之间用逗号（,）分隔：

class SomeClass: FatherClass, SomeProtocol, AnotherProtocol{
    // 这里是结构体的定义部分
}


// 属性要求
//协议可以要求遵循协议的类型提供特定名称和类型的实例属性或类型属性。协议不指定属性是存储型属性还是计算型属性，它只指定属性的名称和类型。此外，协议还指定属性是可读的还是可读可写的。

//如果协议要求属性是可读可写的，那么该属性不能是常量属性或只读的计算型属性。如果协议只要求属性是可读的，那么该属性不仅可以是可读的，如果代码需要的话，还可以是可写的。

//协议总是用 var 关键字来声明变量属性，在类型声明后加上 { set get } 来表示属性是可读可写的，可读属性则用 { get } 来表示：

protocol SomeProtocol_1{
    var mustBeSettable : Int { set get}
    var onlyGettable: Int { get }
}

//在协议中定义类型属性时，总是使用 static 关键字作为前缀。 或者用class 代替 static

protocol AnotherProtocol_1 {
    static var someTypeProperty: Int { get set }
}

// 看一个例子, 这个例子中定义了 FullyNamed 的协议，表示任何遵循 FullyNamed 协议的必须要有一个可读实例属性 fullName
protocol FullyNamed {
    var fullName : String { get }
}

struct Person : FullyNamed{
    var fullName : String
}

let p1 = Person(fullName: "p1")

// 下面看一个复杂的例子
class Starship : FullyNamed {
    var prefix : String?
    var name : String
    
    init(name : String , prefix : String? = nil ){
        self.name  = name
        self.prefix = prefix
    }
    
    var fullName: String {
        return (prefix ?? " ") + name
    }
}

var ncc1701 = Starship(name : "Enter", prefix : "USS")



// 方法要求
//协议可以要求遵循协议的类型实现某些指定的实例方法或类方法。这些方法作为协议的一部分，像普通方法一样放在协议的定义中，但是不需要大括号和方法体。可以在协议中定义具有可变参数的方法，和普通方法的定义方式相同。但是，不支持为协议中的方法的参数提供默认值。
//
//正如属性要求中所述，在协议中定义类方法的时候，总是使用 static 关键字作为前缀。当类类型遵循协议时，除了 static 关键字，还可以使用 class 关键字作为前缀：

// 看例子
protocol RandomNumGenerator {
    func randomNum() -> Double
}

extension Int : RandomNumGenerator {
    func randomNum() -> Double  {
        return 3.13123
    }
}

3.randomNum()

//Mutating 方法要求
//  有时候会需要再方法中改变实例
//例如，在值类型（即结构体和枚举）的实例方法中，将 mutating 关键字作为方法的前缀，写在 func 关键字之前，表示可以在该方法中修改它所属的实例以及实例的任意属性的值。这一过程在在实例方法中修改值类型章节中有详细描述。

//如果你在协议中定义了一个实例方法，该方法会改变遵循该协议的类型的实例，那么在定义协议时需要在方法前加 mutating 关键字。这使得结构体和枚举能够遵循此协议并满足此方法要求。

// 下面看官方的例子
protocol Togglable {
  mutating func toggle()
}

enum OnOffSwitch : Togglable {
    case off , on
    mutating func toggle(){
        switch self {
        case .off:
            self = .on
        case .on :
            self = .off
        default:
            self = .off
        }
    }
}

var  lightSwitch = OnOffSwitch.off
lightSwitch.toggle()
print(lightSwitch)


// 下面是我通过扩展的方法给 Int 扩展了mutating func toggle
extension Int : Togglable {
    mutating func toggle(){
        // 这里的代码只是单存的改变self ，只是为了举例
        self = self * 0
    }
}

var a : Int  = 10
a.toggle()


// 构造器要求
//你可以在遵循协议的类中实现构造器，无论是作为指定构造器，还是作为便利构造器。无论哪种情况，你都必须为构造器实现标上 required 修饰符：

protocol SomeProtocol_2 {
    init(someParameter: Int)
}

class SomeClass_2 : SomeProtocol_2 {
    // 无论是指定构造器还是便利构造器，都需要指定required
    
    required init(someParameter : Int) {
        
    }
}

//使用 required 修饰符可以确保所有子类也必须提供此构造器实现，从而也能符合协议。
//如果类已经被标记为 final，那么不需要在协议构造器的实现中使用 required 修饰符，因为 final 类不能有子类。关于 final 修饰符的更多内容，请参见防止重写。

class ChildSomeClass_2 : SomeClass_2  {

    required init(someParameter: Int) {
        super.init(someParameter: someParameter)
    }
}


//如果一个子类重写了父类的指定构造器，并且该构造器满足了某个协议的要求，那么该构造器的实现需要同时标注 required 和 override 修饰符：
// 意思就是说 协议和父类的构造器一样，那么就要写上  required 和 override


func test( a : String ) -> String{
    let a : String = "123"
    return a
}

print(test(a: ""))
