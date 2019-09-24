package main

import (
	"fmt"
)

func main() {

	var a = [4]int{1, 2, 3}
	fmt.Println(a)

	var size = len(a)

	for i := 0; i < size; i++ {
		fmt.Println(a[i])
	}

	var b = [3]int{2: 4}
	fmt.Println(b)

	var c = [...]int{123, 123}
	var d = [...]int{123, 123}
	var e = [...]int{123, 111}
	// var f = [...]int{1}
	fmt.Println(c == d) // true
	fmt.Println(c == e) // false
	// fmt.Println(c == f) // fail invalid operation: c == f (mismatched types [2]int and [1]int)

}
