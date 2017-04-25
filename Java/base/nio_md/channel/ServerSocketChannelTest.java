import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.io.*;

public class ServerSocketChannelTest {

	public static final String HOST = "localhost";
	public static final int PORT = 8789;


	public static void main(String[] args) throws Exception {

		ServerSocketChannel  ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.bind(new InetSocketAddress(PORT));
		


		while (true) {
			SocketChannel  sc = ssc.accept();
			if (sc == null) {
				Thread.sleep(1000);
			} else {
				// Socket socket  = sc.socket();

				// InputStream  in = socket.getInputStream();

				// byte[] b = new byte[1024];

				// in.read(b);

				// System.out.println(new String(b));

				// ByteBuffer  b =  ByteBuffer.allocate(1024);

				// sc.read(b);


				// 		ByteBuffer  b =  ByteBuffer.allocate(1024);

				//             sc.write (b);

				// b.flip();

				// while(b.hasRemaining()){
				// 	System.out.println(b.get());
				// }

				//             sc.close( );

				while (true) {
					Thread.sleep(1000);
					System.out.println(sc.isConnected());
				}

			 }

		}
	}
}