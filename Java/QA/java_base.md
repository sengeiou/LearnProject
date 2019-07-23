#  java 问题解答

Q: equals 和 hashCode
A: 
 * equals 是 java.lang.Object的方法，接受一个 Object 的参数，返回自身是否 == Object 参数
 * 所有类都可以重写 equals 方法，去实现自己的代码，String 重写了该方法，用来返回两个字符串的内容是否相同，Java/Test/Equals.java 展示了怎么去重写 equals 方法
 *  java 中基本类型的比较，只能用 == ，基本类型的包装类型，可以用 equals 来比较内容。

	下面是 java 对 equals 方法的要求：

 1，自反性，对于任何非控引用x，x.equals(x)都应该返回true。

 2，对称性，对于任何引用x和y，如果x.equals(y)返回true，那么y.equals(x)也应该返回true。

 3，传递性，如果x.equals(y)，y.equals(z)都返回true，那么，x.equals(z)返回true。

 4，一致性，如果x和y引用的对象没有发生变化，那么无论调用多少次x.equals(y)都返回相同的结果。

 5，对于任意非空引用x，x.equals(null)都应该返回false。　　

 *  It is reflexive: for any non-null reference value x, x.equals(x) should return true.

 *  It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.

 *  It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.

 *  It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.

 *  For any non-null reference value x, x.equals(null) should return false.
	
> hashCode			

对于hashCode，我们应该遵循如下规则：

1. 在一个应用程序执行期间，如果一个对象的equals方法做比较所用到的信息没有被修改的话，则对该对象调用hashCode方法多次，它必须始终如一地返回同一个整数。同一个应用多次执行过程中个，每次执行返回的整数可能不一致.

2. 如果两个对象根据equals(Object o)方法是相等的，则调用这两个对象中任一对象的hashCode方法必须产生相同的整数结果。

3. 如果两个对象根据equals(Object o)方法是不相等的，则调用这两个对象中任一个对象的hashCode方法，不要求产生不同的整数结果。但如果能不同，则可能提高散列表的性能。

至于两者之间的关联关系，我们只需要记住如下即可：

如果x.equals(y)返回“true”，那么x和y的hashCode()必须相等。

如果x.equals(y)返回“false”，那么x和y的hashCode()有可能相等，也有可能不等。


> 覆盖 equals 时方法时，总要覆盖 hashCode 方法，如果，不覆盖，则会违反 hashCode 的第2条规则，相同的对象必须有相同的散列码。
```
  
// Double 中的实现	
public int hashCode() {
     long bits = doubleToLongBits(value);
     return (int)(bits ^ (bits >>> 32));
}

// Integer 中的实现
public int hashCode() {
     return value;
}

```


Q: fianl 关键字
A: 
* final 成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。 
* final 类不能被继承，没有子类， final 类中的方法默认是 final的
* final 方法不能被子类方法覆盖，但是可以被继承
* final 不能修改构造方法 
* final 修饰成员变量表示常量，只能被赋值一次，赋值后值不再改变，经常和 static 一起使用。
* final 和 abstract 这两个关键字是反相关的，final 类就不可能是 abstract 的。
* 将类、方法、变量声明为 final 能够提高性能，这样JVM就有机会进行估计，然后优化。
* final 如果修饰集合类型，则该引用不能被修改，但是可以向集合内添加删除元素
* final 修饰参数，参数在方法中就不能修改， 常在方法中的内部类获取参数时，需要将参数设置为 final




Q: comparable和comparator的区别
A:  
1. Comparable是排序接口。若一个类实现了Comparable接口，就意味着该类支持排序。实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。  
> 可以查看 Java/Test/ComparableTest.java 查看代码

2. Comparator是比较接口，我们如果需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)，那么我们就可以建立一个“该类的比较器”来进行排序，这个“比较器”只需要实现Comparator接口即可。
> 可以查看 Java/Test/ComparatorTest.java 查看代码

Comparable和Comparator区别比较

　　Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。

　　Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。

　　两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，但是需要修改源代码。 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器， 当某个自定义的对象需要作比较的时候，把比较器和对象一起传递过去就可以比大小了， 并且在Comparator 里面用户可以自己实现复杂的可以通用的逻辑，使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。


Q: Switch能否用string做参数？
A: 在Thinking in Java 中，作者说只能使用整形变量，放byte，short，char也是可以的, 因为他们会自动提升为int，但是在jdk1.7版本后，支持了用string 做参数

Q: String StringBuilder StringBuffer区别
A: 
1. StringBuilder 和 StringBuffer 底层实现几乎一致，唯一区别是StringBuilder是非线程安全的，StringBuffer则是线程安全的，StringBuffer的方法几乎都加上了synchronized，效率上来说，StringBuilder比StringBuffer要高很多，单线程处理大量的字符可以用StringBuilder , Stringbuffer 和StringBuilder都继承了AbstractStringBuilder ，而StringBuilder , Stringbuffer的大部分操作都是调用了父类的方法来完成的（模板方法模式），唯一区别就是上面说到的，Stringbuffer在调用父类方法时增加了synchronized修饰符.



Q: Java中 static 的作用
A: 
 * 被static修饰的成员变量和成员方法独立于该类的任何对象。也就是说，它不依赖类特定的实例，被类的所有实例共享。
 
 * 只要类被加载，虚拟机就能根据类名在运行时数据区的方法去内找到他们，static对象 可以在任何对象创建以前访问，所以，static 环境中不能访问 非static 的变量，方法，也不能出现this 和 super 关键字.
 
 * 被 static 修饰的变量在内存中只有一个拷贝，虚拟机只会分配一次内存； 而实例变量则是每创建一个实例，就为实例变量分配一次内存。

 * 用static修饰的代码块表示静态代码块，当Java虚拟机（JVM）加载类时，就会执行该代码块，如果static代码块有多个，JVM将按照它们在类中出现的先后顺序依次执行它们，每个代码块只会被执行一次。



Q: 内部类访问外部的参数时，为什么要把参数设置为 final
A:



