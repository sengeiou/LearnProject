package main


import(
  "net"
  "io/ioutil"
  "fmt"
)

const(
   SERVER string = ":8080"

)

func main(){
  tcpAddr, _ := net.ResolveTCPAddr("tcp", SERVER)

  conn,_ := net.DialTCP("tcp", nil, tcpAddr)

  msg,_ := ioutil.ReadAll(conn)

  fmt.Println(string(msg))

}
