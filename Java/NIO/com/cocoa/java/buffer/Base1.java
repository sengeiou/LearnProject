package com.cocoa.java.buffer;

import java.nio.*;

public class Base1{
    public static void main(String[] args){
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        System.out.println(buffer1.capacity());
    }
}


