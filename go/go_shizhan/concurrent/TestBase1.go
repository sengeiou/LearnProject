package main

import (
	"fmt"
	"runtime"
	"sync"
)

func main(){
	runtime.GOMAXPROCS(1)
	var wg sync.WaitGroup 
	wg.Add(2)

	fmt.Println("Hello")

	go func(){

		defer wg.Done()
		for index := 0; index < 3; index++ {
			for char := 'a' ; char < 'a'+26 ; char ++{
				fmt.Printf("%c",char)	
			}
		}
		fmt.Println()
	}()

	go func (){
		defer wg.Done()
		for index := 0; index < 3; index++ {
			for char := 'A' ; char < 'A'+26 ; char ++{
				fmt.Printf("%c",char)	
			}
		}
		fmt.Println()

	}()

	fmt.Println("app is waiting")	
	wg.Wait()
	fmt.Println("app is stoped")	

}