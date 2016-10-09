package main

import(
  "fmt"
  "test"
)



const(
  A int  = iota
  B
  C

)


func main(){
  name := ""
  var aa string
  fmt.Println( "please enter something" )
  fmt.Scanln(&name,&aa)


  fmt.Println(aa)
  fmt.Println(name)

  fmt.Printf("Hello, world.  Sqrt(2) = %v\n", test.Sqrt(2))

  fmt.Println(A,B,C)


}
