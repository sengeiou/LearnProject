package main

import (
	"fmt"
)
//https://www.jianshu.com/p/24ede9e90490
func main() {
	channel1 := make(chan bool, 10)

	go func() {
		//time.Sleep(time.Duration(2) * time.Second)
		fmt.Println("start send")
		channel1 <- true
		fmt.Println("end send")

	}()
	//time.Sleep(time.Duration(2) * time.Second)
	//fmt.Println(<-channel1)
	fmt.Println("exit")


	// channel 分 无缓冲 和有缓冲（区别在与无缓冲的初始化时没有第2个参数）
	// 无缓冲  make(chan int)     有缓冲  make(chan int, 10)

	//从无缓存的 channel 中读取消息会阻塞，直到有 goroutine 向该 channel 中发送消息；
	//同理，向无缓存的 channel 中发送消息也会阻塞，直到有 goroutine 从 channel 中读取消息。

	//有缓存的 channel 类似一个阻塞队列(采用环形数组实现)。
	//当缓存未满时，向 channel 中发送消息时不会阻塞，当缓存满时，发送操作将被阻塞，直到有其他 goroutine 从中读取消息；
	//相应的，当 channel 中消息不为空时，读取消息不会出现阻塞，当 channel 为空时，读取操作会造成阻塞，
	//直到有 goroutine 向 channel 中写入消息。


}
