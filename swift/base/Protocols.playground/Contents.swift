//: Playground - noun: a place where people can play

import UIKit

// 协议
//协议 定义了一个蓝图，规定了用来实现某一特定任务或者功能的方法、属性，以及其他需要的东西。类、结构体或枚举都可以遵循协议，并为协议定义的这些要求提供具体实现。某个类型能够满足某个协议的要求，就可以说该类型遵循这个协议。


// 协议的定义
protocol SomeProtocol{
    
}

// 协议的使用
struct SomeStruct : SomeProtocol{

}

class SomeClass : SomeProtocol{

}


// 属性要求
//协议可以要求遵循协议的类型提供特定名称和类型的实例属性或类型属性。协议不指定属性是存储型属性还是计算型属性，它只指定属性的名称和类型。此外，协议还指定属性是可读的还是可读可写的。

//如果协议要求属性是可读可写的，那么该属性不能是常量属性或只读的计算型属性。如果协议只要求属性是可读的，那么该属性不仅可以是可读的，如果代码需要的话，还可以是可写的。

//协议总是用 var 关键字来声明变量属性，在类型声明后加上 { set get } 来表示属性是可读可写的，可读属性则用 { get } 来表示：


protocol FullyNamed{
    var fullName : String { get }
}

struct Person : FullyNamed{
    
    var fullName: String
    var age  : Int
}

var john = Person(fullName: "john", age :12)

john.age = 13
john.fullName = "Sam"

// 测试 类型属性


// 下面是为class 遵循了 FullyNamed 协议

class StartShip : FullyNamed{
    //每一个 Starship 类的实例都有一个名为 name 的非可选属性和一个名为 prefix 的可选属性。
    var prefix : String?
    var name : String
    init(name : String , prefix : String? = nil){
        self.name  = name
        self.prefix = prefix
    }
    //计算型属性 fullName 会将 prefix 插入到 name 之前，从而为星际飞船构建一个全名。
    var fullName: String {
        return (prefix != nil ? prefix! + " " : " ") + name
    }
}

var ncc1701 = StartShip(name: "Enterprise", prefix: "USS")


// 方法要求
// 协议可以要求遵循协议的类型实现指定的实例方法或类方法。
// 在协议内部定义，不需要大括号和方法体。方法参数和普通方法一致，不支持为协议中的方法的参数提供默认值。

protocol SomeProtocol_{
    static func someTypeMethod()
}

protocol RandomNumberGenerator{
    func random()  -> Double
}

// 实现协议的方法
class LinearCongruentialGenerator  : RandomNumberGenerator{

    func random() -> Double {
        return 1.0  //这里不添加算法逻辑的代码，就简单返回一个默认值
    }
}
// 怎么使用，就和以前一样


//Mutating 方法要求
//在方法中改变方法所属的实例
// 比如：在值类型（即结构体和枚举）的实例方法中，将 mutating 关键字作为方法的前缀，写在 func 关键字之前，表示可以在该方法中修改它所属的实例以及实例的任意属性的值。 http://wiki.jikexueyuan.com/project/swift/chapter2/11_Methods.html#modifying_value_types_from_within_instance_methods

// 看demo
protocol Togglable{
    mutating func toggle()
}

enum OnOffSwitch :Togglable{
    case off , on
    mutating func toggle() {
        switch self {
        case .off:
            self = .on
        case .on:
            self = .off
        }
    }
}

var  lightSwitch  =  OnOffSwitch.off
lightSwitch.toggle()


// # 构造器要求
//协议可以要求遵循协议的类型实现指定的构造器。
protocol SomeProtocol__{
    init()
    init(someParameter : Int)
}

// 构造器在类中的实现
//你可以在遵循协议的类中实现构造器，无论是作为指定构造器，还是作为便利构造器。无论哪种情况，你都必须为构造器实现标上 required 修饰符：
//使用 required 修饰符可以确保所有子类也必须提供此构造器实现，从而也能符合协议。
//如果类是final 类，则不需要在协议构造器的实现中使用 required 修饰符，因为 final 类不能有子类。
class SomeClass__ : SomeProtocol__{
    var name : String
    required init(){
        self.name = ""
    }
    
