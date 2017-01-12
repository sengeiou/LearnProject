package main

import (
	"fmt"
	"time"
)

// 比较难，放以后学习
/**
1,只需要在函数调用前加上go 关键字，就可以创建执行并发单元
2,入口的main 函数就以goroutine 运行


Channel
1. 用make()创建,close(channel)关闭， Chanel <- 赋值  ，<-Channel 取值
2. Channel 可以是双向通道，也可以是单向通道
3. Channel 是引用类型
4. Channel是goroutine沟通的桥梁, 大都是阻塞同步的
5. 可以用for range 来迭代不断操作channel
6. 可以设置缓存大小, 在未被填满前不会发生阻塞
*/
func main() {

	// demo1
	// go log()
	// for i := 0; i < 10; i++ {
	// 	time.Sleep(time.Second)
	// 	fmt.Println("---")
	// }

	//demo2
	channek := make(chan bool, 1)

	go func() {
		time.Sleep(time.Second * 2)
		channek <- true
	}()
	go func() {
		time.Sleep(time.Second * 2)
		channek <- true
	}()
	for v := range channek {
		fmt.Println(v)
	}

}

func log() {
	for i := 0; i < 10; i++ {
		time.Sleep(time.Second)
		fmt.Println(i)
	}
}
