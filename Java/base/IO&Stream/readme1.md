# 流与文件 
> 参考《java 核心技术 卷2 高级特性》


## 流
在 Java 中， 可以从其中读入一个字节序列的对象称为输入流, 可以向其中写入一个字节序列的对象称为输出流, 这些字节序列可以是从文件，也可以从网络连接，也可以是从内存中而来.

抽象类 InputStream 和 OutputStream 就是输入 和 输出的基础 ，主要用来处理 字节流.
抽象类 Reader 和 Writer 则是用来处理 Unicode 字符的基础.


### 读写字节

```
	// InputStream 的抽象方法
	abstract int read();
	// 这个方法将读取一个字节，并返回读入的字节，在遇到文件结尾时返回-1
	
```

以此类推
```
	// OutoutStream 的抽象方法
	abstract int write( int b );
	// 这个方法将向某个输出位置写出一个字节
	
```

read 和 write 方法在执行时都会阻塞， 直到字节被确实的读入和写出， 

available 方法可以检测当前可读入的字节数量.

close 方法，如果你完成对流的读写，那么就需要调用 close 方法去关闭流，释放有限的操作系统资源。

```
// InputStream API 

// 读入一个字节数组，并返回实际读入的字节数
public int read(byte b[]) throws IOException 
{   // 重载了read 方法，默认是读满这个byte 数组 b 
	return read(b, 0, b.length);
}


//读入一个字节数组，并返回实际读入的字节数   off 第一个读入字节应该被放置在b的哪个位置  len 读入字节的最大数量
public int read(byte b[], int off, int len) throws IOException


// 在输入流中跳过 n 个字节，返回实际跳过的字节数（如果碰到流的结尾，则可能小于 n ）
long skip(long n)


// 返回在不阻塞的情况下可获取的字节数， 
int available()

void close()

//在输入流的当前打一个标记( 并不是所有流都支持 ) 如果从输入流中已经读入的字节多于 readlimit个，则这个流允许忽略这个标记。
void mark(int readlimit)

//返回到最后一个标记
void reset()

// 如果支持这个流打标记，就返回 true
boolean markSupported()

```

```
// OutputStream API 

void write(byte[] b)

//写出所有的字节或某个范围的字节到数组中
void write(byte[] b , int off ,int len)

//冲刷并关闭输出流
void close()

// 冲刷数据流，将缓冲的数据发送到目的地
void flush()


```


java IO 中的 4个接口
1. Closeable    几乎所有的流都实现了
2. Flushable    输出流实现
3. Readable     输入流实现
4. Appendable   只有 Writer 实现了





### 组合流过滤器
FileInoutStream 和 FileOutputStream  是操作文件的输入流和输出流

FileInoutStream fin = new FileInputStream("xxx.txt");

> 所有在java.io 中的类都将相对路径名解释为以用户工作目录开始，可以通过 System.getProperty("user.dir") 来获取这个信息。

我们只能从 fin 对象中 读取字节和字节数组

```
	byte b = (byte)fin.read();
```
 如果我们只有 DataInputStream, 那么就只能读取数值类型：

```
	DataInputStream din = null
	double d = din.readDouble();
```

Java 使用了一个很灵巧的机制来分离这两种职责，某些流和从文件上获取字节，某些流可以将字节组装成别的数据类型，你可以将两种流进行组合来

比如：
```
	FileInputStream fin  = new FileInputStream("xxx.txt");
	DataInputStream din  = new DataInputStream(fin);
	double d = din.readDouble();

```

又比如：

```
//流在默认情况下是不带缓冲的，也就是说，没个对read 的调用都会请求操作系统在分发一个字节。相比之下，请求一个数据块并放到缓冲区会比较高效，
//这个例子就是使用了缓冲区的流
DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("xxx.txt")));

```



```
常用 API

FileInputStream  

FileInputStream(String name)
FileInputStream(File file)



FileOutputStream

FileOutputStream(String name)
// append 为true ，数据将添加在文件的末尾（不会删除相同名字的已有文件），否则，这个方法会删除所有具有相同名字的已有文件
FileOutputStream(Strin name , boolean append)
FileOutputStream(File file)
FileOutputStream(File file , boolean append)


BufferedInputStream

//创建一个带缓冲区的流，带缓冲区的输入流在流中读取时，不会每次都对设备方法。当缓冲区为空时，会向缓冲区读入一个新的数据块。 
BufferedInputStream(InputStream in)


BufferedOutputStream
//带缓冲的输出流在收集要写出的字符时，不会每次都会设备访问。当缓冲区填满或被flush 时，数据就被写出
BufferedOutputStream(OutputStream out)


```








