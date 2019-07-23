package main

import (
	"fmt"
)

type Singer interface {
	Singing() string
	Personer
}

type Personer interface {
	Eat()
}

type User struct {
	id   int
	name string
}

func (user User) Singing() string {
	return user.name + " Singing"
}

func (user User) Eat() {
	fmt.Println("Im eating ")
}

/**
1  接口的定义一般用  type interface_name interface{} 申明   （interface_name用er结尾）
2  接口只有方法名字，没有具体实现
3  接口没有数据字段
4  接口可以嵌套在其他接接口中，嵌套的接口会有被嵌套接口的方法
5. 接口是一个或多个方法签名的集合
6. 在实现方法的时候，如果用的是指针接收者，那么初始化是必须要做取地址，不然在	recycle(user) 方法中会出错
7. 在recycle 方法中，做接口的强转  per.(User)   interface.（接受者） ，见46行
*/

func main() {
	user := User{1, "shenjun"}
	fmt.Println(user.Singing())
	recycle(user)
  recycle1(user)



  // 把user 强转成 Personer接口
  var a  Personer
  a =  Personer(user)
  a.Eat();
//  fmt.Println(a.Singing())   由于a 已经是Personer类型了。所有他没有Singing的方法，这里会报错

}

func recycle(per Singer) {
	if user, ok := per.(User); ok {
		fmt.Print(user.name)
	}
	fmt.Println("has recycle")
}


// 这里测试空接口，go 语言中，任何类型都实现了空接口
func recycle1(per interface{}) {
      switch v:= per.(type){
      case User:
        	fmt.Println(v.name + "has recycle")
      default:
        fmt.Println("-----")

      }
}
