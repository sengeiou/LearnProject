package main

import (
	"fmt"
)
/**
1. slice 由三部分组成，一个指向数组的指针，长度和容量
2. slice 类型一般写成 []T ，没有固定的长度
3. 长度对应 slice 中元素的数目，长度不能超过容量，容量一般是从slice的开始位置到底层数据的结尾位置
4. cap  和 len 用来获取 slice 的容量和长度
5. slice 为引用类型 （如果多个slice 指向相同底层数组，改变值会影响别的slice）
6. go 语言实战中指出，数组作为方法参数传递时会产生拷贝，影响内存，而指针则可以解决这个问题，但是修改指针同时会改变原数组，slice 则可以解决这两个问题
7. 每次扩容时，容量是原来的2倍

*/


func main() {
	// // slice  本身不是数组，底层指向数组
	// // slice 为引用类型 （如果多个slice 指向相同底层数组，改变值会影响别的slice）
	// // slice 可以直接创建（ 用make()创建 ） 或 从底层数组生成
	// // slice 句的创建  make([]T,len,cap)  cap的值可以省略，如果省略，则和len的值相同
	// // 使用 len()获取元素个数 使用cap()获取容量
	// // 有点类似变长数组

	// //example1 从数组生成
	// a := [10]int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9} //定义数组
	// fmt.Println(a)                             //---->[0 1 2 3 4 5 6 7 8 9]
	// slice1 := a[0:5]                           // 生成切片 0:5 表示从数组的0-4位开始截取
	// fmt.Println(slice1)                        // 0-4位开始截取  --->[0 1 2 3 4]
	// fmt.Println(len(slice1))                   //--->5
	// fmt.Println(cap(slice1))                   //--->10

	// //example2  make生成
	// var numbers = make([]int, 3, 4)
	// fmt.Println(len(numbers)) //--->3
	// fmt.Println(cap(numbers)) //--->4

	// fmt.Println("-----------reslice---------------")

	// // reslice
	// reslice1 := slice1[0:]     //0:为0到末尾（简写） reslice注意：索引不能操过slice的cap值
	// fmt.Println(reslice1)      //  --->[1 2 3 4]   cap 为10
	// fmt.Println(cap(reslice1)) //--->9

	// fmt.Println("-----------append---------------")
	// slice2 := a[0:10]
	// fmt.Printf("%v %p \n", slice2, slice2)
	// fmt.Println(cap(slice2))                  //--->10
	// fmt.Println(len(slice2))                  //--->10
	// slice2 = append(slice2, 1, 2, 3, 4, 5, 6) //  append 操作时，如果加入的数量超过cap 后，slice的cap会扩大一倍 ，内存地址也会发生变化
	// fmt.Printf("%v %p\n", slice2, slice2)
	// fmt.Println(cap(slice2)) //--->10
	// fmt.Println(len(slice2)) //--->16

	// 测试1 20170119

	array1 := [...]int{1,2,3,4,5,6,7,8,9}
	
	
	slice := make([]int, 5, 5)      // make 创建切片
	slice1 := array1[2: len(array1)]   // 从数组创建切片
	
	var nilSlice []int         // nil 切片
	emptySlice := make([]int,0)	 // 空切片
	fmt.Println(nilSlice)
	fmt.Println(emptySlice)


	fmt.Println("the slice1 =")
	fmt.Println(slice1)
	fmt.Printf("the slice1 length %d and cap is %d \n", len(slice1), cap(slice1))

	for index := 0; index < 4; index++ {
		// 使用append 的时候，会自动增加长度和容量
		slice1 =  append(slice1, index)
	}
	fmt.Println(slice1)
	fmt.Printf("the slice1 length %d and cap is %d \n", len(slice1), cap(slice1))

	slice1[2] = 99999
	
	fmt.Println("change slice1 发现原数组无变化，只有slice 自己变了")
	fmt.Println(array1)
    fmt.Println(slice1)
	
	// 两个切片相加
	newSlice1 := append(slice1, slice1...)
	fmt.Println("the newSlice1 is ")
	fmt.Println(newSlice1)
	fmt.Printf("the newSlice length %d and cap is %d \n", len(newSlice1), cap(newSlice1))
	

	fmt.Println("-------------------------------------------------")		

	fmt.Println(slice)

	var s []int //注意和数组的区别，数组必须制定长度[10]或者[...]

	fmt.Println(s == nil)

	array := [10]int{}

	fmt.Println(array)

	ss := array[0:len(array)]
	sss := array[0:9]
	fmt.Println(ss)
	fmt.Println(sss)

	fmt.Println(cap(sss))
	fmt.Println(len(sss))

	sss = append(sss, 18)
	sss = append(sss, 18)
	sss = append(sss, 18)

	fmt.Println(append(sss, 1000))

	fmt.Println(sss)
	fmt.Println(cap(sss)) //-->20
	fmt.Println(len(sss)) //-->12

}
