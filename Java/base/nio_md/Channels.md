# channels

## channels 的基本概念.
 * channel有点类似io的Stream, 但是又有不同，Stream是单向的，只能读或只能写，但是channel是双向的，既能写数据到channel中，也能从中进行数据读写
 *  channel 可以进行异步的读写
 * channel对数据的操作都要依赖buffer
 * channel 的基本的两个方法， isOpen() 和 close()


IO其实可以分为两类，File IO 和 Stream IO, 相对应的两种类型的通道FileChannel 和 ServerSocketChannel, SocketChannel, DatagramChannel,这四个类特别重要,也是平时最多能使用到的

通道可以以多种方式创建。Socket 通道有可以直接创建新 socket 通道的工厂方法。但是一个 FileChannel 对象却只能通过在一个打开的 RandomAccessFile、FileInputStream 或 FileOutputStream 对象上调用 getChannel( )方法来获取。您不能直接创建一个 FileChannel 对象。File 和 socket 通道会 在后面的章节中予以详细讨论。

```
SocketChannel sc = SocketChannel.open( );
sc.connect (new InetSocketAddress ("somehost", someport));
ServerSocketChannel ssc = ServerSocketChannel.open( );
ssc.socket( ).bind (new InetSocketAddress (somelocalport));
DatagramChannel dc = DatagramChannel.open( );
RandomAccessFile raf = new RandomAccessFile ("somefile", "r");
FileChannel fc = raf.getChannel( );
```

#### 分别介绍下这几个类
 * FileChannel 从文件中读写数据 , 这里要说的是 , FileChannel 不能单独创建 , 只能通过RandomAccessFile , InputStream , OutputStream 获取，这里要注意的是，虽然chanel 可以进行读写，但是还要是要依赖File文件的权限，也就是说，file本身是只读的话，对chanel 进行写操作，在编译期是会报错的
 * DatagramChannel 通过UDP读写网络中的数据
 * SocketChannel 通过TCP读写网络中的数据
 * ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

> Channels.java simpleFileChannel方法展示了怎么使用FileChannel 读取数据，也使用到了Buffer



### 使用通道
```
public interface ReadableByteChannel
    extends Channel
{
    public int read (ByteBuffer dst) throws IOException;
56
}
public interface WritableByteChannel
    extends Channel
{
    public int write (ByteBuffer src) throws IOException;
}
public interface ByteChannel
    extends ReadableByteChannel, WritableByteChannel
{ }
```

#### 通道可以是单向的，也可以是双向的，通过实现ReadableByteChannel, WritableByteChannel中的一个，那么通道就是单向的，如果同时实现了这两个接口，那么这个通道就是双向的，可以双向传输数据。

> 部分的file 和 全部的 socket 对象都是双向的，socket 是一定的，file则比较特殊，比如从FileInputStream获取的FileChannel对象是只读的(RandomAccessFile 打开的FileChannel则是双向的)。
比如下面的demo:
```
// A ByteBuffer named buffer contains data to be written
FileInputStream input = new FileInputStream (fileName);
FileChannel channel = input.getChannel( );
// This will compile but will throw an IOException
// because the underlying file is read-only
channel.write (buffer);
```

#### ByteChannel 的 read( ) 和 write( )方法使用 ByteBuffer 对象作为参数。两种方法均返回已传输的 字节数,可能比缓冲区的字节数少甚至可能为零。


#### channel可以使用阻塞和非阻塞的模式，但是只有面向流的Channel才能使用非阻塞的模式，比如sockets和pipes




#### 关闭通道
 * 通道不能被重复使用，当通道关闭时，连接就丢失了，然后通道将不在连接任何东西。
 * 通过调用 close()方法来关闭通道，可能会造成阻塞，哪怕是非阻塞的通道
 * 通过调用 isOpen()方法来判断通道的开放状态。 





##### 非阻塞模式
 * 在jdk 中，非阻塞模式.主要是在SelectableChannel 类中实现,其中最主要的就是下面三个方法
```
abstract Object	blockingLock()// 还没来得及搞懂
abstract SelectableChannel	configureBlocking(boolean block)
abstract boolean	isBlocking()   
```
开发者可以直接调用configureBlocking 来配置,如果传入true 为阻塞模式，传入false ，则为非阻塞模式
然后可以通过isBlocking 来判断当前的channel处于什么模式下







