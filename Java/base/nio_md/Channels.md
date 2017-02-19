# channels

### channels 的基本概念.
 * channel有点类似io的Stream, 但是又有不同，Stream是单向的，只能读或只能写，但是channel是双向的，既能写数据到channel中，也能从中进行数据读写
 *  channel 可以进行异步的读写
 * channel对数据的操作都要依赖buffer
 * channel 的基本的两个方法， isOpen() 和 close()

#### IO其实可以分为两类，File IO 和 Stream IO, 在jdk中分别对应FileChannel 和 ServerSocketChannel, SocketChannel, DatagramChannel,这四个类特别重要,也是平时最多能使用到的


#### 分别介绍下这几个类
 * FileChannel 从文件中读写数据 , 这里要说的是 , FileChannel 不能单独创建 , 只能通过RandomAccessFile , InputStream , OutputStream 获取，这里要注意的是，虽然chanel 可以进行读写，但是还要是要依赖File文件的权限，也就是说，file本身是只读的话，对chanel 进行写操作，在编译期是会报错的
 * DatagramChannel 通过UDP读写网络中的数据
 * SocketChannel 通过TCP读写网络中的数据
 * ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

> Channels.java simpleFileChannel方法展示了怎么使用FileChannel 读取数据，也使用到了Buffer


#### channel可以使用阻塞和非阻塞的模式，但是只有面向流的Channel才能使用非阻塞的模式，比如sockets和pipes


#### Scatter/Gather(demo 见simpleScatterGather)
 * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。(调用channel 的read方法) , 因此 , Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
 * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，(调用channel 的wirte() 方法) , 因此 , Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。




#### FileChannel
 * 文件通道总是阻塞的, 在上面也提到过了
 * FileChannel 不能直接创建,要依赖（RandomAccessFile、FileInputStream或FileOutputStream）的getChannel 方法创建
 * FileChannel 是线程安全的(thread-safe), 多个进程可以在同一个实例上并发调用方法而不会引起任何问题，不过并非所有的操作都是多线程的（multithreaded）。影响通道位置或者影响文件大小的操作都是单线程（single-threaded）


#### SocketChannel
 * socket通道可以运行阻塞和非阻塞模式，并且是可以选择的，非阻塞这个点非常重要，即不需要为每个socket连接创建一个线程
 * SocketChannel 主要有以下的三个类组成：DatagramChannel、SocketChannel和ServerSocketChannel


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
