package main

import (
	"fmt"
	"sync"
	"runtime"
)

var counter int 
var wg sync.WaitGroup


func main(){

	numCPU := runtime.NumCPU
	fmt.Printf("%d",numCPU)

	wg.Add(2)

	go incCounter(1)
	go incCounter(2)

	wg.Wait()
	fmt.Println("finale counter :", counter)

}

func incCounter(id int){
	defer wg.Done()

	for index := 0; index < 2; index++ {
		value := counter
		runtime.Gosched()
		value++
		counter = value
	}

}

