import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.util.*;

public class Server1 {
	public static void main(String[] args) {
		try {
			ServerSocketChannel channel  = ServerSocketChannel.open();
			channel.bind(new InetSocketAddress(8899));
			Selector selector = Selector.open();

			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_CONNECT);

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
		} catch (Exception e) {
			System.out.print(e.toString());
		}

	}
}