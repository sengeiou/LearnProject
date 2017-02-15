# 选择器(Selectors)
> 关于Selectors 的类都在 java.nio.channels 包中
 * 选择器(Selector)
 * 可选择通道(SelectableChannel)(所有socket通道都是可选择的，FileChannel是不可选择的，没有集成slectableChannel)
 * 选择键(SelectionKey)

### 通道在被注册到选择器上之前，必须先设置为非阻塞模式
