//: Playground - noun: a place where people can play

import UIKit
// 构造过程


// #存储属性的初始赋值

//类和结构体在创建实例时，必须为所有存储属性设置合适的初始值,存储属性的值不能处于未知状态
// 可以在构造器中为存储属性赋值，也可以在定义属性时设置默认值, 注意，前面的两种赋值不会触发属性观察器



// # 构造器
// 某个特定类型的新实例创建的时候被调用，最简单的形式就是无参构造器，构造器以关键字 init() 命名

// example

//init(){
// 写构造过程
//}


// demo 用构造器给存储属性设置默认值

struct FFF{
    var temprature : Double
    
    init(){
    temprature = 12.12
    }
}

var f = FFF()
f.temprature



// # 默认属性值，即在属性申明时为其设置默认值
// 如果在一个属性总是使用相同的初始值，那么建议使用申明时就设置默认值，这样会使构造器更加简洁明了


// demo

struct SSS{
    var temp = 0.0   //直接设置默认值
}



// #自定义构造过程
//你可以通过输入参数和可选类型的属性来自定义构造过程，也可以在构造过程中修改常量属性（这个都行，有点牛逼的）


// # 构造参数
// 自定义构造过程时，可以在定义中提供构造参数，指定所需值的类型和名字
// 其实就是自定义init() 



struct Person1{
    var age : Int
    var name : String
    // 这段代码之所以不会报错，因为结构体有自己的逐一构造器
}

struct Person2{
    var age : Int
    var name : String
 

    
    init(withAge age : Int){
        self.age = age
        self.name = "nunu" // 去掉这句话试试，就会报错，因为name这个储存属性没有默认值，所以就会报错,除非定义name的设置默认值
    }
}


//var p = Person2(10,"") 从这里看到，如果重新定义结构体的构造器，那么原本的逐一构造器就消失了

var p = Person2(withAge: 10)
p.age
p.name




// # 参数的内部名称和外部名称
struct Color{
    let red, green ,blue : Double
    init(red : Double , green : Double ,blue : Double ){
        self.red = red
        self.green = green
        self.blue = blue
    }
    init(white : Double ){
        red = white
        green = white
        blue = white
    }
}

// 使用构造器初始化
let c1 = Color(red: 0.0, green: 0.0, blue: 0.0)
let c2 = Color(white: 0.0)


// let c3 = Color(0.0, 0.0, 0.0)  编译报错，需要外部名称
// Swift 会为构造器的每个参数自动生成一个跟内部名字相同的外部名。（当然你也可以显示的指定）


// #不带外部名的构造器参数
// 如果不想为构造器的某个参数设置外部名，你可以使用下划线(_)来显式描述它的外部名
//（通俗的将就是可以Color(0.0, 0.0, 0.0)这样调用）
// demo 以上面的Color举例

struct CC{
    var red , green : Double
    
    init(_ red : Double , _ green : Double){
        self.green = green
        self.red = red
    }
}

let cc1 = CC(0.0,0.0)  //不带外部名的构造器，个人不建议使用，java就是这样，搞的什么参数都不知道了


// # 可选属性类型
//当你不知道参数的默认值时，可以把属性定义为可选属性类型，可选类型的属性将自动初始化为nil，表示这个属性是有意在初始化时设置为空的。
// 总结： 类中属性的初始化 ：要么默认值，要么在构造方法，要么设置为可选属性类型 ，就三种方法

class XXX{
    var name : String
    var info : String?
    
    init(_name : String){
        name  = _name
    }
}

var xx = XXX(_name: "shenjun")
xx.info
xx.info == nil
xx.info = "sure info"
xx.info


// #构造过程中常量属性的修改
// 构造过程的任意时间都可以修改常量，只要在构造过程结束时是一个固定的值

class SurveyQuestion{

    let text : String
    init(text : String){
        self.text = text
    }
}


var s  = SurveyQuestion(text: "ha")
s.text
//s.text = "123"  编译报错


// # 默认构造器
// 如果结构体或类的所有属性都有默认值，同时没有自定义的构造器，那么系统就会提供一个默认构造区（测试结构体和类）


struct Human1{
    var name : String?
    var age = 0
}

let h1 = Human1()
let h2 = Human1(name: "shenjun", age: 12)
//关于struct，系统会提供一个无参的构造器和一个逐一参数构造器

