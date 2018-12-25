package main

import (
	"fmt"
	"runtime"
	"sync"
)

func main() {

	// runtime 包 提供了修改go 语言运行时配置参数的能力
	fmt.Println(runtime.NumCPU())

	//runtime.GOMAXPROCS(runtime.NumCPU())

	runtime.GOMAXPROCS(2)   // 和上一例子不一样，这里把逻辑处理器的数量改为2


	// 在这个例子中，发现goroutine 是并行运行的，所以会出现大小写字母混在一起的情况

	var wg sync.WaitGroup
	wg.Add(2)

	fmt.Println("start goroutines")

	go func() {
		defer wg.Done()

		for count := 0; count < 3 ; count++{
			for char:= 'a'; char< 'a'+26; char++{
				fmt.Printf("%c",char)
			}
			fmt.Println("")
		}
	}()
	go func() {
		defer wg.Done()

		for count := 0; count < 3 ; count++{
			for char:= 'A'; char< 'A'+26; char++{
				fmt.Printf("%c",char)
			}
			fmt.Println("")
		}
	}()

	fmt.Println("wait finish")

	wg.Wait()


	fmt.Println("terminating finish")




}