#### Scatter/Gather(demo 见simpleScatterGather)
 * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。(调用channel 的read方法) , 因此 , Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
 * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，(调用channel 的wirte() 方法) , 因此 , Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。

下面的API 是 Scatter 和 Gather 的实现
```
public interface ScatteringByteChannel
    extends ReadableByteChannel
{
    public long read (ByteBuffer [] dsts)
        throws IOException;
    public long read (ByteBuffer [] dsts, int offset, int length)
        throws IOException;
}
public interface GatheringByteChannel
    extends WritableByteChannel
{
    public long write(ByteBuffer[] srcs)
        throws IOException;
    public long write(ByteBuffer[] srcs, int offset, int length)
        throws IOException;
}
```

> 可以看出，上面两个接口都各自重载了带有ByteBuffer数组的方法，(ReadableByteChannel 和 WritableByteChannel 本身只有一个接受ByteBuffer的方法), 并且重载了接受int offset, int length参数的方法，





## FileChannel
 * 文件通道总是阻塞的, 在上面也提到过了
 * FileChannel 不能直接创建,要依赖（RandomAccessFile、FileInputStream或FileOutputStream）的getChannel 方法创建
 * FileChannel 是线程安全的(thread-safe), 多个进程可以在同一个实例上并发调用方法而不会引起任何问题，不过并非所有的操作都是多线程的（multithreaded）。影响通道位置或者影响文件大小的操作都是单线程（single-threaded）

```
public abstract class FileChannel
    extends AbstractChannel
    implements ByteChannel, GatheringByteChannel, ScatteringByteChannel
{
    // 返回当 前文件的position值。返回值是一个长整型(long),表示文件中的当前字节位置 。
    // 如果没有调用过read方法，则返回0; 见demo 58-61 行
    public abstract long position( )
    // 第二种形式的 position( )方法带一个 long(长整型)参数并将通道的 position 设置为指定值
    public abstract void position (long newPosition)
    public abstract int read (ByteBuffer dst)
    public abstract int read (ByteBuffer dst, long position)
    public abstract int write (ByteBuffer src)
    public abstract int write (ByteBuffer src, long position)
    public abstract long size( )
    public abstract void truncate (long size)
    public abstract void force (boolean metaData)
}
```

对于position 方法，看demo
```
RandomAccessFile randomAccessFile = new RandomAccessFile ("filename", "r");
// Set the file position
randomAccessFile.seek (1000);
// Create a channel from the file
FileChannel fileChannel = randomAccessFile.getChannel( );
// This will print "1000"
System.out.println ("file pos: " + fileChannel.position( ));
// Change the position using the RandomAccessFile object
randomAccessFile.seek (500);
74
// This will print "500"
System.out.println ("file pos: " + fileChannel.position( ));
// Change the position using the FileChannel object
fileChannel.position (200);
// This will print "200"
System.out.println ("file pos: " + randomAccessFile.getFilePointer( ));
```

### 类似于缓冲区的 get( ) 和 put( )方法,当字节被 read( )或 write( )方法传输时,文件 position 会 自动更新。如果 position 值达到了文件大小的值(文件大小的值可以通过 size( )方法返回),read( ) 方法会返回一个文件尾条件值(-1)。可是,不同于缓冲区的是,如果实现 write( )方法时 position 前进到超过文件大小的值,该文件会扩展以容纳新写入的字节。

### 同样类似于缓冲区,也有带 position 参数的绝对形式的 read( )和 write( )方法。这种绝对形式 的方法在返回值时不会改变当前的文件 position。由于通道的状态无需更新,因此绝对的读和写可 能会更加有效率,操作请求可以直接传到本地代码。更妙的是,多个线程可以并发访问同一个文件 而不会相互产生干扰。这是因为每次调用都是原子性的(atomic),并不依靠调用之间系统所记住 的状态。



### 文件锁定



## 内存映射文件

新的 FileChannel 类提供了一个名为 map() 的方法，该方法可以在一个打开的文件和一个特殊类型的 ByteBuffer 之间建立以个虚拟内存映射.

通过内存映射机制来访问一个文件会比使用常规方法读写高效得多,甚至比使用通道的效率都高。

```
    public abstract MappedByteBuffer More ...map(MapMode mode,
                                         long position, long size)
 
    public static class MapMode {

         public static final MapMode READ_ONLY
             = new MapMode("READ_ONLY");

         public static final MapMode READ_WRITE
             = new MapMode("READ_WRITE");

         public static final MapMode PRIVATE
             = new MapMode("PRIVATE");
    }

```

