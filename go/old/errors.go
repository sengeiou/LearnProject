package main

import (
	"errors"
	"fmt"
)

func test(a int) (int, error) {
	if a == 12 {
		return a, errors.New("null point exception")
	}

	return a, nil
}

func main() {
	err := errors.New("null point exception")
	if err != nil {
		fmt.Println(err)
	}

	a, err := test(12)
	if err != nil {
		fmt.Println(a)
	}

}
