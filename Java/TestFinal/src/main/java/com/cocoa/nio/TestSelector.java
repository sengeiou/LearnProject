package com.cocoa.nio;

import sun.nio.ch.Interruptible;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class TestSelector {

    public static void main(String[] args) throws IOException {


        Selector selector = Selector.open();
        System.out.println(selector);   //sun.nio.ch.WindowsSelectorImpl

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        System.out.println(serverSocketChannel);   //sun.nio.ch.WindowsSelectorImpl


    }


}
