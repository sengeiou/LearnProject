package main

import (
	"fmt"
)

/**
1. 方法能给某种类型添加新的行为，方法实际也是函数，只是在申明是，在关键字 func 和方法名之间增加了一个参数
2. func关键字和函数名之间的参数被称为 接受者，若有一个函数有接受者，这个函数就是可以被称为方法



*/

type user struct {
	name string
	age  int
}

func (u user) notify() { // 值接受者，调用时，会创建u的副本
	fmt.Println(u.name)
}
func (u *user) changeAge() { // 指针接受者，这个方法会共享调用方法时接受者所指向的值
	u.age = 1000000
}

func main() {
	u := user{name: "cocoa",
		age: 12,
	}

	u.notify()

	tom := &user{"tom", 12}
	tom.changeAge()
	fmt.Println(tom.age)

	u.changeAge() // 使用值类型 调用 指针接受者的 方法
	fmt.Println(u.age)

}
