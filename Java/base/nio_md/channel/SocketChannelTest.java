import java.net.*;
import java.nio.channels.*;
import java.nio.*;

public class SocketChannelTest{

	public static final String HOST = "localhost";
	public static final int PORT = 8888;

	public static void main(String[] args) throws Exception{
		SocketChannel sc  = SocketChannel.open();
		sc.configureBlocking(false);

		sc.connect(new InetSocketAddress(HOST,PORT));
		Socket socket = sc.socket();
			
	}
}