package com.cocoa.nio;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by cocoa on 2017/6/14.
 */
public class NioClient extends Main {


    static ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private static SocketChannel ss;
    private static Selector selector;


    public static void main(String[] args) {
        try {
            ss = SocketChannel.open();
//            ss.socket().bind(new InetSocketAddress(PORT));
            ss.configureBlocking(false);
            ss.connect(new InetSocketAddress(ADDRESS, PORT));
            selector = Selector.open();
            ss.register(selector, SelectionKey.OP_CONNECT);

            if (ss.isConnectionPending()) {
                ss.finishConnect();
                ss.configureBlocking(false);
                ss.register(selector, SelectionKey.OP_WRITE);
            }


            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if ("exit".equals(line)) {
                    break;
                }
                process(line);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void process(String msg) throws Exception {
        while (true) {
            int t = selector.select();
            if (t == 0) {
                continue;
            }
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = keySet.iterator();

            while (selectionKeyIterator.hasNext()) {
                SelectionKey key = selectionKeyIterator.next();
//                    if (key.isConnectable()) {
//                        ss.finishConnect();
//                        ss.configureBlocking(false);
//                        ss.register(selector, SelectionKey.OP_WRITE);
//                    } else
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    readBuffer.clear();
                    socketChannel.read(readBuffer);
                    readBuffer.flip();
                    while (readBuffer.hasRemaining()) {
                        System.out.print(readBuffer.get());
                    }
                    ss.register(selector, SelectionKey.OP_WRITE);

                } else if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    writeBuffer.clear();
                    writeBuffer.put(msg.getBytes());
                    socketChannel.write(writeBuffer);
                    ss.register(selector, SelectionKey.OP_READ);

                }
                selectionKeyIterator.remove();
            }
        }


    }

}
