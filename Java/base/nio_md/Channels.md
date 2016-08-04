# channels

### channels 的基本概念.
 * channel有点类似io的Stream, 但是又有不同，Stream是单向的，只能读或只能写，但是channel是双向的，既能写数据到channel中，也能从中进行数据读写
 *  channel 可以进行异步的读写
 * channel对数据的操作都要依赖buffer


#### IO其实可以分为两类，File IO 和 Stream IO, 在jdk中分别对应FileChannel 和 ServerSocketChannel, SocketChannel, DatagramChannel,这四个类特别重要,也是平时最多能使用到的


#### 分别介绍下这几个类
 * FileChannel 从文件中读写数据 , 这里要说的是 , FileChannel 不能单独创建 , 只能通过RandomAccessFile , InputStream , OutputStream 获取，这里要注意的是，虽然chanel 可以进行读写，但是还要是要依赖File文件的权限，也就是说，file本身是只读的话，对chanel 进行写操作，在编译期是会报错的
 * DatagramChannel 通过UDP读写网络中的数据
 * SocketChannel 通过TCP读写网络中的数据
 * ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

> Channels.java simpleFileChannel方法展示了怎么使用FileChannel 读取数据，也使用到了Buffer


#### channel可以使用阻塞和非阻塞的模式，但是只有面向流的Channel才能使用非阻塞的模式，比如sockets和pipes


#### Scatter/Gather
