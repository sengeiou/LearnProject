package main


import(
  "fmt"
)

type stringer interface{
    String() string
}

type User struct {
    id int
    name string
}


func (user *User) String() string{
    return "123"
}

/**



类型可以实现多个接口
空接口 interface{}

*/
func main(){
      user := User{1,"shenjun"}
      fmt.Print(user.String())
}
