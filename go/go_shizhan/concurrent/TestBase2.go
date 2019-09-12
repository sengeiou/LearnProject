package main

import (
	"fmt"
	"runtime"
	"sync"
)
var wg sync.WaitGroup

func main(){
	fmt.Println("app start")
	runtime.GOMAXPROCS(1)     // 试着改成2 
  	
	wg.Add(2)

	go print("a")
	go print("b")

	wg.Wait()
	fmt.Println("app is stoped!")

}


func print(tag string){
	defer wg.Done()
	for index := 0; index < 5000; index++ {
		for inner := 0; inner < index; inner++ {
			if inner % 2 == 0{
				
			}
		}
		fmt.Printf("%s:%d\n", tag, index)	
	}
	fmt.Println(tag+ " is complete!")
}