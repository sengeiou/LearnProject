# Java Annotation

## 什么是注解?

注解主要提供一种机制，允许程序员在编写代码的同时可以直接编写元数据。

注解可以被用在包，类，方法，变量，参数上。从 Java8 起，有一种注解可以被放在代码的任何位置，叫类型注解。

被注解的代码并不会直接被注解影响.

注解会被编译至 class 文件中，而且会在运行时被处理程序提取出来用于业务逻辑。当然，创建在运行时不可用的注解也是可能的，甚至可以创建只在源文件中可用，在编译时不可用的注解.

包含注解的设计和开发的Java规范主要有以下两篇：

https://jcp.org/en/jsr/detail?id=250
https://www.jcp.org/aboutJava/communityprocess/final/jsr175/index.html


## 消费器
消费器是利用被注解代码根据注解信息产生不同行为的系统或者应用程序。

消费器使用 Java 中的反射机制来读取和分析被注解的源代码。


## 注解语法

声明一个注解需要使用“@” 作为前缀，意思是告诉编译器，这个是注解元素
```
@Annotation
public void annotationMethod(){
	
}
```

注解可以以键值对的形式持有很多属性，即注解的属性：

```
@Annotation(
	info = "this is annotation"
	count = "1"
)
public void annotationMethod(){
	
}
```

如果注解只包含一个元素，可以像这样声明
```
@Annotation("I am an annotation")
public void annotatedMehod() {

}
```


## 内建注解

* @Retention   这个注解注在其他注解上，并用来说明如何存储已被标记的注解。这是一种元注解，用来标记注解并提供注解的信息。可能的值是：
1. SOURCE   表明这个注解会被编译器忽略，并只会保留在源代码中
2. CLASS    表明这个注解会通过编译驻留在CLASS文件，但会被JVM在运行时忽略,正因为如此,其在运行时不可见
3. RUNTIME  表示这个注解会被JVM获取，并在运行时通过反射获取。


* @Target   这个注解用于限制某个元素可以被注解的类型。例如：
1.ANNOTATION_TYPE 表示该注解可以应用到其他注解上
2.CONSTRUCTOR 表示可以使用到构造器上
3.FIELD 表示可以使用到域或属性上
4.LOCAL_VARIABLE表示可以使用到局部变量上。
5.METHOD可以使用到方法级别的注解上。
6.PACKAGE可以使用到包声明上。
7.PARAMETER可以使用到方法的参数上
8.TYPE可以使用到一个类的任何元素上。

* @Documented  被注解的元素将会作为Javadoc产生的文档中的内容。注解都默认不会成为成为文档中的内容。这个注解可以对其它注解使用。


* @Inherited  在默认情况下，注解不会被子类继承。被此注解标记的注解会被所有子类继承。这个注解可以对类使用。


* @Deprecated  说明被标记的元素不应该再度使用。这个注解会让编译器产生警告消息。可以使用到方法，类和域上。相应的解释和原因，包括另一个可取代的方法应该同时和这个注解使用。


* @SuppressWarning  说明编译器不会针对指定的一个或多个原因产生警告。例如：如果我们不想因为存在尚未使用的私有方法而得到警告可以这样做：

* @Override  向编译器说明被注解元素是重写的父类的一个元素。在重写父类元素的时候此注解并非强制性的，不过可以在重写错误时帮助编译器产生错误以提醒我们。比如子类方法的参数和父类不匹配，或返回值类型不同。

* @SafeVarargs   断言方法或者构造器的代码不会对参数进行不安全的操作。在Java的后续版本中，使用这个注解时将会令编译器产生一个错误在编译期间防止潜在的不安全操作。


* @Repeatable(java 8 才有)  说明该注解标识的注解可以多次使用到同一个元素的声明上。

* @FunctionalInterface(java 8 才有)  这个注解表示一个函数式接口元素。函数式接口是一种只有一个抽象方法（非默认）的接口。编译器会检查被注解元素，如果不符，就会产生错误。



## 怎么自定义注解

1. 首先这么写 

```
	//创建了一个新的注解类型名为 CustomAnnotationClass	
	//@interface说明这是一个自定义注解的定义。
	public @interface CustomAnnotationClass 

```

2. 之后，你需要为此注解定义一对强制性的属性，保留策略和目标。还有一些其他属性可以定义，不过这两个是最基本和重要的。它们在第8章，描述注解的注解时讨论过，它们同样也是Java内建的注解。

```
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface CustomAnnotationClass {

		public String name() default "shenjun";

	}
```


> 具体的可以查看 Java/base/MethodAnnotation 下的代码



## 获取注解
Java反射API包含了许多方法来在运行时从类，方法或者其它元素获取注解。接口AnnotatedElement包含了大部分重要的方法，如下：

* getAnnotations(): 返回该元素的所有注解，包括没有显式定义该元素上的注解。
* isAnnotationPresent(annotation): 检查传入的注解是否存在于当前元素。
* getAnnotation(class): 按照传入的参数获取指定类型的注解。返回null说明当前元素不带有此注解。



## 注解中的继承

注解在 Java 中可以使用继承。

如果一个注解在Java中被标识成继承，使用了保留注解@Inherited，说明它注解的这个类将自动地把这个注解传递到所有子类中而不用在子类中声明。通常，一个类继承了父类，并不继承父类的注解。这完全和使用注解的目的一致的：提供关于被注解的代码的信息而不修改它们的行为。


比如
> 查看 Java/base/extend 下的代码


比较重要的一点
@Inheriated注解仅在存在继承关系的类上产生效果，在接口和实现类上并不工作。这条同样也适用在方法，变量，包等等。只有类才和这个注解连用。




## 总结
 注解是 Java 1.5 开始的一个非常重要的特性, 基本上，注解都是作为包含代码信息的元数据而被标记到代码中。它们不会改变或者影响代码的任何意义，而是被第三方称为消费器的程序通过反射的方式使用。


> 参考

官方Java注解地址：http://docs.oracle.com/javase/tutorial/java/annotations/
维基百科中关于Java注解的解释：http://en.wikipedia.org/wiki/Java_annotation
Java规范请求250：http://en.wikipedia.org/wiki/JSR_250
Oracle 注解白皮书：http://www.oracle.com/technetwork/articles/hunter-meta-096020.html
注解API：http://docs.oracle.com/javase/7/docs/api/java/lang/annotation/package-summary.html