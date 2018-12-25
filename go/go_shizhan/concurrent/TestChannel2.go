package main

import "fmt"

func main() {

	ch := make(chan int, 10)
	ch <- 11
	ch <- 12

	close(ch)


	// channel 的遍历
	for x := range ch {
		fmt.Println(x)
	}

	if x,ok := <- ch ; ok{
		fmt.Println(x)
	} else {
		fmt.Println("this ok is false!")
	}


}
