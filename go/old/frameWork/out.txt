package main

import (
	"errors"
	"fmt"
)

func main() {
	err := errors.New("null point exception")
	if err != nil {
		fmt.Println(err)
	}
}
