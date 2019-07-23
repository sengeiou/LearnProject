package main

import "fmt"

// 类型的基本定义
type user struct {
	name string
	age  int
}

// 类型的包含
type admin struct {
	level  int
	person user
}

// 给自定义的类型添加方法
// (u user) 注意看，这里就是为 user 类型添加了方法
// 不过这里的u 只是 user 的拷贝
func (u user) notify() {
	fmt.Printf("get name from notify %s \n", u.name)
}

// 这里的 u 是user 对象的引用
func (u *user) changeName(name string){
	u.name  = name
}


func main() {

	// 初始化自定义的结构体
	user := user{
		name: "cocoa",
		age:  12,
	}
	fmt.Println(user)

	admin := admin{
		person: user,
		level:  1,
	}

	fmt.Println(admin)



	user.notify()
	// 这里要注意。changeName 接受的是指针类型的user，而这里的user 并不是指针类型，是go 语言帮我们做了转换
	user.changeName("tom")
	fmt.Println(user.name)


}
