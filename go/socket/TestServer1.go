package main


import(
  "net"
  "fmt"
)

func main (){
  ln,err := net.Listen("tcp", ":8080")

  if err != nil {

  }

  for {
      conn,acceptError := ln.Accept()
      if acceptError !=  nil{

      }
      go handleConnection(conn)
  }
}


func handleConnection(conn net.Conn){
    addr := conn.RemoteAddr()
    fmt.Println(addr.String())  // 打印请求者的ip 地址

    conn.Write([]byte("123"))
    conn.Close()
}
