import java.net.*;
import java.nio.*;
import java.nio.channels.*;


public class SocketServer {

	public static void main(String[] args) throws Exception {
		SocketServer ss = new SocketServer();
		ss.bind(8899);
	}

	public void bind(int port) throws Exception {

		ServerSocketChannel ssc  =  ServerSocketChannel.open();

		ServerSocket sc =  ssc.socket();

		sc.bind(new InetSocketAddress(port));

		ssc.configureBlocking(false);

		while (true) {

			SocketChannel mSocketChannel = ssc.accept();

			if (mSocketChannel != null) {

				System.out.println(mSocketChannel.socket().getRemoteSocketAddress());

				ByteBuffer b = ByteBuffer.allocate(100);
				b.put((byte)'A');
				b.flip();
				mSocketChannel.write(b);
				mSocketChannel.close();

			} else {
				Thread.sleep(1000);
				System.out.println(" there is no connect");
			}
		}
	}

}