    required init(someParameter: Int) {
        self.name = ""
    }
}

var someClass__ = SomeClass__(someParameter: 1)

//如果一个子类重写了父类的指定构造器，并且该构造器满足了某个协议的要求，那么该构造器的实现需要同时标注 required 和 override 修饰符：
protocol SomeProtocol1 {
    init()
}

class SomeSuperClass1 {
    init() {
        // 这里是构造器的实现部分
    }
}

class SomeSubClass: SomeSuperClass1, SomeProtocol1 {
    // 因为遵循协议，需要加上 required
    // 因为继承自父类，需要加上 override
    required override init() {
        // 这里是构造器的实现部分
    }
}


//可失败构造器要求

//协议还可以为遵循协议的类型定义可失败构造器要求，详见可失败构造器。

//遵循协议的类型可以通过可失败构造器（init?）或非可失败构造器（init）来满足协议中定义的可失败构造器要求。协议中定义的非可失败构造器要求可以通过非可失败构造器（init）或隐式解包可失败构造器（init!）来满足。



// 协议作为类型
// 尽管协议本身并未实现任何功能，但是协议可以被当做一个成熟的类型来使用。
// 协议可以像其他普通类型一样使用，使用场景如下：

// 1.作为函数、方法或构造器中的参数类型或返回值类型
// 2.作为常量、变量或属性的类型
// 3.作为数组、字典或其他容器中的元素类型

// demo
class Dice{
    let sides : Int
    let generator : RandomNumberGenerator
    
    init(sides : Int , generator : RandomNumberGenerator) {
        self.sides = sides
        self.generator = generator
    }
    
    func roll() -> Int{
        return Int(generator.random())+sides
    }

}
//generator 是一个RandomNumberGenerator协议类型，传入的是一个实现了协议的LinearCongruentialGenerator类, 几乎现在所有的编程语言都是这样的
var mDice = Dice(sides: 10, generator: LinearCongruentialGenerator())
mDice.roll()


//委托（代理）模式
//委托是一种设计模式，它允许类或结构体将一些需要它们负责的功能委托给其他类型的实例。委托模式的实现很简单：定义协议来封装那些需要被委托的功能，这样就能确保遵循协议的类型能提供这些功能。委托模式可以用来响应特定的动作，或者接收外部数据源提供的数据，而无需关心外部数据源的类型。

// 有点看不明白, 看demo , 两个基于骰子游戏的协议
protocol DiceGame{
    var dice : Dice { get }
    func play()
}


protocol DiceGameDelegate{
    func gameDidStart(_ game : DiceGame)
    func game(_ game : DiceGame , didStartNewTurnWithDiceRoll diceRoll : Int )
    func gameDidEnd(_ game : DiceGame)
}

//DiceGame 协议可以被任意涉及骰子的游戏遵循。DiceGameDelegate 协议可以被任意类型遵循，用来追踪 DiceGame 的游戏过程。


class SnakesAndLadders: DiceGame {
    let finalSquare = 25
    let dice = Dice(sides: 6, generator: LinearCongruentialGenerator())
    var square = 0
    var board: [Int]
    init() {
        board = [Int](repeating : 0, count : finalSquare + 1)
        board[03] = +08; board[06] = +11; board[09] = +09; board[10] = +02
        board[14] = -10; board[19] = -11; board[22] = -02; board[24] = -08
    }
    var delegate: DiceGameDelegate?
    func play() {
        square = 0
        delegate?.gameDidStart(self)
        gameLoop: while square != finalSquare {
            let diceRoll = dice.roll()
            delegate?.game(self, didStartNewTurnWithDiceRoll: diceRoll)
            switch square + diceRoll {
            case finalSquare:
                break gameLoop
            case let newSquare where newSquare > finalSquare:
                continue gameLoop
            default:
                square += diceRoll
                square += board[square]
            }
        }
        delegate?.gameDidEnd(self)
    }
}

