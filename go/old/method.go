package main

import (
	"fmt"
)

type A struct {
	Name string
}

type B struct {
	Name string
}

type CocoInt int

/**
1 方法就是有接收者的函数 （a A）为接收者   func (a A) Print() {
2 接收者不能定义为接口类型
3 接收者类型只能是 T  或  *T ，（T是类型）
*/

func main() {
	fmt.Println("---------------use method------------------------")
	a := A{}
	a.Print()

	b := B{}
	b.Print() //特别注意，method 为 func (b *B) Print(){} ，有指针操作，但是调用时不需要做取地址的操作

	var cInt CocoInt
	cInt.Print()
}

//声明method
func (a A) Print() {
	fmt.Println("...method.A")
}

func (b *B) Print() {
	fmt.Println("...method.B")
}

func (cInt *CocoInt) Print() {
	//.......
}
