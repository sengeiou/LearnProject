
// An enumeration defines a common type for a group of related values and enables you to work with those values in a type-safe way within your code.


// enumeration syntax

enum someEnum{
    
}


// you use the "case" keyword to introduce new enumneration cases.

// example ,at the example ,each enum item do not implicity equal 0,1,2,3
enum CompassPoint {
    case north
    case south
    case east
    case west
}

//  CompassPoint.east.rawValue   will be error


// multple cases can appear on a single line , separated by commas

enum Planet {
    case mercury , venus , earth , mars , jupiter , saturn, neptune
}


var directionToHead = CompassPoint.west

//can be inferred when it is initialozed
// using a shorter dot syntax
directionToHead = .north



// using switch statement
switch  directionToHead {
case .north:
    print("north")
case .west:
    print("west")
default:
    print("the default")
}


//associated value

enum Barcode {
    case upc(Int, Int, Int , Int)
    case qrCode(String)
}

var pBarcode = Barcode.upc(1, 2, 3, 4)
//pBarcode = .qrCode("this qrcode number _1123_123")


// you can define swift enum to store associated value of any geven type , and the value types can be different for each case of the enum if needed. (at above code, upc and qrcode are different type)

switch pBarcode {
case .qrCode(let code):
    print(code)
case .upc(let p1, let p2, _, let p4):
    print("\(p1)--\(p2)--\(p4)")
default:
    print("the default")
}


// raw value (原始值)
// raw values can be stringsm, character, or any of the interger or floating-poit number types;

// each raw value must be unique within its enum declaration.


enum ASSCIIControllCharacter : Character {
    case tab = "\t"
    case lineFeed = "\n"
    case carriageReturn  = "\r"
}


// raw value are not the as associated values;


// implicitly assigned raw value  (隐式的申明原始值)
enum Planet2 : Int {
    case mercury = 1 , venus , earth , mars , jupiter , saturn, neptune
}

//use rawValue
Planet2.venus.rawValue == 2


enum CompassPoint2 : String {
    case north, south, east, west
}

CompassPoint2.north.rawValue


// initializing from  a raw value  , will get optional
let possiblePlanet = Planet2(rawValue: 3)
print(type(of: possiblePlanet))

let nilResult  = Planet2(rawValue: 111)


if let north = CompassPoint2(rawValue: "north")
{
    print(north)
}



//



