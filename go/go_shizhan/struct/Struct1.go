package main

import "fmt"

//struct 传递的时候是值传递
type Person struct {
	Name string
	Age  int
}
// 嵌套结构
type Class struct {
	P Person
	Count int
}

func main() {
	p := Person{}
	fmt.Println(p)

	p.Name = "cocoa"
	fmt.Println(p.Name)

	p1 := Person{
		Name: "cocoa",
		Age:  12,
	}
	fmt.Println(p1)

	// 建议这么操作
	p2 := &Person{
		Name: "123",
		Age:  12,
	}
	fmt.Println(p2)

	// 匿名结构
	a := struct {
		Name string
	}{
		Name: "cocoa",
	}
	fmt.Println(a)


	// 初始化嵌套结构
	c := Class{
		Count:1,
		P:Person{
			Name: "ccoa",
			Age: 12,
		},
	}
	fmt.Println(c)


}
