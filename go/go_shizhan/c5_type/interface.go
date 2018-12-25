package main

import "fmt"

type Teacher struct{
	name string
}

// 创建interface
type notifier interface {
	notify()
}
// 实现接口
// 这里要注意下，(t Teacher) 和 (t *Teacher) 的区分，如果传递错误，是会报错的
func (t Teacher) notify(){
	fmt.Println(t.name)
}

// 真实的调用方法，接收一个notifier 的接口类型
func sendNoti(noti notifier){
	noti.notify()
}


func main(){
	teacher := Teacher{name:"cocoa"}
	sendNoti(teacher)
}

