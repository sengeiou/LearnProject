import java.net.*;
import java.nio.*;
import java.nio.channels.*;



public class SocketClient{

	public static void main(String[] args)throws Exception{
		SocketClient sc= new SocketClient();
		sc.connect("127.0.0.1",8888);

	}

	public void connect(String host,int port )throws Exception{
			SocketChannel sc  = SocketChannel.open();
			
			sc.configureBlocking(false);

			sc.connect(new InetSocketAddress(host,port));

			ByteBuffer b = ByteBuffer.allocate(10);


			while ( !sc.finishConnect( )) {
				
				sc.read(b);
				System.out.println(b.position());
				sc.close();


			}

	}



}