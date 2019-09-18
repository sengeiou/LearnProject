package main

import (
	"fmt"
)

// 1 go没有class
// 2 type<name> struct{} 定义结构

// 定义struct:   type <name> struct{}
type Person struct {
	Name string
	Age  int
}

func main() {

	person := Person{ //初始化方法一
		Name: "cococa",
		Age:  18,
	}

	p11 := new(Person)

	fmt.Println(p11.Name)

	person1 := &Person{ //推荐用这个，直接取地址。 后续的调用 person1.name="cocococo"
		Name: "cococa",
		Age:  18,
	}

	person.Name = "tiancai"

	change(&person)

	fmt.Println(person)
	fmt.Println(person1)

	fmt.Println("----------------匿名struct-----------------------")
	//匿名struct 又是炒鸡变态的东西
	p := struct {
		Name string
		Age  int
	}{
		Name: "cococa",
		Age:  12,
	}

	fmt.Println(p)

}

//改变struct 需要用指针
func change(p *Person) {
	p.Age = 13

}
