package main

import (
	"fmt"
)

func main() {

	// slice  本身不是数组，底层指向数组
	// slice 为引用类型 （如果多个slice 指向相同底层数组，改变值会影响别的slice）
	// slice 可以直接创建（ 用make()创建 ） 或 从底层数组生成
	// slice 句的创建  make([]T,len,cap)  cap的值可以省略，如果省略，则和len的值相同
	// 使用 len()获取元素个数 使用cap()获取容量
	// 有点类似变长数组

	//example1 从数组生成
	a := [10]int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9} //定义数组
	fmt.Println(a)                             //---->[0 1 2 3 4 5 6 7 8 9]
	slice1 := a[0:5]                           // 生成切片 0:5 表示从数组的0-4位开始截取
	fmt.Println(slice1)                        // 0-4位开始截取  --->[0 1 2 3 4]
	fmt.Println(len(slice1))                   //--->5
	fmt.Println(cap(slice1))                   //--->10

	//example2  make生成
	var numbers = make([]int, 3, 4)
	fmt.Println(len(numbers)) //--->3
	fmt.Println(cap(numbers)) //--->4

	fmt.Println("-----------reslice---------------")

	// reslice
	reslice1 := slice1[0:]     //0:为0到末尾（简写） reslice注意：索引不能操过slice的cap值
	fmt.Println(reslice1)      //  --->[1 2 3 4]   cap 为10
	fmt.Println(cap(reslice1)) //--->9



	fmt.Println("-----------append---------------")
	slice2 := a[0:10]
	fmt.Printf("%v %p \n", slice2, slice2)
	fmt.Println(cap(slice2))                  //--->10
	fmt.Println(len(slice2))                  //--->10
	slice2 = append(slice2, 1, 2, 3, 4, 5, 6) //  append 操作时，如果加入的数量超过cap 后，slice的cap会扩大一倍 ，内存地址也会发生变化
	fmt.Printf("%v %p\n", slice2, slice2)
	fmt.Println(cap(slice2)) //--->10
	fmt.Println(len(slice2)) //--->16
}
