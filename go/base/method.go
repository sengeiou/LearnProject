package main

import (
	"fmt"
)

type A struct {
	Name string
}

/**
1 方法就是有接收者的函数 （a A）为接收者   func (a A) Print() {
2 接收者不能定义为接口类型
3 接收者类型只能是 T  或  *T ，（T是类型）
*/
func main() {
	a := A{}
	a.Print()

	b := 1
	//  b.Test()    这样写是错误的

}

func (a A) Print() {
	fmt.Println("-------------Print----------")
}

func (a int) Test() {
	fmt.Println("-------------Test----------")
}
