import UIKit

enum CompassPoint{
    case north
    case south
    case west
    case east
    
}



var west : CompassPoint = .west
var esst = CompassPoint.east

print(west)

switch west {
case .north:
    print("some code")
default:
    print("other code")
}

enum Status : CaseIterable{
    case LOADING, PRPER, ENDED
}

let allCaseCount = Status.allCases.count

for itemCase in Status.allCases{
    print(itemCase)
}

enum BarCode {
    case upc(Int, Int, Int , Int)
    case qrCode(String)
}

var barCode = BarCode.upc(100, 100, 100, 100)

switch barCode {
case .upc(let p1, let p2, let p3,let p4):
    print("\(p1) \(p2) \(p3) \(p4) and other so on")
default:
    print("the default")
}



enum Type : Int{
    case one = 1, two, three
}

var two  = Type.two
print(two.rawValue)   // 2


let result = Type(rawValue: 3)  // 使用原始值初始化枚举实例
print(result  == Type.three)  // true













