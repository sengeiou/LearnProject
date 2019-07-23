package main


import(
  "fmt"
)

/**

inputReader :=  bufio.NewReader(file)

NewReader的参数是io.Reader  但是可以传入 os.file 对象

就写了个例子

关于接口的不理解的地方，写个例子

*/



type Person interface{
  getMsg() string
}

type PP struct {
  Name string
}

func (p PP) getMsg() string{
    return p.Name
}

func main (){
      pp := PP{"shenjun"}
      test(pp)
}

func test(p Person){
    fmt.Println(p.getMsg())
}
