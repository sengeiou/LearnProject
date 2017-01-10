import java.nio.channels.*;
import java.nio.*;
import java.io.*;
import java.net.*;
/**
simple ServerSocketChannel

*/
public class ServerSCTest{

  public static void main(String[] aths) throws Exception {

      ServerSocketChannel  ssc = ServerSocketChannel.open();
      ServerSocket mServerSocket =  ssc.socket();
      mServerSocket.bind(new InetSocketAddress(1234));
      //mServerSocket
      ssc.configureBlocking(false);
      while(true){
          SocketChannel  sc = ssc.accept();

          if( sc == null ){
            System.out.println("no client connection");
          }else{
            Socket  socket   = sc.socket();
            System.out.println(socket.getPort()+"---port--");
            System.out.println("listen 1234 has client connection");
          }

          Thread.sleep(2000);

      }
  }
}
