import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.util.*;

public class Server1 {
	public static void main(String[] args) {
		try {
			ServerSocketChannel channel  = ServerSocketChannel.open();

			channel.configureBlocking(false);
			channel.socket().bind(new InetSocketAddress(8888));

			Selector selector = Selector.open();
			System.out.println(channel.toString());
			System.out.println(channel);

			channel.register(selector, SelectionKey.OP_ACCEPT );

			while (true) {
				int readyChannels = selector.select();
				if (readyChannels == 0)

					continue;

				Thread.sleep(1000);

				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
				while (keyIterator.hasNext()) {
					SelectionKey key = keyIterator.next();

					if (key.isAcceptable()) {

						ServerSocketChannel  scc = (ServerSocketChannel)key.channel();
						System.out.println(scc.toString());
						System.out.println(scc);
						System.out.println("isAcceptable");

						SocketChannel sc = scc.accept();

						sc.register(selector, SelectionKey.OP_READ );


					} else if (key.isConnectable()) {
						System.out.println("isConnectable");
					} else if (key.isReadable()) {
						System.out.println("isReadable");
					} else if (key.isWritable()) {
						System.out.println("isWritable");
					}
					keyIterator.remove();
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}