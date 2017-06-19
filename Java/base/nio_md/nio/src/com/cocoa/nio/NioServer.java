package com.cocoa.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by cocoa on 2017/6/14.
 */
public class NioServer extends Main {


    public static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(ADDRESS, PORT));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int selectNum = selector.select();

                if (selectNum == 0) {
                    Thread.sleep(1000);
                    continue;
                }
                Set<SelectionKey> selectKeys = selector.keys();

                Iterator<SelectionKey> selectionKeyIterable = selectKeys.iterator();

                while (selectionKeyIterable.hasNext()) {
                    SelectionKey key = selectionKeyIterable.next();
                    if (key.isValid() && key.isAcceptable()) {
                        System.out.println("client has accrpt " + Thread.currentThread().getName());
                        ServerSocketChannel inSsc = (ServerSocketChannel) key.channel();
                        SocketChannel inSS = inSsc.accept();
                        inSS.register(selector, SelectionKey.OP_READ);

                    } else if (key.isValid() && key.isReadable()) {
                        System.out.println("client has readable " + Thread.currentThread().getName());
                        SocketChannel inSc = (SocketChannel) key.channel();
                        byteBuffer.clear();
                        inSc.read(byteBuffer);

                        byteBuffer.flip();
                        int leng = byteBuffer.limit();
                        System.out.println(new String(byteBuffer.array(), 0, leng));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
