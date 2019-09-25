
// 定义基类
class Vehicle{
    var currentSpeed = 0.0
    var description : String{
        return "\(currentSpeed)"
    }
    func makeNoise(){
        print("this is make noice @ parent")
    }
    final func toString(){   // 防止被重写，也可以加在class 前
        print(self)
    }
}
//你可以将一个继承来的只读属性重写为一个读写属性，只需要在重写版本的属性里提供 getter 和 setter 即可。但是，你不可以将一个继承来的读写属性重写为一个只读属性。

class Bicycle : Vehicle {
    
    // 重写属性
    override var description: String {
        get{
            return "\(super.description) @ child proprety"
        }
        set{
            description = newValue
        }
    }
    
    override func makeNoise() {   // 子类重写要加上 override 关键字
        super.makeNoise()  //如果要访问超类，可以这么做
        print("this is make noice @ child")
    }
}

var bicycle  = Bicycle()
print(bicycle.description)
bicycle.makeNoise()


