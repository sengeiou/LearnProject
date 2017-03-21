# 对象流与序列化

Java 语言支持一种称为 对象序列化 (obejct serialization) 的非常通用的机制, 它可以将任意对象写到流中， 并在之后将其读回。

使用 ObjectOutputStream 来将对象写到流中

> 查看代码 ObjectOutputStreamTest.java




## 理解对象序列化的文件格式

对象序列化是以特殊的文件格式存储对象数据的 .

每个文件都是以 下面这两个字节开始
```
ac ed   
```

然后就是对象序列化格式的版本号
```
00 05

```


有点复杂，总结了下知识点：

* 对象流输出中包含所有对象的类型和数据域
* 每个对象都被赋予一个序列号
* 相同的对象重复出现将被存储为这个对象的序列号的引用



## 修改默认的序列化机制 
某些数据是不可以序列化的，那么这类数据就需要被标记成 transient ，类也是这样。

序列化机制为单个的类提供了一种方式，去向默认的读写行为添加验证或任何其他想要的行为，可序列化的类可以定义具有下列签名的方法

```
private void readObject(InputStream in) throws IOException ,ClassNotFoundException

private void writeObject(OutputStream out) throws IOException

```

之后，数据域就再也不会被自动化序列，取而代之的是调用这些方法

开发者可以给某个变量加上 transient 的修饰，然后重写 readObject  和 writeObject 
> 查看ChangeDefualtSerializ 下的代码，查看怎么重写这两个方法




##序列化单例和类型安全的枚举

在序列化和反序列化时，如果目标对象是唯一的, 那么久要小心处理了，通常这类问题会出现在单例和类型安全的枚举时发生。

如果使用 enum 结构，则不需要担心这个问题

但是看下面的代码  base/IO&Stream/singleton 下


## 版本管理  



sjdhfjsdhf
序列化单例和类型安全的枚举  还有文字描述要补全下