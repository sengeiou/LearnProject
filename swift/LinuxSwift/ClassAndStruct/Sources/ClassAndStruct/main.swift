struct Resolution{
	var width = 0
	var height = 0
}

let vga = Resolution(width: 100, height: 100)
// print("\(vga)")

print("\(CommandLine.arguments)")
print("\(CommandLine.arguments.count)")


let bga = vga 


//  print("\(bga===vga)") // 这里要注意，值类型不能使用 == 运算符
// 因为值类型永远不可能是同一个引用？



class VedioMode{
	var name :String?
	var frmaeRate = 0.0
}

var v1  = VedioMode()
var v2 = VedioMode()

print("\(v1 === v2)")





