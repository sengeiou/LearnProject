package main

import (
	"fmt"
	"os"
)

func main() {

	fmt.Println(os.PathListSeparator)

	dir := os.Getenv("GOPATH") // 获取gopath
	cDir, _ := os.Getwd()      // 获取当前路径
	fmt.Println(dir)
	fmt.Println(cDir)
	//http://www.widuu.com/archives/12/913.html

	fileinfo, errs := os.Stat("test.go") //读取文件，返回FileInfo
	if errs == nil {
		fmt.Println(fileinfo.Size())
	}
	_, err := os.Open("errors.go")
	if err == nil {
		fmt.Println(err)
	}

	file, fErr := os.Create("create.txt") //创建文件

	if fErr != nil {
		fmt.Println(file, fErr)
		return
	}

	file.WriteString("hello.world") // 写入文件内容
	//关闭文件，否则无法删除

	readFile, rErr := os.Open("create.txt")

	if rErr != nil {
		return
	}

	buf := make([]byte, 1024)
	for {
		n, _ := readFile.Read(buf) //读取文件
		if 0 == n {
			break
		}
		os.Stdout.Write(buf[:n])
	}

	file.Close()
	readFile.Close()

	removeErr := os.Remove("create.txt") //删除文件
	if removeErr != nil {
		fmt.Println(removeErr)
	}

}
