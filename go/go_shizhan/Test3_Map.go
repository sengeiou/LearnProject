package main

import "fmt"

func main(){
	// 创建map

	dict1 := make(map[string]int)
	dict1["one"] = 1
	fmt.Println(dict1)


	dict2 := map[string]int{"one":1,"two":2}
	fmt.Println(dict2)

}