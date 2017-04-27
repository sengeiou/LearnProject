import java.net.*;
import java.nio.channels.*;
import java.nio.*;
import java.io.*;

public class SocketChannelTest {

	public static final String HOST = "127.0.0.1";

	public static final int PORT = 8888;

	public static void main(String[] args)  {
		try {
			SocketChannel sc  = SocketChannel.open();

			sc.configureBlocking(false);

			sc.connect(new InetSocketAddress(HOST, PORT));

			System.out.println(sc.isConnected());

			System.out.println(sc.isConnectionPending());

			while ( !sc.finishConnect()) {

				ByteBuffer  byteBuffer = ByteBuffer.allocate(1024);

				byteBuffer.put((byte)'H');

				byteBuffer.flip();

				sc.write(byteBuffer);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}


		// Socket socket = sc.socket();

		// OutputStream  out =  socket.getOutputStream();

		// out.write(new String("Hello World").getBytes());

		// out.close();
	}
}