package main

import (
	"fmt"
	"os"
)

func main() {
	fmt.Println(1)
	// s := "1234576"

	// size := len(s)

	// for i := 0 ; i< size ; i++{
	// 	fmt.Println(s[i])

	// }
	b := true
	fmt.Printf("%t", b)

	file, err := os.Open("test.go")

	if err != nil {
		fmt.Print(err)
	}

	data := make([]byte, 1024)
	count, _ := file.Read(data)
	os.Stdout.Write(data[:count])

	file1, _ := os.Create("111111.go")

	file1.Write(data)

	os.NewFile(file.Fd(), "12222.go")

}
