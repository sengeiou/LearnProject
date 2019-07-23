package main

import (
	"fmt"
	"strings"
)

/*
1.go语言使用8位来表示每一个字符
2
*/
func main() {

	// 两种初始化  :=   var
	str := "what's " + " your name ? " //这里注意。+ 号必须在第一行

	// test := "www"
	// +"123"   //加号在第二行，编译报错invalid operation: + untyped string

	test1 := "123" + //如果有多个+号，可以像test1这样处理
		"123" +
		"123"
	fmt.Println(test1)

	var str1 = "\"hahah\" " //转义输出双引号

	//testText := 'hah'    //错误的写法，只能用双引号

	fmt.Println(str)
	fmt.Println(str1)
	// fmt.Println(testText)

	fmt.Println(string(str[0])) // 输出字符段0位置的字符,用string()强转char

	fmt.Println(string(str[2:])) //输出位置2以后的所有字符

	fmt.Println(string(str[2:5])) //2-5

	fmt.Println(string(str[:2])) //0-2

	fmt.Println(len(str)) //获取字符串的长度

	strAarray := strings.Split(str, "y") //既然讲到string 这里就引入了strings的包。Split方法用来分隔字符串 ，返回一个字符数组
	// 在go语言中，split函数还设有很多变种，比如SplitN SplitAfter 等等，具体可以参考api文档  ，国人做的api搜索（https://gowalker.org），超级棒的工具
	fmt.Println(len(strAarray))
	fmt.Println(strAarray[0])

	// 遍历字符串
	for i := 0; i < len(str); i++ {
		fmt.Println(string(str[i])) //输出的byte，所以必须转成string
	}

}
