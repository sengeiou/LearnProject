package main

import (
	"fmt"
	"strings"
)

type Person struct {
	Name string
}

func main() {
	var map1 map[int]string = make(map[int]string)
	map1[1] = "one"

	if ok := map1[1]; len(strings.TrimSpace(ok)) != 0 {
		fmt.Println(ok)
	}

	fmt.Println(map1[2])

	map2 := make(map[int]string)
	fmt.Println(map2)

	map3 := map[int]int{1: 1, 2: 2}
	fmt.Println(map3)

	for k, v := range map1 {
		fmt.Println(k, v)
	}

	var p Person
	map4 := map[string]Person{"1": p, "2": Person{Name: "cocoa"}}
	fmt.Println(map4)

	// 测试 取值的判断
	if v, exists := map4["1"]; exists {
		fmt.Println(v)
	}

	// 测试 nil map
	var map5 map[int]int
	fmt.Println(map5)
	//map5[1] = 1   //assignment to entry in nil map


	// map 是引用传递

}
