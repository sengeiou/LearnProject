# 文本的输入与输出





##  如何写出文本输出

对于文本输出，可以用PrintWriter ，这个类拥有以文本格式打印字符串和数字的方法

```
	PrintWriter out = new PrintWriter("xxx.txt");
	PrintWriter out = new PrintWriter(new FileWriter("xxx.txt"));

```

> 详细代码查看 printWriterTest.java





## 如何读入文本输入

* 以二进制格式写出数据，需要使用 DataOutoutStream
* 以文本格式写出数据，需要使用PrintWriter

在 Java SE 5.0之前，处理文本输入的唯一方式就是通过 BufferedReader 类， 它拥有一个readLine 的方法, 使得我们可以读取一行文本

```
	// 用组合模式
	BufferedReader in  = new BufferedReader(new InputStreamReader(new FileInputStream("xx.txt"),"UTF-8"));
	// readLine 方法在没有输入时返回 null
	String line ;
	while((line = in.readLine()) != null){
		System.out.println(line);
	}


```
> 详细代码查看 BufferedReaderTest.java



## 以文本格式存储对象

// 书中的代码不是很实用，自己创建了java 对象直接存储到文件中

> 详细代码查看 ObjectOutputStream.java



## 字符集
在 Java SE 1.4 中引入的 java.nio 包用Charset 类统一了对字符集的转换。

字符集建立了两字节 Unicode 码元序列与使用本地字符编码方式的字节序列之间的映射，