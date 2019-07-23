import java.nio.*;
import java.net.*;
import java.nio.channels.*;
import java.util.Iterator;

public class SelectorServer{
    public static final int PORT = 1234;


    private void goSocket() throws Exception{

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        ServerSocketChannel  serverSocketChannel  = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        Selector selector = Selector.open();

        serverSocket.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while(true){
            int key =  selector.select();
            if(key == 0){
              continue;
            }
            Iterator iterator  = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey selectedKeys = (SelectionKey)iterator.next();

                if(selectedKeys.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1  = (ServerSocketChannel) selectedKeys.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();

                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("isAcceptable");  
                }
                if(selectedKeys.isReadable()){
                    readDataFromSocket(selectedKeys,byteBuffer);
                }
                iterator.remove();
            }
        }
    }

    private void readDataFromSocket(SelectionKey key,ByteBuffer buffer){
      SocketChannel  socketChanel  = (SocketChannel) key.channel();
      buffer.clear();
      int count = 0;

    }

    public static void main(String args[]) {

    try{
        new SelectorServer().goSocket();
    }catch(Exception e){
      System.out.println(e.toString());
    }


  }



}
