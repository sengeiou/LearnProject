package main

import (
	"fmt"
)

type user struct {
	name  string
	email string
}

func (u *user) notify() {
	fmt.Println(u.name)
}

type admin struct {
	user
	lelvel string
}

func main() {

	ad := &admin{
		lelvel: "1",
		user: user{
			name:  "cocoa",
			email: "email",
		},
	}

	// 这里的执行结果居然是 两个cocoa  ，很神器的操作
	// 	ad.notify()  为什么这句也能执行 ，内部类型的方法被提升到了外部类型
	// 这就是嵌套类型的神奇之处
	ad.user.notify()
	ad.notify()

}
