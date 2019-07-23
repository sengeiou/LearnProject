package main

import (
	"fmt"
	"math/rand"
	"sync"
)

var channelWg1 sync.WaitGroup


func main(){

	// 无缓存通道的基本使用

	court1 := make(chan int )

	channelWg1.Add(2)

	go player("cocoa",court1)
	go player("tom", court1)

	court1 <- 1

	channelWg1.Wait()
}

func player(name string, court chan int){

	defer channelWg1.Done()

	for{
		ball ,ok := <-court
		if !ok {
			fmt.Printf("player %s won\n",name)
			return
		}

		n := rand.Intn(100)
		if n%13 ==0 {
			fmt.Printf("player %s missed\n",name)
			close(court)
			return
		}


		fmt.Printf("player %s hit %d \n", name , ball)

		ball++

		court <- ball

	}


}