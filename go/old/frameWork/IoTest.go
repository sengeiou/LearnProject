package main

import (
	"fmt"
	"io"
	"io/ioutil"
	"os"
)

func main() {
	// copy()
	copyN()
	// readDIR()
}

func copy() {
	readFile, _ := os.Open("errors.go")       //读取文件
	writeFile, _ := os.Create("test_out.txt") //创建文件
	size, err := io.Copy(writeFile, readFile) //把readFile的内容写到writeFile中 ,返回读的字节数和错误码
	if err == nil {
		fmt.Println("method copy ", size)
	}
}

func copyN() {
	file, _ := os.Open("errors.go")
	wFile, _ := os.Create("test_out1.txt")
	io.CopyN(wFile, file, 10) //比Copy多加了一个读取数的限制

	b, err := ioutil.ReadFile("test_out1.txt")
	if err == nil {
		fmt.Println(b)
	}
}

func readDIR() {
	//读取文件夹下的子文件
	dirs, err := ioutil.ReadDir("./")
	fmt.Println(len(dirs))
	if err == nil {
		for k, v := range dirs {
			fmt.Println(k, "=", v.Name()) //文件或目录或
			fmt.Println(v.IsDir())        //是否是目录
		}

	}

}
