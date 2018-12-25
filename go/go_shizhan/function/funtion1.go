package main

import (
	"fmt"
	"reflect"
)

func main() {
	A(1)
	B(1, 2, 3)
	C(1, 2, 3)
	D(1, 2, 3)

	e := func() {
		fmt.Println("function e")
	}
	e()


	c1 := closure(10);
	re := c1(11);
	fmt.Printf("the result is %d \n",re)


	for i := 0; i < 3; i++ {   //  输出都是3
		defer func() {
			fmt.Println(i)
		}()
	}


	panicFunc()

}

func A(a int) {
	fmt.Println(a)
}

func B(a, b, c int) {
	fmt.Println(a + b + c)
}

func C(a, b, c int) (e, d, g int) {
	return a, b, c
}
func D(a ... int) {
	fmt.Println(reflect.TypeOf(a))
}

func closure(a int) func(b int) int {
	return func(b int) int {
		return a + b
	}
}


func panicFunc(){
	defer func(){
		if err := recover(); err != nil{
			fmt.Println(err)
		}
	}()
	panic("find panic!!")

}