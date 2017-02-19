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





