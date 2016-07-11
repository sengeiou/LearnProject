package main


/**
1.



*/

import (
	"fmt"
)


type Books struct{


title string
author string
id    int

}

func main(){

var book1 Books


book1.title = "Go struct"
book1.author = "shenjun"


fmt.Print(book1.title)


}
