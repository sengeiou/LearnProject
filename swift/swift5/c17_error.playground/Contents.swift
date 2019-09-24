import UIKit

enum CocoaError : Error {
    case null
    case number(nu : Int)
}


func test() throws{
    throw CocoaError.null
}

func test1(params : String) throws -> String {
    if params.isEmpty {
        throw CocoaError.null
    }
    return "ok"
}


do {
    try test1(params : "")
}catch CocoaError.null {
    print("cocoa error null ")
}

// 将错误转换成可选值


func test3() -> String?{
    if let data  = try? test1(params: "111") {
        return data
    }
    return nil
}

if let r3 = test3() {
    print("r3 ok \(r3)")
}else{
    print("r3 error")
}










