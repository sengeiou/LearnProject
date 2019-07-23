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
	a := A{Name : "AAAA"}
	a.Print()
	fmt.Println(a.Name)


	b :=A{Name :"BBBB"}
	b.Test()
	fmt.Println(b.Name)

}

func (a A) Print() {
	a.Name = "asd"
	fmt.Println("-------------Print----------")
}

func (a *A) Test() {
	a.Name = "ASD"
	fmt.Println("-------------Test----------")
}
