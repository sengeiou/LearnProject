package main

import (
	"fmt"
	"time"
)

var c chan int

func main() {
	c = make(chan int)
	go gogo(2)
	go gogo(3)
	fmt.Println(<-c)
	fmt.Println(<-c)
}

func gogo(sec int) {

	time.Sleep(2 * time.Second)
	fmt.Println("--end")
	c <- sec
}
