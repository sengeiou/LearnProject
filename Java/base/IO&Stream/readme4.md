# ZIP 文档

ZIP文档以压缩格式存储一个或多个文件，每个 ZIP 文档都有一个头，包含诸如每个文件名字和所使用的压缩方法等的信息。

在 Java 中，可以使用 ZipInputStream 来读取 ZIP 文档。


```
		ZipInputStream zipStream = new ZipInputStream(new FileInputStream("test.zip"));

		ZipEntry mZipEntry ;

		while((mZipEntry = zipStream.getNextEntry())!= null){
			// 会遍历每一个目录
			System.out.println(mZipEntry.getName());
		}
```


> 查看具体代码  ZipInputStreamTest.java


```
// 常用API

java.util.zip.ZipInputStream

ZipInputStream(InputStream in)
ZipEntry getNextEntry() //返回下一个ZipEntry ，没有则返回null
void closeEntry()  //关闭这个ZIP文件中之前打开的项，之后可以通过getNextEntry 读入下一项


java.util.zip.ZipOutputStream

ZipOutputStream(OutputStream out)
// 将给定的 ZipEntry信息写到流中，并定位用于写数据的流，然后数据可以通过 write 写到流中
void putNextEntry(ZipEntry ze)
// 和上面一致
void closeEntry()
// 设置后续的各个 DEFLATED 项的默认压缩级别。
void setLevel(int level)
// 设置默认压缩方法，这个压缩方法会作用于所有没有指定压缩方法的项上. method=  DEFLATED  STRORED
void setMethod(int method)



java.util.zip.ZipEntry
// 用指定的名字构建 一个 Zip 项
ZipEntry(String name)

// 返回用于这个 ZipEntry 的 CRC32 校验和的值
long getCrc();

//返回这一项的名字
String getName()

//返回这一项未压缩的尺寸，或在未压缩的尺寸不可知的情况下返回 -1
long getSize()

//这一项是否是目录
boolean isDirectory()

//设置这一项的压缩方式, 必须是 DEFLATED 或 STROED
void setMethod(int method)


```