package main

/**
1 go 语言中, 文件的操作是在os 包中， os.File

*/
import(
"fmt"
"os"
"bufio"
)

func main(){
  file, error :=  os.Open("/Users/sj/Documents/myApp/LearmProject/go/123.txt");
  if error!= nil{
    fmt.Println(error)
  }
  defer file.Close()

  inputReader :=  bufio.NewReader(file)



  fmt.Println(file)

}
