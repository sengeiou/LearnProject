package main

import (
	"fmt"
	"reflect"
)

type User struct {
	id   string
	name string
	age  int
}

func (u User) Hello() {
	fmt.Println("Hello");
}

func Info(inter interface{}) {
	t := reflect.TypeOf(inter)
	fmt.Println(t.Name())

	v := reflect.ValueOf(inter)
	fmt.Println(v.Type())
	fmt.Println("Fields:")

	for i := 0; i < t.NumField(); i++ {
		f := t.Field(i)
		//val := v.Field(i).Interface()
		fmt.Printf("%6s=%v=%v", f.Name, f.Type)
	}

	fmt.Println("\nMethods:")

	for i := 0; i < t.NumMethod(); i++ {
		m := t.Method(i)
		fmt.Println(m.Name)
		fmt.Println(m.Type)
		fmt.Println(m.Func.String())
	}

}

func main() {
	user := User{
		name: "cocoa",
		age:  30,
		id:   "2410",
	}
	Info(user)

}
