# 选择器(Selectors)

> 关于Selectors 的类都在 java.nio.channels 包中


### 选择器,可选择通道,选择键

 * 选择器(Selector)
 * 可选择通道(SelectableChannel)(所有socket通道都是可选择的，FileChannel是不可选择的，没有集成slectableChannel)
 * 选择键(SelectionKey)

> 通道在被注册到选择器上之前，必须先设置为非阻塞模式

#### 调用可选通道的 register() 可以将它注册到一个选择器上，如果试图注册一个处于阻塞状态的通道，register() 方法则会抛出 IllegalBlockingModeException，通道一旦注册，就不能回到阻塞状态，如果这么做的话，也会IllegalBlockingModeException，如果注册一个已经关闭的SelectableChannel实例的话，会报ClosedChannelException。


### 建立选择器

#### demo 监控三个通道的选择器

```
Selector selector = Selector . open();
channel1.register(selector, SeletionKey.OP_READ);
channel2.register(selector, SelctionKey.OP_WRITE);
channel3.register(selector, SelctionKey.OP_READ | SeletionKey.OP_WRITE);

readCount  = selector.select(1000);
//select( )方法在将线程置于睡眠状态,直到这些兴趣中一个发生或者 10 秒 的 时间过去。
```

#####接着看Selector的Api

```
public abstract class Selector
{
           // This is a partial API listing
           public static Selector open( ) throws IOException  //静态工厂方法创建实例
           public abstract boolean isOpen( );
           public abstract void close( ) throws IOException;
           public abstract SelectionProvider provider( ); // 不常用，调用后决定由哪个SelectionProvider 来创建给定的Selector实例
}
```

#####当不再需要Selector时，需要调用close() 方法来释放，一旦关闭后，再次调用，则会报错ColosedSelectorException, 可以调用 isOpen 来测试Selector
是否被打开。




##### 如何将通道注册到选择器，来看下SelectorChannel的API

```
 public abstract class SelectableChannel
           extends AbstractChannel
           implements Channel
   {
           // This is a partial API listing
           public abstract SelectionKey register (Selector sel, int ops)
           throws ClosedChannelException;
           public abstract SelectionKey register (Selector sel, int ops,
           Object att)
           throws ClosedChannelException;
           public abstract boolean isRegistered( );
           public abstract SelectionKey keyFor (Selector sel);
           public abstract int validOps( );
}
```

##### 首先看下register 方法，参数一Selector，参数二通道操作

在JDK1.4中，有4种可选操作: 读（read） 写（write） 连接（connect） 接受（accept）

> 并不是所有操作在所有的通道上被支持，比如SocketChannel 不支持 accept; 如果注册了不支持的操作，，则会导致IllegalArgumentException，实际开发中，可以调用validOps( )方法来获取特定的通道所支持的操作集合。

#####  register 的重载方法，参数三（Object）可以传递您提供的对象引用,在调用新生成的选择键的 attach( )方法时会将 这个对象引用返回给您。


#####  一个单独的通道对象可以被注册到多个选择器上。可以调用 isRegistered( )方法来检查一个通道 是否被注册到任何一个选择器上。





# 使用选择器

### SelectionKey 类的 API:
			
```
public abstract class SelectionKey
{
           public static final int OP_READ
           public static final int OP_WRITE
           public static final int OP_CONNECT
           public static final int OP_ACCEPT
           public abstract SelectableChannel channel( );
           public abstract Selector selector( );
           public abstract void cancel( );
           public abstract boolean isValid( );
           public abstract int interestOps( );
           public abstract void interestOps (int ops);
           public abstract int readyOps( );
           public final boolean isReadable( )
           public final boolean isWritable( )
           public final boolean isConnectable( )
           public final boolean isAcceptable( )
           public final Object attach (Object ob)
           public final Object attachment( )
}
```

#### channel() 方法返回与键相关的SelectableChannel对象
#### selector() 返回相关的 selector
#### cancel() 结束键对象的注册关系
#### isValid() 方法来检查它是否仍然表示一种有效的关系
>当键被 取消时,它将被放在相关的选择器的已取消的键的集合里。注册不会立即被取消,但键会立即失效 (参见 4.3 节)。当再次调用 select( )方法时(或者一个正在进行的 select()调用结束时),已取消 的键的集合中的被取消的键将被清理掉,并且相应的注销也将完成。通道会被注销,而新的 SelectionKey 将被返回。

>一个 SelectionKey 对象包含两个以整数形式进行编码的比特掩码:一个用于指示那些通道/ 选择器组合体所关心的操作(instrest 集合),另一个表示通道准备好要执行的操作(ready 集合)。
#### interestOps() 方法获取获取所关心的操作集合
#### readyOps()方法来获取相关的通道的已经就绪的操作。

####  if (key.isWritable( ))
等价于:
    if ((key.readyOps( ) & SelectionKey.OP_WRITE) != 0)
别的三个操作也是类似的



####  attach 和 attachment 允许你在键上放一个附件, 并在后面获取它。允许你将任意对象与键关联。
SelectableChannel类的register() 重载方法中的 Object 参数，就是这个附件
所以

```
SelectionKey key =
          channel.register (selector, SelectionKey.OP_READ, myObject);
等价于:
   SelectionKey key = channel.register (selector, SelectionKey.OP_READ);
   key.attach (myObject);
```




# 使用选择器
   Selector 类,也就是就绪选择的核心。

##  选择过程

   选择器维护着注册过的通道的集合，并且这写注册关系中的任意一个都是封装在SelectionKey对象中的， 每一个Selector对象维护三个键的集合：
 
```
public abstract class Selector
{
        // This is a partial API listing
        public abstract Set keys( );
        public abstract Set selectedKeys( );
        public abstract int select( ) throws IOException;
        public abstract int select (long timeout) throws IOException;
        public abstract int selectNow( ) throws IOException;
        public abstract void wakeup( );
}
```

 * 已注册的键的集合 (Registered key set)  调用keys()返回这个集合，可能为空	
 * 已选择的键的集合 (Selected key set)    调用selectedKeys() ，可能为空
 * 已取消的键的集合 (cancelled key set)   已注册的键的集合的子集,这个集合包含了 cancel( )方法被调用过的键

 #### 在刚初始化Selector 对象时，3个集合都是空的。

 > Selector 类的核心是选择过程。这个名词您已经在之前看过多次了——现在应该解释一下 了。基本上来说,选择器是对select( )、poll( )等本地调用(native call)或者类似的操作系统特定的系 统调用的一个包装。但是 Selector 所作的不仅仅是简单地向本地代码传送参数。它对每个选择 操作应用了特定的过程。对这个过程的理解是合理地管理键和它们所表示的状态信息的基础。

 




