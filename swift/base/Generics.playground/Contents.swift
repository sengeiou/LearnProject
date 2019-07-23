//: Playground - noun: a place where people can play

import UIKit
// inout 的概念要再理解下
// mutating

// Generics <泛型>

//泛型代码让你能够根据自定义的需求，编写出适用于任意类型、灵活可重用的函数及类型。它能让你避免代码的重复，用一种清晰和抽象的方式来表达代码的意图。

// 没有使用泛型
// 假设要定义个交换两个变量的函数

func swapTwoInts(a : inout Int , b : inout Int){
    let temp  = a
    a = b;
    b = temp
}

var a  = 10
var b  = 11

swap(&a, &b)

print("a  = \(a) && b = \(b)")

// 上面的demo 交换了 a 和 b，但是只是允许了 int参数 
// 那么如果要交换两个字符串呢？ 交换两个double 类型呢


func swapTwoStrings(_ a: inout String, _ b: inout String) {
    let temporaryA = a
    a = b
    b = temporaryA
}

func swapTwoDoubles(_ a: inout Double, _ b: inout Double) {
    let temporaryA = a
    a = b
    b = temporaryA
}

// 其实上面的方法有很多冗余，通过泛型就可以解决这个问题


func swapTwoValues<T> (a : inout T , b : inout T){
    let temp = a
    a = b
    b = temp
}

var someInt  = 1
var anotherInt = 2;

swapTwoValues(a: &someInt, b: &anotherInt)

print("someInt  = \(someInt) && anotherInt= \(anotherInt)")

// 想交换两个字符串变量， 也只需要调用swapTwoValues 就行，就不具体写了
//通过上面的例子，已经发现使用泛型的好处了，下面来具体的了解泛型


// # 类型泛型
//在上面的 swapTwoValues(_:_:) 例子中，占位类型 T 是类型参数的一个例子。类型参数指定并命名一个占位类型，并且紧随在函数名后面，使用一对尖括号括起来（例如 <T>）。
//类似这样的使用
func test<T> (a : T ){
}


// # 命名类型参数
// 在大多数情况下，类型参数具有一个描述性名字，例如 Dictionary<Key, Value> 中的 Key 和 Value，以及 Array<Element> 中的 Element，这可以告诉阅读代码的人这些类型参数和泛型函数之间的关系。然而，当它们之间没有有意义的关系时，通常使用单个字母来命名，例如 T、U、V，正如上面演示的 swapTwoValues(_:_:) 函数中的 T 一样。


// # 泛型类型
// 除了泛型函数，Swift 还允许你定义泛型类型。这些自定义类、结构体和枚举可以适用于任何类型，类似于 Array 和 Dictionary。

// 这部分内容将向你展示如何编写一个名为 Stack （栈）的泛型集合类型。栈是一系列值的有序集合，和 Array 类似，但它相比 Swift 的 Array 类型有更多的操作限制。数组允许在数组的任意位置插入新元素或是删除其中任意位置的元素。而栈只允许在集合的末端添加新的元素（称之为入栈）。类似的，栈也只能从末端移除元素（称之为出栈）。

// 使用泛型自定义一个简单的 栈


struct Stack<Element> {
    var items  = [Element]()
    mutating func push (item : Element) {
        items .append(item)
    }
    
    mutating func pop() -> Element{
        return items.removeLast()
    }
}


var stackOfString = Stack<String>()
stackOfString.push(item: "123")

print(stackOfString.items)



// # 扩展一个泛型类型
// 当你扩展一个泛型类型的时候，你并不需要在扩展的定义中提供类型参数列表。原始类型定义中声明的类型参数列表在扩展中可以直接使用，并且这些来自原始类型中的参数名称会被用作原始定义中类型参数的引用。

extension Stack{
    var topItem : Element? {
        return items.isEmpty ? nil : items[items.count - 1]
    }
}


