package main

import(
  "fmt"
)


func main(){
  name := ""
  var aa string
  fmt.Println( "please enter something" )
  fmt.Scanln(&name,&aa)


  fmt.Println(aa)
  fmt.Println(name)
}
