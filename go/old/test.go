package main

import "fmt"

const (
	mo = 1
)

func main() {

	a := &Person{
		Name: "shenjun",
		Age:  12,
	}

	change(a)
	fmt.Println(a)

	fmt.Println(mo)
	fmt.Println("----------------")

	aa := [7]int{12, 12, 12, 32, 343, 45}
	sss := aa[0:]
	fmt.Println(cap(sss))
	fmt.Println(len(sss))
	fmt.Println(sss)

	var slice []int = make([]int, 3, 3)
	fmt.Println(cap(slice))
	fmt.Println(len(slice))

}

type Person struct {
	Name string
	Age  int32
}

func change(n *Person) {
	n.Name = "cocoa"
	fmt.Println(n)
}
