package main

import (
	"fmt"
)

/**
 *
 * 函数不支持嵌套，重载，默认参数
 * 多返回值，不定长变参吗，匿名函数，闭包
 * 关键字func 申请， 左大括号不能另起一行
 * 函数可以做为一种类型使用
 * 默认情况下，function中的参数是进行值传递的，如果想要在function内部修改原来数据的值，需要传递引用，用&符号。
 * 例外：引用类型默认是进行引用传递的，比如slices, maps, interfaces, channels.
 *
 */
func main() {
	if a, ok := add(2, 2); ok {
		fmt.Println(a)
	}

	tt := func() { // 闭包函数
		fmt.Println(123)
	}
	tt()

	f1 := closure(10)
	fmt.Println(f1(10))

	v1,v2 :=  closure1();
	fmt.Println(v1)
	fmt.Println(v2(1))


	//
	// everyType(1,2);
	// everyType("shen","12312","12312");

	fmt.Println(test())

}

func test() int{
		a := 10;
		a++;
		return a;
}




func everyType(a ...interface{}){  // 多参数类型，  interface{}  表示任何类型
		for item := range a{
			fmt.Println(item)
		}
}

func add(x int, y int) (int, bool) { // 可以返回多个值，这里返回int和布尔类型，也可以无返回值，一个返回值时，可以不用写（）
	if x == 1 {
		return 0, false
	}
	return x + y, true
}

func test1(a, b, c int) (x, y, z int) { // 当参数或返回值的类型一致时，可以只写一个
	return 1, 2, 3
}

func test2(x string, a ...int) { // 不定长变参，一定要在参数的最后面

}

func test3() {
	fmt.Println("----")
}

func closure(x int) func(int) int {
	return func(y int) int {
		return x + y
	}
}

func closure1() (int , func(int) int){
	return 1, func (y int)int {
		return  y
	}

}
