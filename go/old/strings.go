package main

import (
	"fmt"
	"strings"
)

func main() {
	s := "sprots yeah"
	fmt.Println(strings.HasPrefix(s, "xx"))

	ss := "Hello-World-Hello"
	fmt.Println(strings.Contains(ss, "llo"))

	fmt.Println(strings.Index(ss, "llo"))

	fmt.Println(strings.LastIndex(ss, "llo"))

	fmt.Printf("count %d\n", strings.Count(ss, "llo"))

	UpCase := strings.ToUpper(ss)
	fmt.Printf(" upper case ss %s\n", UpCase)

	lowerCase := strings.ToLower(UpCase)
	fmt.Printf(" upper case ss %s\n", lowerCase)

}
