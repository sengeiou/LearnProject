import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class ServerSocketChannelTest {

	public static final String HOST = "localhost";
	public static final int PORT = 8888;


	public static void main(String[] args) throws Exception {

		ServerSocketChannel  ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(PORT));
		ssc.configureBlocking(false);

		while (true) {
			SocketChannel  sc = ssc.accept();
			if (sc == null) {
				Thread.sleep(1000);
			} else {
				Socket socket  = sc.socket();
				System.out.println(socket.getRemoteSocketAddress());
			}

		}
	}
}