import UIKit






// 构造过程中的常量属性
class  SurveyQuestion {
    
    let text: String
    var resp : String?
    
    init(){
        self.text = "default text"
    }
    
    func ask(){
        print(text)
    }
}

var survery =  SurveyQuestion()
survery.ask()
survery.resp



// 默认构造器
// 提供了默认值，又没有提供自定义的构造器，那么会自动给结构体或类生成一个构造器
class Test10{
    var name : String?
    var age : Int = 0
}

var test10 = Test10()


// 结构体的卓一构造器

// 值类型的构造器代理
// 简单的说就是构造器调用构造器，方便代码复用
// class因为支持继承，所以构造器代理相对比较复杂
//如果你创建了自定义的构造器，那么你无法访问到默认的构造器，包括结构体的卓一构造器

// 值类型的构造器代理
struct Rect{
    var width : Int
    var height : Int
    
    init(){
        self.width = 0
        self.height = 0
    }
    
    init(width  : Int, height  : Int){
        self.height = height
        self.width = width
    }
    
    init(sp : Int) {
        self.init(width: sp, height: sp)
    }
}

var rect1 = Rect(sp: 10)



// 类的继承和构造过程

// 指定构造器和便利构造器

// 一个类必须要有一个指定构造器（继承父类的也算），指定构造器用来初始化类中的所有属性
// 便利构造器是一个比较次要的构造器
class Test11{
    
    // 指定构造器
//    init() {}
    
    
    // 便利构造器
//    convenience init(){}
}


// 规则
// 1. 指定构造器必须调用其父类的指定构造器
// 2. 便利构造器必须调用同类中定义的其他构造器
// 3. 便利构造器最后必须调用指定构造器

// 指定构造器向上代理，便利构造器横向代理







// 构造器的继承和重写
class Vehicle {
    var number = 0
    var desc : String {
        return "\(number)"
    }
//    init(number : Int){
//        self.number = number
//    }
}

class Bicycle : Vehicle{
    override init(){
        super.init()
        self.number = 10
    }
}



// 指定构造器和便利构造器实践

class Food {
    var name : String
    init(name : String) {
        self.name = name
    }
    
    convenience init(){
        self.init(name : "[unnamed]")
    }
}

var food1 = Food(name: "food1")
var food2 = Food()

class RecipeIngredient : Food {
    var quantity : Int
    
    init(name : String , quantity : Int){
        self.quantity = quantity
        super.init(name: name)
    }
    
    convenience init(quantity : Int){
        self.init(name: "default", quantity : quantity);
    }
    
}

// 只有下面的两种的创建方式，文档中的RecipeIngredient() 报错，因为，无法初始化 quantity 字段，个人感觉也是会报错的
let r0 = RecipeIngredient(name: "r0", quantity: 0)
let r1 = RecipeIngredient(quantity: 1)
print(r1.name)
print(r1.quantity)


class ShoppingListItem : RecipeIngredient {
    var purvhased  = false
    var desc  : String {
            return "\(name) \(quantity)"
    }
}

let s1 = ShoppingListItem(name: "s1", quantity: 1)
let s2 = ShoppingListItem(quantity: 2)


let name =  """
    请3123123
    2313123
    1231321
"""


// 可失败构造器

if let result  = Int(exactly: 3.111111111){
    print("\(result) ok")
}else{
    print("init failed")
}

class Person{
    var name : String

    init?(name : String){
        if name.isEmpty {
            return nil
        }
        self.name = name
    }
}

if let pp1 = Person(name : ""){
    print("person \(pp1) ok")
}else{
    print("person pp1 failed")
}