class Human2{
    var name : String?
    var age : Int?
}
let h21 = Human2()
// 关于class，系统只会提供一个无参数的构造器


// # 结构体的逐一成员构造器（只有struct 有）
//除了上面提到的默认构造器，如果结构体没有提供自定义的构造器，它们将自动获得一个逐一成员构造器，即使结构体的存储型属性没有默认值。
//逐一成员构造器是用来初始化结构体新实例里成员属性的快捷方法。我们在调用逐一成员构造器时，通过与成员属性名相同的参数名进行传值来完成对成员属性的初始赋值。




// # 值类型的构造器代理（结构体和枚举）类类型因为涉及到继承，比较复杂
// 构造器可以通过调用其它构造器来完成实例的部分构造过程。可以减少构造器间的代码重复
// 对于值类型，可以在自定义的构造器中调用self.init，（只能在构造器中调用）
// 为某个值类型定义一个自定义的构造器，将无法访问到默认构造器（结构体将无法访问逐一成员构造器）
// demo

struct Size{
    var width = 0.0
    var height = 0.0
}

struct Point{
    var x = 0.0
    var y = 0.0
}

struct Rect{
    var origin = Point()
    var size  = Size()
    init(){}   //如果自己不写，那么就会被自定义构造器覆盖
    init(origin : Point ,size : Size){
        self.origin = origin
        self.size  = size
    }
    
    init(center : Point, size : Size){
        let originX = center.x - (size.width / 2)
        let originY = center.y - (size.height / 2)
        self.init(origin: Point(x: originX, y: originY), size: size)  // 调用了另一个构造器
    }
    
    
}


// # 类的继承和构造过程
// 类里面的所有存储型属性——包括所有继承自父类的属性——都必须在构造过程中设置初始值。
//Swift 为类类型提供了两种构造器来确保实例中所有存储型属性都能获得初始值，它们分别是指定构造器和便利构造器。


// #指定构造器和便利构造器
//一个指定构造器将初始化类中提供的所有属性，并根据父类链往上调用父类的构造器来实现父类的初始化。
//每一个类都必须拥有至少一个指定构造器。在某些情况下，许多类通过继承了父类中的指定构造器而满足了这个条件。具体内容请参考后续章节构造器的自动继承。

//便利构造器是类中比较次要的、辅助型的构造器。你可以定义便利构造器来调用同一个类中的指定构造器，并为其参数提供默认值。你也可以定义便利构造器来创建一个特殊用途或特定输入值的实例。

// 便利构造器的语法
//convenience init(parameters) {
//    statements
//}


// # 类的构造器代理原则
//规则 1
//指定构造器必须调用其直接父类的的指定构造器。
//规则 2
//便利构造器必须调用同类中定义的其它构造器。
//规则 3
//便利构造器必须最终导致一个指定构造器被调用。

//一个更方便记忆的方法是：
//指定构造器必须总是向上代理
//便利构造器必须总是横向代理



// # 两段式构造过程

// Swift 中类的构造过程包含两个阶段。第一个阶段，每个存储型属性被引入它们的类指定一个初始值。当每个存储型属性的初始值被确定后，第二阶段开始，它给每个类一次机会，在新实例准备使用之前进一步定制它们的存储型属性。

// 两段式构造过程的使用让构造过程更安全，同时在整个类层级结构中给予了每个类完全的灵活性。两段式构造过程可以防止属性值在初始化之前被访问，也可以防止属性被另外一个构造器意外地赋予不同的值。


// Swift 编译器将执行 4 种有效的安全检查，以确保两段式构造过程能不出错地完成：

// 安全检查 1

// 指定构造器必须保证它所在类引入的所有属性都必须先初始化完成，之后才能将其它构造任务向上代理给父类中的构造器。

// 如上所述，一个对象的内存只有在其所有存储型属性确定之后才能完全初始化。为了满足这一规则，指定构造器必须保证它所在类引入的属性在它往上代理之前先完成初始化。

// 安全检查 2

// 指定构造器必须先向上代理调用父类构造器，然后再为继承的属性设置新值。如果没这么做，指定构造器赋予的新值将被父类中的构造器所覆盖。

// 安全检查 3

