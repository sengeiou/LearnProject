package main

import (
	"fmt"
)

func main() {
	// 不支持隐式类型转换，即便是窄类型转宽类型
	var b byte = 100
	var n int = int(b)

}
