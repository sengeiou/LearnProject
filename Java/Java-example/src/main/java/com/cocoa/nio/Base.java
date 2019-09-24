package com.cocoa.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class Base {

    @Test
    public void test1(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);  // create buffer

        print(byteBuffer); //[pos=0 lim=10 cap=10]

        byteBuffer.put((byte)'H');  // put one element

        print(byteBuffer);   // [pos=1 lim=10 cap=10]  this position was changed

        byteBuffer.flip();   // flip buffer

        print(byteBuffer);  //  [pos=0 lim=1 cap=10]  than  position and limit was exchanged

    }

    /**
     * at this dp ,use put and get method
     */
    @Test
    public void testPutGet(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        //BufferOverflowException    If this buffer's current position is not smaller than its limit
        byteBuffer.put((byte)'s').put((byte)'h').put((byte)'e').put((byte)'n');   //['s','h','e','n']

        print(byteBuffer);  // [pos=4 lim=10 cap=10]

        // change index 0 element and put new element
        byteBuffer.put(0,(byte)'S').put((byte)'w');  //['S','h','e','n','w']

        print(byteBuffer);

        // flip == change write mode to read mode
        // limit = position;
        // position = 0;
        // mark = -1;
        byteBuffer.flip();   //[pos=0 lim=5 cap=10]

        print(byteBuffer);

        // dp read buffer ,use get method
        StringBuilder  sb = new StringBuilder();

        // use hasRemaining to check position < limit , cuz get method may throws BufferUnderflowException
        while(byteBuffer.hasRemaining()){
            //BufferUnderflowException
            // If the buffer's current position is not smaller than its limit
            sb.append((char)byteBuffer.get());
        }
        System.out.println(sb.toString()); // print Shenw

    }




    private void print(ByteBuffer byteBuffer){
        System.out.println(String.format("the capcity is %s",byteBuffer.capacity()));
        System.out.println(String.format("the limit is %s",byteBuffer.limit()));
        System.out.println(String.format("the position is %s",byteBuffer.position()));
        System.out.println(String.format("the mark is %s",byteBuffer.mark()));
        System.out.println(String.format("the buffer is %s",byteBuffer));
        System.out.println("---------------------");
        System.out.println("---------------------");
    }


}