// 便利构造器必须先代理调用同一类中的其它构造器，然后再为任意属性赋新值。如果没这么做，便利构造器赋予的新值将被同一类中其它指定构造器所覆盖。

// 安全检查 4

// 构造器在第一阶段构造完成之前，不能调用任何实例方法，不能读取任何实例属性的值，不能引用self作为一个值。


// 类实例在第一阶段结束以前并不是完全有效的。只有第一阶段完成后，该实例才会成为有效实例，才能访问属性和调用方法。

// 以下是两段式构造过程中基于上述安全检查的构造流程展示：

// 阶段 1

// 某个指定构造器或便利构造器被调用。
// 完成新实例内存的分配，但此时内存还没有被初始化。
// 指定构造器确保其所在类引入的所有存储型属性都已赋初值。存储型属性所属的内存完成初始化。
// 指定构造器将调用父类的构造器，完成父类属性的初始化。
// 这个调用父类构造器的过程沿着构造器链一直往上执行，直到到达构造器链的最顶部。
// 当到达了构造器链最顶部，且已确保所有实例包含的存储型属性都已经赋值，这个实例的内存被认为已经完全初始化。此时阶段 1 完成。

// 阶段 2
// 从顶部构造器链一直往下，每个构造器链中类的指定构造器都有机会进一步定制实例。构造器此时可以访问self、修改它的属性并调用实例方法等等。
// 最终，任意构造器链中的便利构造器可以有机会定制实例和使用self。


// # 构造器的继承和重写


// 跟 Objective-C 中的子类不同，Swift 中的子类默认情况下不会继承父类的构造器。Swift 的这种机制可以防止一个父类的简单构造器被一个更精细的子类继承，并被错误地用来创建子类的实例。

// 父类的构造器仅会在安全和适当的情况下被继承。具体内容请参考后续章节构造器的自动继承。


// 假如你希望自定义的子类中能提供一个或多个跟父类相同的构造器，你可以在子类中提供这些构造器的自定义实现。

// 当你在编写一个和父类中指定构造器相匹配的子类构造器时，你实际上是在重写父类的这个指定构造器。因此，你必须在定义子类构造器时带上override修饰符。即使你重写的是系统自动提供的默认构造器，也需要带上override修饰符，具体内容请参考默认构造器。

// 正如重写属性，方法或者是下标，override修饰符会让编译器去检查父类中是否有相匹配的指定构造器，并验证构造器参数是否正确。

// 注意
// 当你重写一个父类的指定构造器时，你总是需要写override修饰符，即使你的子类将父类的指定构造器重写为了便利构造器。

// demo

class Vehicle{
    var numberOfWheels = 0
    var description : String {
        return "\(numberOfWheels) wheels "
    }
    init(){}
    
    init(withWheels wheelNum : Int) {
        self.numberOfWheels = wheelNum
    }
    
}
// Vehicle类只为存储型属性提供默认值，而不自定义构造器。因此，它会自动获得一个默认构造器，具体内容请参考默认构造器。自动获得的默认构造器总会是类中的指定构造器，它可以用于创建numberOfWheels为0的Vehicle实例：

let vehicle  = Vehicle()
print(vehicle.description)


class Bycycle : Vehicle{
    override init() {
        super.init()
        numberOfWheels = 2
    }
}

var bicycle  = Bycycle()



//子类Bicycle定义了一个自定义指定构造器init()。这个指定构造器和父类的指定构造器相匹配，所以Bicycle中的指定构造器需要带上override修饰符。

//Bicycle的构造器init()以调用super.init()方法开始，这个方法的作用是调用Bicycle的父类Vehicle的默认构造器。这样可以确保Bicycle在修改属性之前，它所继承的属性numberOfWheels能被Vehicle类初始化。在调用super.init()之后，属性numberOfWheels的原值被新值2替换。



// # 构造器的自动继承

// 如上所述，子类在默认情况下不会继承父类的构造器。但是如果满足特定条件，父类构造器是可以被自动继承的。在实践中，这意味着对于许多常见场景你不必重写父类的构造器，并且可以在安全的情况下以最小的代价继承父类的构造器。

// 假设你为子类中引入的所有新属性都提供了默认值，以下 2 个规则适用：

// 规则 1
// 如果子类没有定义任何指定构造器，它将自动继承所有父类的指定构造器。

