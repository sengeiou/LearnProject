package main

import (
	"fmt"
)

/**
1 根据规则，但方法接口命名为方法名后加上er
2 当对象赋值给接口时，会发生拷贝，而接口内部存储的是指向这个复制品的指针
既无法修改复制品的状态，也无法获取指针

*/
type Dever interface {
	coding()
	Player //接口的嵌入
}

type Player interface {
	play()
}

type Person struct {
	name string
}

func (p *Person) coding() {
	p.name = "yinyonggai"
	fmt.Println("coding.......")
}

func (p Person) play() {
	p.name = "cocoa"
	fmt.Println("playing.......")
}

func main() {

	p := &Person{name: "shenjun"}
	p.coding()
	p.play()

	fmt.Println(p.name)

	// code(p)
	//视频学习到18分钟左右

	// var palyer Player
	// palyer = Player(p) //接口可以向下转换 ，Dever可以转Player  Player不能转Dever
	// palyer.play()

}

// func code(d Dever) {

// 	if person, ok := d.(Person); ok {

// 		fmt.Println(person.name + "is Person") // 判断interface类型
// 	}

// 	// person.coding()
// }