if let topItem = stackOfString.topItem
{
    print(topItem)
}else{
    print("top item is nil")
}



// # 类型约束  (大致内容讲了用协议或类来约束泛型的类型)
// 有的时候如果能将使用在泛型函数和泛型类型中的类型添加一个特定的类型约束，将会是非常有用的。类型约束可以指定一个类型参数必须继承自指定类，或者符合一个特定的协议或协议组合。

//例如，Swift 的 Dictionary 类型对字典的键的类型做了些限制。在字典的描述中，字典的键的类型必须是可哈希（hashable）的。也就是说，必须有一种方法能够唯一地表示它。Dictionary 的键之所以要是可哈希的，是为了便于检查字典是否已经包含某个特定键的值。若没有这个要求，Dictionary 将无法判断是否可以插入或者替换某个指定键的值，也不能查找到已经存储在字典中的指定键的值。

// 为了实现这个要求，一个类型约束被强制加到 Dictionary 的键类型上，要求其键类型必须符合 Hashable 协议，这是 Swift 标准库中定义的一个特定协议。所有的 Swift 基本类型（例如 String、Int、Double 和 Bool）默认都是可哈希的。

// 当你创建自定义泛型类型时，你可以定义你自己的类型约束，这些约束将提供更为强大的泛型编程能力。抽象概念，例如可哈希的，描述的是类型在概念上的特征，而不是它们的显式类型。


// # 类型约束语法
// 你可以在一个类型参数名后面放置一个类名或者协议名，并用冒号进行分隔，来定义类型约束，它们将成为类型参数列表的一部分。对泛型函数添加类型约束的基本语法如下所示（作用于泛型类型时的语法与之相同）：

class SomeClass{
}

protocol SomeProtocol{
}

func someFunc<T : SomeClass , U : SomeProtocol> (someT : T , someU : U){

}
//上面这个函数有两个类型参数。第一个类型参数 T，有一个要求 T 必须是 SomeClass 子类的类型约束；第二个类型参数 U，有一个要求 U 必须符合 SomeProtocol 协议的类型约束。

// 上面的代码有点不明白，为什么都已经是约束， someClass 和 SomeProtocol 类型了，还要再用泛型


// 类型约束实践
// 这里不写demo 了。比较重要的是Equatable 的运用

func test< T : Equatable > (into : [T], temp : T){
    for a in into{
        print(a==temp)
    }
}

class ttt {
}

var  ab : [ttt] = [];

//cannot convert value of type '[ttt]' to expected argument type '[_]'
//test(into : ab ,temp : ttt());   会报错

var testInt : [Int] = [1,2,3]

test( into : testInt, temp : 1)   // Int遵循Equatable 协议

// 如果要让 数组[ttt] 放到 test 方法中，就必须遵循Equatable 协议
// 后面要自己实现下



// # 关联类型

// 定义一个协议时，有的时候声明一个或多个关联类型作为协议定义的一部分将会非常有用。关联类型为协议中的某个类型提供了一个占位名（或者说别名），其代表的实际类型在协议被采纳时才会被指定。你可以通过 associatedtype 关键字来指定关联类型。

// 不知道啥意思



// # 并联类型实践

protocol Container{
    associatedtype ItemType
    mutating func append_(_ item : ItemType)
    var count : Int { get }
    subscript ( i : Int ) -> ItemType { get }
}


// 太神奇了
// 用 上面的 Stack 去实现 Container 协议。swift 会推断 Element 类型就是 ItemType 类型



// # 通过扩展一个存在的类型来制定关联类型
extension Array : Container{
    mutating internal func append_(_ item: Element) {
    
    }
}

var aaa : [Int] = []

aaa.append_(1)

print(aaa)

// 上面的不是很理解，代码也没完善


// 泛型 where 语句

// 类型约束让你能够为泛型函数或泛型类型的类型参数定义一些强制要求

// 为关联类型定义约束也是非常有用的。



//理解不了，跳过
















































