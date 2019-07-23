package main

import "fmt"

func main(){

	unbuffered := make(chan string)
	buffered := make(chan int,10)

	fmt.Println(unbuffered)
	fmt.Println(buffered)

	buffered <- 12

	value := <-buffered

	fmt.Println(value)


}