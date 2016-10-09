package main

import (
	"fmt"
	"math"
)

/**
 * defer 后定义的先调用
 * panic recover 要再学习下



 */
func main() {

	fmt.Println("--defer start--")
	defer fmt.Println("--1---")
	defer fmt.Println("--2---")

	fmt.Println("观察上面的打印顺序")

	for i := 0; i < 3; i++ {
		defer func() {
			fmt.Println(i)
		}() // 观察这里的输出
	}

	fmt.Println("test result", test())
	math.Abs(-12)
}

func test() (result int) { //这个函数返回2
	defer func() {
		result++
	}()
	return 1
}

func A() {
	fmt.Println("FUNC A")
}

func B() {
	panic("FUNC A")
}

func C() {
	fmt.Println("FUNC C")
}
