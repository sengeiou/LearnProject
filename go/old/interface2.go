package main

import (
	"fmt"
)

/**
http://www.cnblogs.com/hustcat/p/4007126.html
1


*/

type Person struct {
	name string
}

type Gamer interface {
	playing(toy string)
	stop()
}

func (p Person) playing(toy string) {
	fmt.Println(p.name + "--playing -" + toy)
}

func (p Person) stop() {
	fmt.Println("stop")
}

func main() {
	var p Gamer = Person{name: "cocoa"} //如果person 没有实现playing 和stop 方法，这样的向上转型则会出错，除非 var p Person = Person{name:"xx"}
	p.playing("toy")
	p.stop()

	//空接口 interface{}
	//理论上，所有数据都实现了空接口 ，可以查看fmt.Println(a.....interface{})
	var v1 interface{} = 1
	fmt.Println(v1, v1)

	//在Go语言中，我们可以使用type switch语句查询接口变量的真实数据类型
	/**
	type Stringer interface {
	    String() string
	}

	var value interface{} // Value provided by caller.
	switch str := value.(type) {
	case string:
	    return str //type of str is string
	case Stringer: //type of str is Stringer
	    return str.String()
	}

	*/

	// 或者还可以用 if else 判断
	if person, ok := p.(Person); ok {
		fmt.Println(person.name)
	}

}
