package main

import (
	"fmt"
)

/**
1. 接口就是描述了某种行为，是一种多态的表现
2.



*/
func main() {

	u := &user{"u", "u-email"}
	sendNotification(u)

	a := &admin{"a", "a-email"}
	sendNotification(a)
}

func sendNotification(n notifier) {
	n.notify()
}

type notifier interface {
	notify()
}

type user struct {
	name  string
	email string
}

func (u *user) notify() {
	fmt.Println(u.name, u.email)
}

type admin struct {
	name  string
	email string
}

func (a *admin) notify() {
	fmt.Println(a.name, a.email)
}
