package main

import (
	"fmt"
	"sync"
)

var (
	counter1 int64
	wg1 sync.WaitGroup
	mutex1 sync.Mutex
)

func main() {
	wg1.Add(2)

	go incCounter1(1)
	go incCounter1(2)


	wg1.Wait()
	fmt.Printf("final counter %d",counter1)

}


func incCounter1(id int){
	defer wg1.Done()

	for count:=0;count<6 ; count++ {

		mutex1.Lock()
		{
			value := counter1

			counter1 = value + 1

		}

		mutex1.Unlock()
	}

}