// 规则 2
// 如果子类提供了所有父类指定构造器的实现——无论是通过规则 1 继承过来的，还是提供了自定义实现——它将自动继承所有父类的便利构造器。

// 即使你在子类中添加了更多的便利构造器，这两条规则仍然适用。

// 注意
// 对于规则 2，子类可以将父类的指定构造器实现为便利构造器。


// # 指定构造器和便利构造器实践

// 接下来的例子将在实践中展示指定构造器、便利构造器以及构造器的自动继承。这个例子定义了包含三个类Food、RecipeIngredient以及ShoppingListItem的类层次结构，并将演示它们的构造器是如何相互作用的。

// 类层次中的基类是Food，它是一个简单的用来封装食物名字的类。Food类引入了一个叫做name的String类型的属性，并且提供了两个构造器来创建Food实例：

class Food {
    var name : String
    init(name : String){
        self.name  = name
    }
    convenience init(){  //
        self.init(name : "Food convenience name")
    }
}

// 类类型没有默认的逐一成员构造器，所以Food类提供了一个接受单一参数name的指定构造器。这个构造器可以使用一个特定的名字来创建新的Food实例：

let namedMeat = Food(name: "Bacon")
namedMeat.name


// Food类中的构造器init(name: String)被定义为一个指定构造器，因为它能确保Food实例的所有存储型属性都被初始化。Food类没有父类，所以init(name: String)构造器不需要调用super.init()来完成构造过程。

// Food类同样提供了一个没有参数的便利构造器init()。这个init()构造器为新食物提供了一个默认的占位名字，通过横向代理到指定构造器init(name: String)并给参数name传值[Food convenience name]来实现：

let convenienceFood  = Food()
convenienceFood.name


// 类层级中的第二个类是Food的子类RecipeIngredient。RecipeIngredient类用来表示食谱中的一项原料。它引入了Int类型的属性quantity（以及从Food继承过来的name属性），并且定义了两个构造器来创建RecipeIngredient实例：

class RecipeIngredient : Food{
    var quantity : Int
    init(name : String , quantity : Int) {
        self.quantity = quantity
        super.init(name : name)
    }
    
    override convenience init(name : String){
        self.init(name : name , quantity : 1)
    }
}



// RecipeIngredient类拥有一个指定构造器init(name: String, quantity: Int)，它可以用来填充RecipeIngredient实例的所有属性值。这个构造器一开始先将传入的quantity参数赋值给quantity属性，这个属性也是唯一在RecipeIngredient中新引入的属性。随后，构造器向上代理到父类Food的init(name: String)。这个过程满足两段式构造过程中的安全检查 1。

// RecipeIngredient还定义了一个便利构造器init(name: String)，它只通过name来创建RecipeIngredient的实例。这个便利构造器假设任意RecipeIngredient实例的quantity为1，所以不需要显式指明数量即可创建出实例。这个便利构造器的定义可以更加方便和快捷地创建实例，并且避免了创建多个quantity为1的RecipeIngredient实例时的代码重复。这个便利构造器只是简单地横向代理到类中的指定构造器，并为quantity参数传递1。

// 注意，RecipeIngredient的便利构造器init(name: String)使用了跟Food中指定构造器init(name: String)相同的参数。由于这个便利构造器重写了父类的指定构造器init(name: String)，因此必须在前面使用override修饰符（参见构造器的继承和重写）。

// 尽管RecipeIngredient将父类的指定构造器重写为了便利构造器，它依然提供了父类的所有指定构造器的实现。因此，RecipeIngredient会自动继承父类的所有便利构造器。看oneMysteryItem 实例

// 在这个例子中，RecipeIngredient的父类是Food，它有一个便利构造器init()。这个便利构造器会被RecipeIngredient继承。这个继承版本的init()在功能上跟Food提供的版本是一样的，只是它会代理到RecipeIngredient版本的init(name: String)而不是Food提供的版本。

// 所有的这三种构造器都可以用来创建新的RecipeIngredient实例：

let oneMysteryItem = RecipeIngredient()
oneMysteryItem.name
oneMysteryItem.quantity

let oneBacon = RecipeIngredient(name: "Bacon")
oneBacon.name
oneBacon.quantity

