package main

import (
	"fmt"
	"time"
)

/**

1。channel 是goroutine沟通的桥梁，大都是阻塞同步的
2。通过make创建，close 关闭  close(channel c)
3。channel是引用类型
4。channel 可以用for range 来迭代操作
5。channel 可以设置成单双向通道，单通道又分为只读，只写两种
6。可以设置缓存大小，在为被填满前不会发生阻塞
7。有缓存是异步的，无缓存是同步的



*/

func main() {
	c := make(chan bool)
	go func() {
		time.Sleep(2 * time.Second)
		fmt.Println("123")
		c <- true
		close(c)
	}()

	for v := range c {
		fmt.Println(v)
	}

}
