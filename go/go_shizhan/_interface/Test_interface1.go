package main

import "fmt"

type Connecter interface {
	Connect()
}
type Usb interface {
	Name() string
	Connecter
}

type Phone struct {
	name string
}

func (phone Phone) Name() string {
	return phone.name
}
func (phone Phone) Connect() {
	fmt.Printf("the phone %s is Conntion! \n", phone.name)
}

type TV struct {
	name string
}

func (tv TV) Name() string {
	return tv.name
}
func (tv TV) Connect() {
	fmt.Println("tv connect")
}

// 创建了Phone  和 TV 的 两种类型，实现了 Usb 接口
func DisConnect(usb Usb) {
	if pc, ok := usb.(Phone); ok {
		fmt.Println(pc.name)
	}
	fmt.Println(usb.Name() + " was disconnect!")
}

func DisConnect1(usb interface{}) {
	switch v := usb.(type) {
	case Phone:
		fmt.Println(v.name)
	case TV:
		fmt.Println(v.name)
	default:
		fmt.Println("this is default")
	}
}

func main() {
	var a Usb
	a = Phone{name: "IPHONE XR"}
	a.Connect()
	DisConnect1(a)

}
