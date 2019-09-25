package com.cocoa.test.test1;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Scatter  从channel 读取数据写到多个buffer中
 * 可以理解为：Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
 */
public class Test3 {

    public static void main(String[] aths) throws Exception {


        ByteBuffer body = ByteBuffer.allocate(24);
        ByteBuffer header = ByteBuffer.allocate(12);
        System.out.println(body.position());
        ByteBuffer[] byteBuffers = {body, header};

        File file = new File("src/com/cocoa/test/Main.java");

        RandomAccessFile mRandomAccessFile = new RandomAccessFile("src/com/cocoa/test/Main.java", "rw");

        FileChannel fileChannel = mRandomAccessFile.getChannel();
        //从channel 向buffer 中写数据，这里会根据buffer 数组中的顺序写入，当一个buffer 写满后，channel 会向下一个buffer中写
        fileChannel.read(byteBuffers);

        System.out.println(body.position());   //
        System.out.println(header.position());

    }

}