let sixEggs = RecipeIngredient(name: "Eggs", quantity: 6)
sixEggs.name
sixEggs.quantity


//类层级中第三个也是最后一个类是RecipeIngredient的子类，叫做ShoppingListItem。这个类构建了购物单中出现的某一种食谱原料。

//购物单中的每一项总是从未购买状态开始的。为了呈现这一事实，ShoppingListItem引入了一个布尔类型的属性purchased，它的默认值是false。ShoppingListItem还添加了一个计算型属性description，它提供了关于ShoppingListItem实例的一些文字描述：

class ShoppingListItem : RecipeIngredient{
    var purchased  = false
    var description : String {
        var output = "\(quantity) x \(name)"
        output += purchased ? " ✔" : " ✘"
        return output
    }
}

// ShoppingListItem没有定义构造器来为purchased提供初始值，因为添加到购物单的物品的初始状态总是未购买。

// 由于它为自己引入的所有属性都提供了默认值，并且自己没有定义任何构造器，ShoppingListItem将自动继承所有父类中的指定构造器和便利构造器。


var breakfastList = [
    ShoppingListItem(),
    ShoppingListItem(name: "Bacon"),
    ShoppingListItem(name: "Eggs", quantity: 6),
]
breakfastList[0].name = "Orange juice"
breakfastList[0].purchased = true
for item in breakfastList {
    print(item.description)
}
// 1 x orange juice ✔
// 1 x bacon ✘
// 6 x eggs ✘


// 好复杂，还要再看几遍


// 可失败构造器
// 如果一个类、结构体或枚举类型的对象，在构造过程中有可能失败，则为其定义一个可失败构造器。这里所指的“失败”是指，如给构造器传入无效的参数值，或缺少某种所需的外部资源，又或是不满足某种必要的条件等。

// 为了妥善处理这种构造过程中可能会失败的情况。你可以在一个类，结构体或是枚举类型的定义中，添加一个或多个可失败构造器。其语法为在init关键字后面添加问号(init?)。

// 注意
// 可失败构造器的参数名和参数类型，不能与其它非可失败构造器的参数名，及其参数类型相同。
// 可失败构造器会创建一个类型为自身类型的可选类型的对象。你通过return nil语句来表明可失败构造器在何种情况下应该“失败”。

// 注意
// 严格来说，构造器都不支持返回值。因为构造器本身的作用，只是为了确保对象能被正确构造。因此你只是用return nil表明可失败构造器构造失败，而不要用关键字return来表明构造成功。

struct Animal{
    let species : String
    init?(species : String){
        if species.isEmpty{
            return nil
        }
        self.species = species
    }
}

if let animal  = Animal(species: "") {
    print(animal.species)
}else{
    print("animal not init")
}

if let animal  = Animal(species: "sheep") {
    print(animal.species)
}else{
    print("animal not init")
}



// # 枚举类型的可失败构造器
// 你可以通过一个带一个或多个参数的可失败构造器来获取枚举类型中特定的枚举成员。如果提供的参数无法匹配任何枚举成员，则构造失败。

// 下例中，定义了一个名为TemperatureUnit的枚举类型。其中包含了三个可能的枚举成员(Kelvin，Celsius，和Fahrenheit)，以及一个根据Character值找出所对应的枚举成员的可失败构造器：

enum TemperatureUnit {
    case Kelvin, Celsius, Fahrenheit
    init?(symbol : Character){
        switch symbol {
        case "K":
            self = .Kelvin
        case "C":
            self = .Celsius
        case "F":
            self = .Fahrenheit
        default:
            return nil
        }
    }
}

//  使用方法和普通的可失败构造器一样


//  #带原始值的枚举类型的可失败构造器

//  带原始值的枚举类型会自带一个可失败构造器init?(rawValue:)，该可失败构造器有一个名为rawValue的参数，其类型和枚举类型的原始值类型一致，如果该参数的值能够和某个枚举成员的原始值匹配，则该构造器会构造相应的枚举成员，否则构造失败。


enum TemperatureUnit2: Character {
    case Kelvin = "K", Celsius = "C", Fahrenheit = "F"
}
let unknownUnit = TemperatureUnit2(rawValue: "X")
if unknownUnit == nil {
    print("This is not a defined temperature unit, so initialization failed.")
}

