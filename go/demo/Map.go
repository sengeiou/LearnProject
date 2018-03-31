package main

import (
	"fmt"
)

/**
1.映射是一个集合，是无序的。




*/

func main() {

	// 创建映射
	dict1 := make(map[string]int)

	// 使用字面量创建映射
	dict2 := map[string]int{"111": 111, "222": 222, "333": 333}

	//使用字面量创建空的map
	dict3 := map[string]int{}

	fmt.Println(dict1)
	fmt.Println(dict2)
	fmt.Println(dict3)

	// 使用切片

	dict3["123"] = 123

	// 获取值并判断

	value, exists := dict3["test"]
	if exists {
		fmt.Println(value)
	} else {
		fmt.Println("there is no key called [test]")
	}

	// 迭代map

	for key, value := range dict2 {
		fmt.Println(key, value)
	}

	//删除值

	delete(dict2, "222")
	delete(dict2, "222222") // 删除不存在的key， 也不会报错

	fmt.Println(dict2)

}
