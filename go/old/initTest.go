package main

import (
	"fmt"
)

func init() {
	fmt.Println("init")
}

func main() {
	fmt.Println("main")

	_, _, a := getNumber()
	fmt.Println(a)
	fmt.Println(sum(1, 2, 3, 4))
}

func sum(nums ...int) int {
	total := 0
	for _, num := range nums {
		total += num
	}
	return total
}

func getNumber() (int, int, int) {
	return 1, 2, 3
}
