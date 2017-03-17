# 读写 二进制数据


DataOutput 接口定义了以二进制格式写数组，字符，boolean 和字符串的方法

比如：
writeInt 总是将以个证书写出为4个字节的二进制数量值， 而不管它有多少位,
writeDouble 总是将以个double 值写出为 8字节的二进制数量值，这样产生的结果并非人可阅读，但是对于给定类型的每个值，所需的的空间都是相同的，而且将其读回也比解析文本要快.


writeUTF 方法使用修订版的8位 Unicode 转换格式写出字符串.




## 随机访问文件
RandomAccessFile 类可以在文件中的任何位置查找或写入数据.
磁盘文件都是随机访问的, 但是从网络而来的数据流缺不是。

```
	// 第2个参数 “r”  只读   “rw” 可读可写
	RandomAccessFile in = new RandomAccessFile("xx.txt","rw");

```

随机访问文件有一个表示下一个将被读入或写出的字节所处位置的文件指针，
seek 方法可以将这个文件指针设置到文件的任意字节位置( 参数是一个long 类型，取值范围是0 到 文件的的长度)


```
// mode "rwd" 表示每次更新时，只对数据的写磁盘操作进行同步的读/写模式
RandomAccessFile(String file ,String mode)
RandomAccessFile(File file ,String mode)


//返回文件指针当前的位置
long getFilePointer();

//当文件指针设置到距文件开头 pos 个字节处
void seek(long pos)

// 返回文件按照字节来度量的长度
long length()

```
> 查看代码 RandomAccessFileTest.java




