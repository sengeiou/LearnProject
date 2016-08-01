# Buffer

### Buffer的四个属性

 * capacity (容量) 缓冲区能够容纳数据元素的最大数量
 * limit 缓冲区的第一个不能被读或被写的元素
 * position 下一个要被读或写的元素的索引
 * mark 备忘位置，调用 mark 来设定mark =position  调用reset position = mark

### 他们四个之间的关系 0 <= mark <= position <= limit <= capacity

>  buffer 本身是一个抽象类，描述了下面的方法

    public abstract class Buffer {
      public final int capacity( )
      public final int position( )
      public final Buffer position (int newPositio )
      public final int limit( )
      public final Buffer limit (int newLimit)
      public final Buffer mark( )
      public final Buffer reset( )
      public final Buffer clear( )
      public final Buffer flip( )
      public final Buffer rewind( )
      public final int remaining( )
      public final boolean hasRemaining( )
      public abstract boolean isReadOnly( ); }    
