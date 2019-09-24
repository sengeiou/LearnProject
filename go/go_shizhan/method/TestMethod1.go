package main

import "fmt"

type User struct{
	name string
	email string
}

func (u User)  notify(){
	fmt.Println(u.name)
}

func (u *User) changeName(name string){
	 u.name = name;
}

func main(){
	u := &User{name:"u", email:"u@qq.com"}
	u.changeName("changedName")
	u.notify()

	fmt.Println("---------")

	u1 := User{name:"u1", email:"u1@qq.com"}
	u1.changeName("changedName")
	u1.notify()

}


