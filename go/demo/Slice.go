package main

import (
	"fmt"
)

/**
*  1. Slice 是一种数据结构，可以理解为是一种动态数组，可以按需自动增长和缩小
*  2. Slice 底层在内存中也是连续分配的，所以也能够获得索引，迭代，和优化垃圾回收
*  3. Slice 有三个重要的字段： 指向底层数组的指针，切片的长度，切片的容量
*  4.
*
*
*
*
**/

func main() {

	// 创建切片
	slice1 := make([]string, 5) // 使用类型和长度申明

	slice2 := make([]int, 3, 4) // 使用类型，长度，容量申明

	// 不允许创建容量小于长度的切片，不然会报错

	slice3 := []int{1, 2, 3} // 创建一个整形切片，长度和容量都是3

	slice4 := []int{9: 1} // 长度为10的切片 ,第10个元素为1

	fmt.Println(slice1)
	fmt.Println(slice2)
	fmt.Println(slice3)
	fmt.Println(slice4)

	// 这里要注意的是，[] 指定了值，就是数组，不指定值，就是切片

	// 创建 nil 和 空切片

	var nilSlice []int // 创建 nil 切片
	fmt.Println(nilSlice)
	fmt.Println("the slice is nil", (nilSlice == nil))

	// 下面创建空切片

	emptySlice := make([]int, 0)
	emptySlice1 := []int{}

	fmt.Println(emptySlice)
	fmt.Println(emptySlice1)

	//使用切片

	slice4[0] = 100

	fmt.Println(slice4)

	// 使用切片创建切片 ，
	newSlice := slice4[0:8] // len = 8 cap =10

	PrintSlice(newSlice)

	newSlice[0] = 1111

	// 这里要注意 slice4 和 newSlice 共享一个底层数组，修改一个，可能会影响另一个
	fmt.Println(slice4)

	// 切片增长
	newSlice = append(newSlice, 10000)
	newSlice = append(newSlice, 10000)
	newSlice = append(newSlice, 10000)

	PrintSlice(newSlice)
	PrintSlice(slice4)

	s1 := []int{11, 22}
	s2 := []int{33, 44}

	appSlice := append(s1, s2...) //追加slice ，不知道为什么，这里要用...
	PrintSlice(appSlice)

	//迭代slice  两种方式
	for index, value := range appSlice {
		fmt.Println(index, "---", value)
	}

	for index := 0; index < len(appSlice); index++ {
		fmt.Println(index, "---", appSlice[index])
	}

}

func PrintSlice(slice []int) {
	fmt.Printf("this slice len = %d and cap = %d \n", len(slice), cap(slice))
	fmt.Println(slice)
}
