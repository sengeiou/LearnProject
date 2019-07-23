import UIKit

struct FiexdLengthRange{
    var firstValue : Int
    let length : Int
}

var rangeOfThreeItems = FiexdLengthRange(firstValue: 0, length: 3)
rangeOfThreeItems.firstValue = 6


let rangeOfFourItems  =  FiexdLengthRange(firstValue: 0, length: 4)
//rangeOfFourItems.firstValue = 4   会报错



class DataImport{
    var fileName = "cooca.txt"
    init() {
        print("di init")
    }
}

class DataManager{
    lazy var im = DataImport()
}

let dm = DataManager()
print("something else")
dm.im.fileName


struct Pointrt{
    lazy var o  = 0.0   // lazy 不能用在let 修饰符

    var size = 0.0 {
        willSet{
            print("willset new value \(newValue)")
        }
        didSet{
            print("did set the old value \(oldValue)")
        }
    }
    
    var center : Double {
        get{
            return size
        }
        set{
           self.size = newValue
        }
    }
}

var p = Pointrt()
p.center = 10.0



struct TEST{
    static var name = "123"  // 类型属性
}



