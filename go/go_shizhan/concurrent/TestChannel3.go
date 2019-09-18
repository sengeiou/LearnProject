package main

import(
	"fmt"
	"math/rand"
	"sync"
	// "time"
)

var wg sync.WaitGroup

func main(){
	court := make(chan int)
	wg.Add(2)
	go player("tom",court)
	go player("cocoa",court)

	court <- 1
	wg.Wait()
}


func player(name string ,court chan int){
	defer wg.Done()
	for {
		ball ,ok := <- court
		if !ok{
			fmt.Printf("Player %s won.",name)
			return 
		}	
		n := rand.Intn(100)
		if n%13 == 0{
			fmt.Printf("player is missed %s \n", name)
			close(court)
			return 
		}
		fmt.Printf("PLayer %s hit %d \n",name, ball)
		ball++

		court <- ball
	}

}