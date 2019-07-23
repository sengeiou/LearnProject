#  操作文件

Path 和 Files 是在 Java 1.7 后新添加的类，用起来比 1.0 的 File 要方便很多。




## Path
Path 表示一个目录名序列，其后面还可以跟一个文件名。 路径中的第一个部件可以是根部件，例如 /  或 C:/ ，以根部件开始的路径是绝对路径，否则就是相对路径，

比如：

```
Path absolute = Paths.get("/home","cay");
Path relative = Paths.get("xx","yy","user.properties");

```
 静态的 Paths.get 方法接受一个或多个字符串，并将它们用默认的文件系统分隔符链接（window 或 Linux ）, 如果路径不存在，就抛出错误


 java.nio.file.Paths
 java.nio.file.Path

 Path 在 java.nio.file 包下 ,  为了能够和遗留的 api 交互， Path 类有一个 toFile 的方法， 而 File 类也有一个 toPath 的方法

 

# FILE 读取文件

Files 类可以使得普通文件操作变得快捷。

例如：

```
// 超级方便
byte[]  bytes = Files. readAllBytes(path);

// 超级方便
List<String> mList = Files.readAllLines(Path path,
                        Charset cs);

// 太多方便的方法了

```


