# Buffer

### Buffer的四个属性

 * capacity (容量) 缓冲区能够容纳数据元素的最大数量
 * limit 缓冲区的第一个不能被读或被写的元素
 * position 下一个要被读或写的元素的索引 ,初始值为0
 * mark 备忘位置，调用 mark 来设定mark =position  调用reset position = mark,初始值为-1

### 他们四个之间的关系 0 <= mark <= position <= limit <= capacity

>  buffer 本身是一个抽象类，描述了下面的方法
```
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
```

>    ByteBuffer, CharBuffer, DoubleBuffer, FloatBuffer, IntBuffer, LongBuffer, ShortBuffer。 java为7个原始数据类型提供了Buffer的实现，除了boolean，这7个类本身也都是抽象类

#####  在BufferTest.java 中，我们创建了一个intBuffer对象，这里看创建方法IntBuffer.allocate(12)，allocate()这个静态方法的的参数就是capacity，系统在此时会初始化capacity和limit,也就是在buffer创建时，capacity等于limit，通过allocate方法，实际是创建了继承Intbuffer的HeapIntBuffer类。（这里拿IntBuffer举例，其它的buffer也是类似的）

#####  接着看，mIntBuffer.put(1)，调用了put 方法，先看下put方法，jdk提供了很多重载，比较方便
 * abstract ByteBuffer	put(byte b){}
 * ByteBuffer	put(byte[] src){}
 * ByteBuffer	put(byte[] src, int offset, int length){}
 * ByteBuffer	put(ByteBuffer src){}
 * abstract ByteBuffer	put(int index, byte b){}

##### 每put一次的时候，position就会++,  如果不停的put，超过了capacity ，则会抛出BufferOverflowException，看源码

```

public ByteBuffer put(byte x) {   
      hb[ix(nextPutIndex())] = x;  //调用了父类Buffer 中的nextPutIndex 方法
      return this;
  }


final int nextPutIndex() { // package-private
     if (position >= limit)
         throw new BufferOverflowException();   // put前必须做好position的检测，不然
     return position++;//                      // position++   
 }
```     
##### 接着来，下面的3行print 分别打印了capacity,limit,position  ,如果读了我上面的分析，你应该就能知道，他们分别打印了什么

##### 再往下，分别put了 2,3,4 ,到此为止，我们的capacity=12，存储了4个元素，position=4，假设我们的数据都存储完了，那么下一步就是读取，在这里，有一点非常重要，那就是buffer中可用数据的长度，怎么去获取可用数据的长度，一开始，可能都会认为，从0开始读取，到position的位置，就是能获取到可用数据了，但是非常不幸的是，你拉到最上面，看Buffer的四个属性，（position 下一个要被读或写的元素的索引），也就是说，当开始读取buffer的时候，position就会被重置，并且根据读取元素后改变，或许你可以自定义一个变量，来存储position，但是buffer中有limit 变量，可以更优雅的解决。所以下面的代码用limit 记录了position ，并且把postion置为0。


```
mIntBuffer.limit(mIntBuffer.position()).position(0);  //联级调用
System.out.println(String.format("the buffer capactiy is %s",mIntBuffer.capacity()));  //----> 12
System.out.println(String.format("the buffer position is %s",mIntBuffer.position()));    //----> 0
System.out.println(String.format("the buffer limit is %s",mIntBuffer.limit())); //----> 4

```
##### 但是jdk已经把这段代码为我们设计好了api，也就是flip方法（翻转），看下官方对这个的解释：makes a buffer ready for a new sequence of channel-write or relative get operations: It sets the limit to the current position and then sets the position to zero.   (Flip将一个能够继续添加数据元素的填充状态的缓冲区翻转成一个准备读出元素的释放状态)

```
      public final Buffer flip() {  //和我们上面自己实现的几乎一致，无非就是没有把mark设为初始值
             limit = position;
             position = 0;
             mark = -1;
             return this;
           }
```

##### 讲到flip 就不得不讲下rewind函数，直接看源码，看下他们之间的区别

```
public final Buffer rewind() {
        position = 0;
        mark = -1;
        return this;
}
```

##### 这里主要测试调用两次flip,编译运行后发现，报错，原来，两次调用flip方法后，limit 和position都变成了0，尝试对缓冲区上位置和上界都为0的get()操作会导致BufferUnderflowException异常。而put()则会导致BufferOverflowException异常，这里要特别注意

```
// mIntBuffer.flip();
// mIntBuffer.flip();
// mIntBuffer.put(4);
// System.out.println(mIntBuffer.get());
```

##### 接着撸，遍历buffer的时候，可以借助hasRemaining 和 remaining 函数;hasRemaining主要返回position是否小于limit ,remaining 返回 limit - position

```
for (int i = 0; buffer.hasRemaining( ), i++) {
  myByteArray [i] = buffer.get( );
}

int count = buffer.remaining( );
  for (int i = 0; i < count, i++) {
    myByteArray [i] = buffer.get( );
  }
```

##### 然后看下clear()与compact()方法，数据被读完好，就要使用这两个方法，告诉buffer准备好，等待再次被写入

 * 首先来看下clear()，查看源码发现，position = 0， limit = capacity ，mark = -1 ,几乎就是初始化了所有变量，和buffer 刚创建时一样，唯一的区别是buffer中的数据还是的的确确存在的，调用clear函数后，你将无法区分哪些数据是被读取过了，哪些是没有读取的，有多少可用数据, 如果buffer中还有未读数据，后续你还要这些数据，只是暂时你要做写入数据的操作，那么你就要使用compact方法

```
/**
     * Clears this buffer.  The position is set to zero, the limit is set to
     * the capacity, and the mark is discarded.
     *
     * <p> Invoke this method before using a sequence of channel-read or
     * <i>put</i> operations to fill this buffer.  For example:
     *
     * <blockquote><pre>
     * buf.clear();     // Prepare buffer for reading
     * in.read(buf);    // Read data</pre></blockquote>
     *
     * <p> This method does not actually erase the data in the buffer, but it
     * is named as if it did because it will most often be used in situations
     * in which that might as well be the case. </p>
     *
     * @return  This buffer
     */
    public final Buffer clear() {
        position = 0;
        limit = capacity;
        mark = -1;
        return this;
    }

```

 * 再来看下 compact方法,compact方法讲所有未读的数据拷贝到buffer的起始处，然后将怕position 设置最后一个为未读数据的后面，limit设置为capacity 一样，这样，你就可以做写入的操作，来看下源码吧


 ```
 这里hb就是真正存储数据的数组



 public ByteBuffer compact() {
       System.arraycopy(hb, ix(position()), hb, ix(0), remaining());  
       position(remaining());
       limit(capacity());
       discardMark();  // 就是把mark = -1;
       return this;
   }

 ```



##### mark()与reset()方法， 调用mark的时候，position将被赋值给mark ，调用reset时，将会把mark赋值给position ，在调用reset前，必须要调用mark()方法，不然是会报InvalidMarkException，由于比较简单，就不贴出源码了