// # 通过扩展添加协议一致性
// 即便无法修改源代码，依然可以通过扩展令已有类型遵循并符合协议。扩展可以为已有类型添加属性、方法、下标以及构造器，因此可以符合协议中的相应要求。详情请在扩展章节中查看。

protocol TextRepresentable {
    var textualDescription: String { get }
}

extension Dice: TextRepresentable {
    var textualDescription: String {
        return "A \(sides)-sided dice"
    }
}



// # 通过扩展遵循协议
// 当一个类型已经符合了某个协议中的所有要求，却还没有声明遵循该协议时，可以通过空扩展体的扩展来遵循该协议：

protocol Cryer{
    func cry()
}

class Chinese {
    func cry(){
        print(" Chinese is cry")
    }
}

func test(c : Cryer ){
    c.cry()
}

// test(c: Chinese())  这样是会报错的,即使Chinese 有了cry 方法
//  即使满足了协议的所有要求，类型也不会自动遵循协议，必须显式地遵循协议。
extension Chinese : Cryer {}  // 扩展Chinese 去遵循协议

test(c : Chinese())  // 不会报错




// 协议类型集合
// 协议类型可以在数组或者字典这样的集合中使用，在协议类型提到了这样的用法。
class American : Cryer {
    func cry(){
        print(" American is cry")
    }
}

let cryer  : [Cryer] =  [Chinese(), American() ];  // 这里的类型是Cryer ，而不是一个具体的Chinese 或者 American

for c in cryer {
    c.cry()
}

// # 协议的继承
// 协议能够继承一个或多个其他协议，可以在继承的协议的基础上增加新的要求。协议的继承语法与类的继承相似，多个被继承的协议间用逗号分隔：


protocol InheritingProtocol: SomeProtocol {
    // 这里是协议的定义部分
}

//例子中定义了一个新的协议 PrettyTextRepresentable，它继承自 TextRepresentable 协议。任何遵循 PrettyTextRepresentable 协议的类型在满足该协议的要求时，也必须满足 TextRepresentable 协议的要求。
protocol PrettyTextRepresentable: TextRepresentable {
    var prettyTextualDescription: String { get }
}

// 具体的使用就不说了





// # 类类型专属协议
// 你可以在协议的继承列表中，通过添加 class 关键字来限制协议只能被类类型遵循，而结构体或枚举不能遵循该协议。class 关键字必须第一个出现在协议的继承列表中，在其他继承的协议之前：

protocol SomeClassOnlyProtocol : class {  // 如果还要遵循别的协议，就用, 隔开
        func test()
}

//non-class type 'P' cannot conform to class protocol 'SomeClassOnlyProtocol'
//struct P : SomeClassOnlyProtocol{
//}



// #协议合成
// 有时候需要同时遵循多个协议，你可以将多个协议采用 SomeProtocol & AnotherProtocol 这样的格式进行组合，称为 协议合成（protocol composition）。你可以罗列任意多个你想要遵循的协议，以与符号(&)分隔。

protocol Named{
    var name : String { get }
}

protocol Aged{
    var age : Int { get }
}

struct PersonP : Named , Aged{
    var name : String
    var age : Int
}
struct PersonB : Named{
    var name : String
}


func wishHappyBirthday(to celebrator : Named & Aged){
    print("\(celebrator.name)=====\(celebrator.age)")
}


var p  = PersonP(name: "shenjun", age: 123)
var b  = PersonB(name: "cocoa")

wishHappyBirthday(to: p)
//wishHappyBirthday(to: b)   报错
//argument type 'PersonB' does not conform to expected type 'Aged & Named'





// # 检查协议一致性
// 你可以使用类型转换中描述的 is 和 as 操作符来检查协议一致性，即是否符合某协议，并且可以转换到指定的协议类型。检查和转换到某个协议类型在语法上和类型的检查和转换完全相同：
    
    //is 用来检查实例是否符合某个协议，若符合则返回 true，否则返回 false。
    //as? 返回一个可选值，当实例符合某个协议时，返回类型为协议类型的可选值，否则返回 nil。
    //as! 将实例强制向下转换到某个协议类型，如果强转失败，会引发运行时错误。