```
//要映射 100 到 299(包 含 299)位置的字节,可以使用下面的代码:
buffer = fileChannel.map (FileChannel.MapMode.READ_ONLY, 100, 200);
//如果要映射整个文件则使用:
buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
```

同常规的文件句柄类似,文件映射可以是可写的或只读的。前两种映射模式 MapMode.READ_ONLY 和 MapMode.READ_WRITE 意义是很明显的,它们表示您希望获取的映射 只读还是允许修改映射的文件。请求的映射模式将受被调用 map( )方法的 FileChannel 对象的访问 权限所限制。如果通道是以只读的权限打开的而您却请求 MapMode.READ_WRITE 模式,那么 map( )方法会抛出一个 NonWritableChannelException 异常;如果您在一个没有读权限的通道上请求 MapMode.READ_ONLY 映射模式,那么将产生 NonReadableChannelException 异常。不过在以 read/write 权限打开的通道上请求一个 MapMode.READ_ONLY 映射却是允许的。MappedByteBuffer 对象的可变性可以通过对它调用 isReadOnly( )方法来检查。


第三种模式 MapMode.PRIVATE 表示您想要一个写时拷贝(copy-on-write)的映射。这意味着 您通过 put( )方法所做的任何修改都会导致产生一个私有的数据拷贝并且该拷贝中的数据只有 MappedByteBuffer 实例可以看到。该过程不会对底层文件做任何修改,而且一旦缓冲区被施以垃圾 收集动作(garbage collected),那些修改都会丢失。尽管写时拷贝的映射可以防止底层文件被修 改,您也必须以 read/write 权限来打开文件以建立 MapMode.PRIVATE 映射。只有这样,返回的 MappedByteBuffer 对象才能允许使用 put( )方法。





#### SocketChannel
 * socket通道可以运行阻塞和非阻塞模式，并且是可以选择的，非阻塞这个点非常重要，即不需要为每个socket连接创建一个线程
 * SocketChannel 主要有以下的三个类组成：DatagramChannel、SocketChannel和ServerSocketChannel
 * DatagramChannel 和 SocketChannel 定义读和写的功能的接口，而ServerSocketChannel 则不实现，ServerSocketChannel 主要是负责监听传入的链接和创建新的 SocketChannel, 本身不传递数据



##### 非阻塞模式
 上面已经介绍了，Socket 可以在非阻塞模式下运行，这主要依靠了SelectableChannel ，看下它的API

```
public abstract class SelectableChannel
    extends AbstractChannel
    implements Channel
{
    //调用这个方法, 传入false , 即可设置非阻塞
    public abstract void configureBlocking (boolean block)
        throws IOException;
    // 查看是否是阻塞    
    public abstract boolean isBlocking( );
    //防止 socket 通道的阻塞模式被更改 ,后面介绍
    public abstract Object blockingLock( );
}
```

所以，设置一个非阻塞的SocketChannel 

```
SocketChannel sc = SocketChannel.open( );
sc.configureBlocking (false); // nonblocking
...
if ( ! sc.isBlocking( )) {
        doSomething (cs);
}

```

##### ServerSocketChannel

先来看下 ServerSocketChannel API

###### ServerSocketChannel 是一个基于通道的 socket 监听器。它同我们所熟悉的 java.net.ServerSocket 执行相同的基本任务,不过它增加了通道语义,因此能够在非阻塞模式下运行。

```
public abstract class ServerSocketChannel
    extends AbstractSelectableChannel
{
    public static ServerSocketChannel open( ) throws IOException
    public abstract ServerSocket socket( );
    public abstract ServerSocket accept( ) throws IOException;
    public final int validOps( )
}
```

 1. open() 方法创建一个新的ServerSocketChannel 对象，将会返回同一个未绑定的 java.net.ServerSocket 关联的通道。
 2. 该对等 ServerSocket 可以通过在返回的 ServerSocketChannel 上调 用 socket( )方法来获取。
 3. 由于 ServerSocketChannel 没有 bind( )方法,因此有必要取出对等的 socket 并使用它来绑定到一 个端口以开始监听连接。hannel_socket


```
ServerSocketChannel ssc = ServerSocketChannel.open( );
ServerSocket serverSocket = ssc.socket( );
// Listen on port 1234
serverSocket.bind (new InetSocketAddress (1234));
```