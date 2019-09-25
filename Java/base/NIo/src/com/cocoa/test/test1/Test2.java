package com.cocoa.test.test1;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试buffer 在写模式下的 limit position capacity
 */
public class Test2 {

    public static void main(String args[]){

        try {
            RandomAccessFile mRandomAccessFile = new RandomAccessFile("src/com/cocoa/test/haha.txt", "rw");

            FileChannel fileChannel = mRandomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(12);


            byteBuffer.put((byte)'s');
            byteBuffer.put((byte)'s');
            byteBuffer.put((byte)'s');
            byteBuffer.put((byte)'s');
            byteBuffer.put((byte)'s');
            byteBuffer.put((byte)'s');
            byteBuffer.put((byte)'s');


            fileChannel.write(byteBuffer);

//            System.out.println(byteBuffer.limit());
//            System.out.println(byteBuffer.position());
//            System.out.println(byteBuffer.capacity());
//
//            byteBuffer.flip();
//
//
//            System.out.println(byteBuffer.limit());
//            System.out.println(byteBuffer.position());
//            System.out.println(byteBuffer.capacity());
//
//
//
//            byteBuffer.flip();
//
//
//            System.out.println(byteBuffer.limit());
//            System.out.println(byteBuffer.position());
//            System.out.println(byteBuffer.capacity());


            fileChannel.close();

        }catch (Exception e){


        }


    }


}
