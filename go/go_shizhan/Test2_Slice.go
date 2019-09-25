package main

import (
	"fmt"
	"reflect"
)

func main() {
	// 切片是围绕动态数组的概念构成的，可以按需自动增长和缩小

	// 创建切片
	// 创建一个int 切片，长度和容量都是5
	slice := make([]int, 5)
	fmt.Println(slice)

	// 创建string 切片，长度为3，容量为5
	slice1 := make([]string, 3, 5)
	fmt.Println(slice1)

	// 不允许创建容量小于长度的切片
	//slice2 := make([]int,3,1)   //会报错，len larger than cap in make([]int)
	//fmt.Println(slice2)

	// 通过字面量创建切片

	slice3 := []int{1, 2, 3} // 长度和容量都是3
	arr := [1]int{1}
	fmt.Println(slice3)

	//记住，如果在[] 中指定了值，那么创建的就是数组，而不是切片。
	fmt.Println(reflect.TypeOf(slice3)) // 判断切片和数组的类型
	fmt.Println(reflect.TypeOf(arr))

	// 使用索引申明切片
	slice4 := []string{99: "empty"}
	fmt.Println(slice4)
	fmt.Println(cap(slice4)) //  这里slice4 的长度和容量都是100
	fmt.Println(len(slice4))

	// 创建 nil 类型的切片
	var slice5 []int
	fmt.Println(len(slice5)) // 这里不会报错
	//fmt.Println(slice5[1])    //会报错
	fmt.Println(slice5)

	// 创建空切片
	slice6 := make([]int, 0)
	fmt.Println(slice6)

	// 使用字面量创建空切片
	slice7 := []int{}
	fmt.Println(slice7)

	// 使用切片
	slice8 := []int{0,1,2,3,4,5,6,7,8,9}
	slice8 [1] = 10

	fmt.Println(slice8)

	// 访问切片
	fmt.Println(slice8[1])    // 10


	// 使用切片创建切片
	slice9 := slice8[1:3]
	fmt.Println(slice9)         // [10,2]
	fmt.Println(len(slice9))   //2   3-1=2
	fmt.Println(cap(slice9))   //9   10-1=9


	//append

	slice10 := make([]int,0)
	slice10 = append(slice10,1)
	fmt.Println(slice10)
	fmt.Println(len(slice10))
	fmt.Println(cap(slice10))
	slice10 = append(slice10,1)
	fmt.Println(slice10)
	fmt.Println(len(slice10))
	fmt.Println(cap(slice10))

	// 创建切片时的三个索引，这块还需要再深入理解下



	// 迭代切片

	for index,value := range slice8{
		fmt.Printf(" the index = %d, and value = %d \n" ,index,value)
	}

	for i := 0; i< len(slice8);i++{
		item := slice8[i];
		fmt.Printf("this index = %d , and value = %d \n",i, item)
	}


	// 在函数之间传递切片, 一个切片占用24个字节，指针，容量，长度，各占8个字节
	// 与切片关联的数据只存在与数组里，不包含在切片里，所以在函数间传递，复制也只会复制切片本身，不会涉及到底层数组的复制
	// 在函数间传递切片非常高效，方便，所以不需要使用别的传递方式了，比如指针等
	// 传递好切片后，按照需求修改数据，然后返回一个新的切片副本就好
	resultSlice  := foo(slice8)
	fmt.Println("仔细查看foo 函数的修改,发现 slice8 和 resultSlice的第一个元素都被修改成了 10000  ")
	fmt.Println(slice8)
	fmt.Println(resultSlice)

}



func foo(slice []int) []int{
	slice[0] = 10000
	return slice
}