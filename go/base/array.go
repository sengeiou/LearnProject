package main

import (
	"fmt"
)

/**
go 数组



*/

func main1() {

	fmt.Print("123 \n")

	//定义一个长度为4的int 数组
	var intArray [4]int //数组的定义1

	// 输出为[0,0,0,0]
	fmt.Print(intArray)

	a := [...]int{1, 1, 1} //数组的定义2
	var b = [10]int{1, 2}  //数组的定义3

	fmt.Print(a) // 输出为[1,1,1]
	fmt.Print(b) // 输出为[1,2,0,0,0,0,0,0,0,0]

	//test2(a)   这里不能这么调用  : cannot use a (type [3]int) as type [10]int in argument to test2

	test2(b) // 这样就可以使用，参数和形参的类型是一致的

	c := []int{1, 2, 3}

	test1(c) // 这样也是可以的

	//遍历数组1
	for i := 0; i < len(b); i++ {
		fmt.Println(b[i])
	}

  //遍历数组2
  for index,value := range b{
    fmt.Println(index,value)
  }



}

//定义方法的型参数

func test1(array []int) {

}

func test2(array [10]int) {

}
