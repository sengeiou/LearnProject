
// 创建枚举
// 创建了指南针的枚举，
enum CommpassPoint{
    case north
    case south
    case east
    case west
}

// 可以出现在同一行上，用逗号隔开
enum Type{
    case type1, type2
}

// 枚举的类型推断
var commpass = CommpassPoint.east
commpass = .north   // 因为有了推断，可以简写

// 用 switch 语句进行枚举匹配
switch commpass {
case .north:
    print("north")
default:
    print("default")
}


enum Barcode{
    case upc(Int,Int,Int,Int)
    case qrCode(String)
}

var productBarcode = Barcode.qrCode("qrcode")
productBarcode = .upc(1, 2, 3, 4)

// 关联值操作
switch productBarcode {
case .upc(let a ,let b ,let c, let d):
    print(a)
    print(b)
    print(c)
    print(d)
case .qrCode(let code):
    print(code)
}

// 原始值
enum TestEnum :  Int{
    case a   //这里不手动赋值的话，默认就是0
    case b
}

print(TestEnum.a.rawValue)  //0
print(TestEnum.b.rawValue)

// 利用原始值初始化枚举, 当然返回的类型肯定是 optional
if let testEnum = TestEnum(rawValue: 1){
    print(testEnum)
}
