// 就是说原始值的枚举自带可失败构造器，这块查看枚举，再巩固下



// # 构造失败的传递

// 类，结构体，枚举的可失败构造器可以横向代理到类型中的其他可失败构造器。类似的，子类的可失败构造器也能向上代理到父类的可失败构造器。

// 无论是向上代理还是横向代理，如果你代理到的其他可失败构造器触发构造失败，整个构造过程将立即终止，接下来的任何构造代码不会再被执行。

class Product {
    let name: String
    init?(name: String) {
        if name.isEmpty { return nil }
        self.name = name
    }
}

class CartItem: Product {
    let quantity: Int
    init?(name: String, quantity: Int) {
        if quantity < 1 { return nil }
        self.quantity = quantity
        super.init(name: name)
    }
}
if let oneUnnamed = CartItem(name: "", quantity: 1) {
    print("Item: \(oneUnnamed.name), quantity: \(oneUnnamed.quantity)")
} else {
    print("Unable to initialize one unnamed product")
}
// 这个好理解 看代码就行

// 如同其它的构造器，你可以在子类中重写父类的可失败构造器。或者你也可以用子类的非可失败构造器重写一个父类的可失败构造器。这使你可以定义一个不会构造失败的子类，即使父类的构造器允许构造失败。

// 注意，当你用子类的非可失败构造器重写父类的可失败构造器时，向上代理到父类的可失败构造器的唯一方式是对父类的可失败构造器的返回值进行强制解包。

// 注意
// 你可以用非可失败构造器重写可失败构造器，但反过来却不行。
// 下例定义了一个名为Document的类，name属性的值必须为一个非空字符串或nil，但不能是一个空字符串：

class Document {
    var name: String?
    // 该构造器创建了一个 name 属性的值为 nil 的 document 实例
    init() {}
    // 该构造器创建了一个 name 属性的值为非空字符串的 document 实例
    init?(name: String) {
        self.name = name
        if name.isEmpty { return nil }
    }
}
// 下面这个例子，定义了一个Document类的子类AutomaticallyNamedDocument。这个子类重写了父类的两个指定构造器，确保了无论是使用init()构造器，还是使用init(name:)构造器并为参数传递空字符串，生成的实例中的name属性总有初始"[Untitled]"：


class AutomaticallyNamedDocument: Document {
    override init() {
        super.init()
        self.name = "[Untitled]"
    }
    override init(name: String) {
        super.init()
        if name.isEmpty {
            self.name = "[Untitled]"
        } else {
            self.name = name
        }
    }
}

class UntitledDocument: Document {
    var a  : Bool = false
    override init?(name : String){  // 如果开头是override init? 则必须带上name： String
        super.init(name : "1")
    }
    
    override init() {
        super.init(name: "[Untitled]")!  // 注意 ！
    }
}


// #可失败构造器 init!

// 通常来说我们通过在init关键字后添加问号的方式（init?）来定义一个可失败构造器，但你也可以通过在init后面添加惊叹号的方式来定义一个可失败构造器（init!），该可失败构造器将会构建一个对应类型的隐式解包可选类型的对象。

// 你可以在init?中代理到init!，反之亦然。你也可以用init?重写init!，反之亦然。你还可以用init代理到init!，不过，一旦init!构造失败，则会触发一个断言。



// #必要构造器
// 在类的构造器前添加required修饰符表明所有该类的子类都必须实现该构造器：

class SomeClass {
    required init() {
        // 构造器的实现代码
    }
}

// 在子类重写父类的必要构造器时，必须在子类的构造器前也添加required修饰符，表明该构造器要求也应用于继承链后面的子类。在重写父类中必要的指定构造器时，不需要添加override修饰符：

class SomeSubclass: SomeClass {
    required init() {
        // 构造器的实现代码
    }
}

// #通过闭包或函数设置属性的默认值
// 如果某个存储型属性的默认值需要一些定制或设置，你可以使用闭包或全局函数为其提供定制的默认值。每当某个属性所在类型的新实例被创建时，对应的闭包或函数会被调用，而它们的返回值会当做默认值赋值给这个属性。

// 这种类型的闭包或函数通常会创建一个跟属性类型相同的临时变量，然后修改它的值以满足预期的初始状态，最后返回这个临时变量，作为属性的默认值。




