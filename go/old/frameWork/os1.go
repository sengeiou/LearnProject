package main

import (
	"fmt"
	"os"
)

//http://www.widuu.com/archives/12/908.html
func main() {
	error := os.Chdir("C:/Users/Administrator/")
	if error != nil {
		fmt.Print(error)
	}
	os.Create("11123.txt")

}
