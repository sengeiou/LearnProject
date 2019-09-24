package main

import (
	"fmt"
)

/**
go 数组
数组的申明， var identifier [len]type    for example  var placeArray [5]string
2.在go 语言中,数组长度是数组类型的一部分，也就是说，[3]int 和 [2]int 是两种类型
3. 数组的字面值初始化中，可以用[...] 表示用具体的字面值的个数来初始化数组长度
*/

type TYPE int

const  (
	T1 TYPE = iota
	T2
	T3
)


func main() {

	fmt.Printf("the t3 is %d \n", T3)

	var a1 [2]int 
	fmt.Println(a1)

	a2 := [...]int{1,2,3,4}
	fmt.Println(a2)

	var a3 [2]string = [2]string{"a3-0","a3-1"}
	fmt.Println(a3)

	for index, value := range a2 {
		fmt.Printf("%d--%d ",index,value )
	}
	fmt.Println("")
	fmt.Printf("the a2 length is %d \n",len(a2))
	
	//定义一个长度为4的int 数组
	var emeintArray [4]int //数组的定义1

	// 输出为[0,0,0,0]
	fmt.Println(emeintArray)

	a := [...]int{1, 1, 1}    //数组的定义2
	var b = [10]int{1, 2}     //数组的定义3
	var cc = [...]int{10: 10} //创建数组，第11位为10 别的都为int 初始值 ,数组长度为10

	fmt.Println(a)  // 输出为[1,1,1]
	fmt.Println(b)  // 输出为[1,2,0,0,0,0,0,0,0,0]
	fmt.Println(cc) // 输出为 [0 0 0 0 0 0 0 0 0 0 10]

	//test2(a)   这里不能这么调用  : cannot use a (type [3]int) as type [10]int in argument to test2

	test2(b) // 这样就可以使用，参数和形参的类型是一致的

	c := []int{1, 2, 3}

	test1(c) // 这样也是可以的

	//遍历数组1
	for i := 0; i < len(b); i++ {
		fmt.Printf("%d---",b[i]);
	}

	//遍历数组2
	for index, value := range b {
		fmt.Println(index, value)
	}

	var t1 = [2]int{1, 2}
	var t2 = [2]int{1, 2}

	fmt.Println(t1 == t2) //输出为true

	// other day

	aaa := [2]int{1, 1}

	fmt.Println(aaa)

	bbb := [2]int{1: 2}

	fmt.Println(bbb)

	// test1(aaa)
	// test2(aaa)

}

//定义方法的型参数

func test1(array []int) {

}

func test2(array [10]int) {

}
