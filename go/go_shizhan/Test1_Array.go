package main

import "fmt"

func main(){
	// 声明数组

	//var arr1 [5]int
	//arr2 := [5]int{1,2,3,4,5}
	//arr3 := [...]int{1,2,3}
	//arr4 := [5]int{0:1,1:2}
	//
	//fmt.Println(arr2)
	//fmt.Println(arr1)
	//fmt.Println(arr3)
	//fmt.Println(arr4)
	//
	//
	//// 使用数组
	//fmt.Println("通过下标修改数组")
	//arr1[1] = 111
	//fmt.Println(arr1[1])
	//
	//fmt.Println("数组的长度")
	//fmt.Println(len(arr1))
	//
	//
	//
	//fmt.Println("数组作为参数传递,发现打印的还是111，说明是值传递")
	//test1(arr1)
	//fmt.Println(arr1[1])
	//
	//fmt.Println("在go 语言中，最好用指针的形式传递数组,发现打印的是333")
	//fmt.Println("值传递的时候，go 会在栈上复制该数组，造成空间浪费")
	//test2(&arr1)
	//fmt.Println(arr1[1])



	// testcode 2
	var array [4]int

	array1 := [5]int{1,2,3,4,5}

	array2 := [...]int{1,2}

	array3 := [5]int{0:1,1:10}

	fmt.Println(array)
	fmt.Println(array1)
	fmt.Println(array2)
	fmt.Println(array3)

	//只有长度和类型一致，才能这么操作
	array1 = array3






}

func test1(a [5]int){
	a[1] = 222
}

func test2(a *[5]int){
	a[1] = 333
}