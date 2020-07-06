struct Resolution{
	var width = 0
	var height = 0
}

let vga = Resolution(width: 100, height: 100)
print("\(vga)")


let bga = vga 

print("\(bga==vga)")


