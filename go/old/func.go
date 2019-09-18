package main

import (
	"fmt"
)

/**
1 go 函数不支持嵌套 重载 默认参数
2 go 函数支持 不定长度变参 多返回值 命名返回值参数 匿名函数 闭包
3 go 函数的定义用 func ，左大括号不能另起一行
4 go 函数也可以作为一种类型使用



*/

func main() {
	// a, b, c := example4()
	// fmt.Println(a, b, c)

	fmt.Println("-----------匿名函数--------------------")
	a := closure(1)
	fmt.Println(a(1))

	fmt.Println("--------------example5----------------")
	b := example5
	b()

	fmt.Println("-----------defer--------------------")
	defer fmt.Println("11111")
	defer fmt.Println("22222") //--->22222   \n 11111  defer定义的先定义的后调用

	for i := 0; i < 3; i++ {
		defer fmt.Println(i) //--->3 2 1
	}

	fmt.Println("-----------defer匿名for循环--------------------")
	for i := 0; i < 3; i++ {
		defer func() {
			fmt.Println(i) //--->3 3 3
		}()
	}

	// 一定要观察下上面的打印输出，炒鸡变态

}

// func 不支持重载，默认参数，嵌套

//接受两个参数， 返回int
func example1(a int, b string) int {
	return 1
}

//返回多个参数（匿名返回）
func example2(a int, b string) (int, int, int) {
	return 1, 2, 3
}

//返回多个参数
func example3() (a, b, c int) { //如果需要返回三个参数，c后面不能加逗号
	a, b, c = 1, 2, 3
	//  a, b, c := 1, 2, 3   //  := 不能这么写，因为 abc 已经创建，在返回类型上
	return //可以这样简写 为了代码可读性，还是写下好  return a,b,c
}

//返回多个参数
func example4(a ...int) { //不定长变参 ，要写在参数的最后面  例（b string, a ...int）

}

func example5() {

	fmt.Println("example5...")
}

// 匿名函数
func closure(x int) func(int) int {
	return func(y int) int {
		return x + y
	}
}
