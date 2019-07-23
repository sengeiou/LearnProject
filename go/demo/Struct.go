package main

import (
	"fmt"
)

type person struct {
	name string
	age  int
}

type admin struct {
	per   person
	level string
}

func main() {
	var p person
	p.name = "cocoa"
	fmt.Println(p)

	lisa := person{
		name: "lisa",
		age:  12,
	}

	fmt.Println(lisa)

	tom := person{"tom", 123}

	fmt.Println(tom)

	change(tom)

	fmt.Println(tom.name) // struct 也是值传递的

	zhangsan := &person{"zhangsan", 12} //直接用取地址符号，创建结构指针

	changeA(zhangsan)

	fmt.Println(zhangsan)
}

func change(p person) {
	p.name = "changed"
}

func changeA(p *person) {
	p.name = "changed"
}
