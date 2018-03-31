package main

import (
	"fmt"
)

func main() {

	/*
	* 1.申明一个简单的数组，数组一经定义，类型和长度就不能修改了，如果要存储更多的元素，就需要创建新的更长的数组，
	* 2.在数组中，会使用类型的初始值来对数组的每个元素赋值，比如 int 的初始值 0 ，
	*
	*
	*
	**/

	// create array
	var array1 [5]int
	fmt.Println(array1)

	// 使用字面量创建数组
	array2 := [5]int{0, 1, 2, 3, 4}
	fmt.Println(array2)

	// 使用... 让go 自动计算
	array3 := [...]int{1, 2, 3}
	fmt.Println(array3)

	// 申明部分元素的值，别的元素使用初始值( 个人及其不推荐这种 )
	array4 := [5]int{1: 10, 4: 10}
	fmt.Println(array4)

	// use array
	fmt.Println(array2[2])

	// 把数组赋值给另一个数组
	// 必须要长度和类型一致，才能这么操作
	array1 = array2
	fmt.Println(array2)

	// 多维数组

	var mArray1 [2][3]int
	fmt.Println(mArray1)

	mArray2 := [2][3]int{{1, 2, 3}, {22, 33, 44}}
	fmt.Println(mArray2)

	// 在函数之间传递数组
	// 这里说明： go语言的传参是按值传递的，数组在传递的时候会被复制，可以使用指针来

	change(array2)
	fmt.Println(array2) // 这里测试，发现并没有改变array2 的值，因为发生了值拷贝

}

func change(array [5]int) {
	array[0] = 1111
	fmt.Println(array)
}
