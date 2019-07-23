package main

import (
	"fmt"
	"runtime"
	"sync"
)

func main() {

	runtime.GOMAXPROCS(1)

	var wg sync.WaitGroup

	wg.Add(2)

	fmt.Println("start....")

	go func() {
		defer wg.Done()
		for i := 0; i < 100; i++ {
			fmt.Println(i)
		}
	}()

	go func() {
		defer wg.Done()
		for i := 100; i < 200; i++ {
			fmt.Println(i)
		}
	}()

	fmt.Println("wait")
	wg.Wait()
	fmt.Println("end...")

}
