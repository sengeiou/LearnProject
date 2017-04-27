package com.company;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Main extends  Thread{
    static  String o  = new String("a");

    public static void main(String[] args) throws Exception {

            ServerSocketChannel channel  = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(8899));
            Selector selector = Selector.open();

            channel.configureBlocking(false);
            SelectionKey mSelectionKey  =  channel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isAcceptable()) {
                        System.out.print("isAcceptable");
                    } else if (key.isConnectable()) {
                        System.out.print("isConnectable");
                    } else if (key.isReadable()) {
                        System.out.print("isReadable");
                    } else if (key.isWritable()) {
                        System.out.print("isWritable");
                    }
                    keyIterator.remove();
                }
            }
    }

    public synchronized  void lock() throws InterruptedException {
        while(isAlive()){
            wait(0);
        }
    }



    @Override
    public void run() {
        super.run();
        try {

            int i = 10;
            while( i > 5) {
                i--;
                System.out.println("===="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
