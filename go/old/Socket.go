package main

import (
	"bufio"
	"fmt"
	"net"
)

func main() {

	ln, err := net.Listen("tcp", ":8080")
	if err != nil {
		// handle error
	}
	for {
		conn, err := ln.Accept()
		if err != nil {
			// handle error
		}
		go handleConnection(conn)
	}

}

func handleConnection(conn net.Conn) {

	addStr := conn.RemoteAddr().String()
	fmt.Printf(addStr + "----start---")
	// fmt.Printf(conn.RemoteAddr().String())
	data, err := bufio.NewReader(conn).ReadString('\n')
	if err != nil {
		// log.Fatal("get client data error: ", err)
	}

	fmt.Printf(addStr + "----end---")
	fmt.Printf("%#v\n", data)
	fmt.Fprintf(conn, "hello client\n")
	conn.Close()
}
