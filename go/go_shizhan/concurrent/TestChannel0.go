package main 

import(
	"fmt"
)

func main(){
	// buffered := make(chan string , 10)
	
	// buffered <- "test1"
	// buffered <- "test2"
	// value := <- buffered
	// fmt.Println(value)

	unbuffered := make(chan int )
	unbuffered  <- 1
	unbuffered  <- 2
	value2 := <- unbuffered
	fmt.Println(value2)


}