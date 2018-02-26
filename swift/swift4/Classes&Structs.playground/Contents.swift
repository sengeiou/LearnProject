
// An instance of class is traditionlly known as an Object


// comparing classes and structes

// they have many things in common:
// 1. define properties to store value
// 2. define methods to provide access to their values using subscript syntax
// 3. define initializers to set up their initial state
// 4. be extended to expand their functionality beyound a default implementation
// 5. conform to protocols to provide standard funcionality  of a certain kind

// classes have additaional capabilities that structes do not:
// 1.inheritance ednables one class to inherit the characteristics if another.
// 2.type casting enables you to check and interpret the type of a class instance at runtime
// 3.Drinitializers enable an instance of a class to free up any resources it has assigned
// 4. reference counting allows more than one reference to a class instance.



// definition syntax
// use upperCamelCase the named class or struct
class SomeClass{
    
}

struct SomeStruct{
    
}


//example
struct Resolution{
    var width = 0
    var height = 0
}

class VideoMode{
    var resolution = Resolution()
    var interlaced = false
    var frameRate = 0.0
    var name : String?
}

// class and structure instance
let someResolution = Resolution()
let someVideoMode = VideoMode()



// Accessing Properties
someVideoMode.frameRate
someVideoMode.resolution.height



// memberwise initializers for structure type (only structure have)
let vga = Resolution(width: 100, height: 100)

//结构体是值类型，当进行方法的传递的时候，其值被会被拷贝

let hd = Resolution(width: 1000, height: 2000)
var cinema  = hd

cinema .width = 1111
// 这里的输出为1000， 因为 cinema 是拷贝后的结果， struct 独有
print(hd.width)


// 而class 则不一样，class 是引用类型，在被赋值传递的时候，传递是本身的引用，而不是进行拷贝

let tenEighty = VideoMode()
tenEighty.resolution = hd
tenEighty.interlaced = true
tenEighty.name = "cocoa"
tenEighty.frameRate = 25.0


let alsoTenEighty = tenEighty
alsoTenEighty.frameRate = 30.0
// 发现 tenEighty 的 frameRate 已经被修改为了 30.0 ,因为 tenEighty alsoTenEighty 是同一个引用
print(tenEighty.frameRate)

// 需要注意的是，上面 tenEighty 和 alsoTenEighty 都被定义为了 let ,但是还是能修改他们的属性，不会报错
// 因为 class 类型支持这样的操作, 而struct 则不行，一旦定义为了 let,就不能修改它的属性

//hd.height = 100  这里会报错
// 恒等于运算符用来判断引用类型的实例是否相同
// 这里要注意,不同的 class 的实例是不能用来比较的, struct 的实例也是不能比较的

if tenEighty === alsoTenEighty {
    print("there are equals")
}

var ttt = VideoMode()

if ttt !== alsoTenEighty {
    print("not equals")
}

// 当出现下面的情况时，应该考虑使用 结构体

//该数据结构的主要目的是用来封装少量相关简单数据值。
//有理由预计该数据结构的实例在被赋值或传递时，封装的数据将会被拷贝而不是被引用。
//该数据结构中储存的值类型属性，也应该被拷贝，而不是被引用。   *** 感觉这个可以扩展下理解
//该数据结构不需要去继承另一个既有类型的属性或者行为。

















