import UIKit

struct Resolution{
    var width = 0
    var height = 0
}

class VideoMode{
    var resolution = Resolution()
    var name : String?
    var frameRate = 0.0
}

// 逐一成员构造器
let re = Resolution(width: 100, height: 100)

// 结构体和枚举是值类型（基本类型也是值类型）
// 一旦定义成let 就无法修改属性
// 比如这样操作会报错 re.height = 100



// 类是引用类型

var v = VideoMode()
let v1 = v
v1.name = "v1.name"

print(v.name!)   // 这里 v对象的名字被改成了 v1的名字，




