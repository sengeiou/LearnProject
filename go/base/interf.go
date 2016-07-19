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


func main(){
      user := User{1,"shenjun"}
      fmt.Print(user.String())
}
