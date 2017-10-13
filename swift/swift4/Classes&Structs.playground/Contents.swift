
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
    var nane : String?
}

// class and structure instance
let someResolution = Resolution()
let someVideoMode = VideoMode()



// Accessing Properties
someVideoMode.frameRate
someVideoMode.resolution.height



// memberwise initializers for structure type (only structure have)
let vga = Resolution(width: 100, height: 100)

















