import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class Test {
	/**
	*	通过管道流进行线程间的通信：字节流
	*
	*   管道流是一种很特殊的流， 用于在不同线程间传输数据
	*
	*   jdk 中提供了4个类来使线程间可以通信：
	*
	*   位于java.io 包下：
	*   PipedInputStream
	*   PipedOutputStream
	*   PipedReader
	*   PipedWriter
	*
	*  代码是自己写的，比较奇葩，没有参考 书上的demo    PipedWrite 和 PipedReader 实现也是一样的
	*/
	public static void main(String[] args) throws Exception {
		String name = "";

		PipedInputStream  in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		// 这里唯一要注意的地方
		// out.connect(in)  == in.connect(out) 这两个操作都是一样的，实际操作只需调用任意一个方法就行
		// 实际都是调用了 PipedOutputStream 的 connect 方法
		// 这样 PipedOutputStream 就有了 PipedInputStream的引用
		// 在 PipedOutputStream 的 write 方法中，直接调用 PipedInputStream 的 receive方法
		in.connect(out);

		MyThread reader = new MyThread(out, in);
		MyThread writer = new MyThread(out, in);

		reader.start();
		writer.start();
		writer.setMsg("123");
	}
}


// 96     public synchronized void connect(PipedInputStream snk) throws IOException {
// 97         if (snk == null) {
// 98             throw new NullPointerException();
// 99         } else if (sink != null || snk.connected) {
// 100            throw new IOException("Already connected");
// 101        }
// 102        sink = snk;
// 103        snk.in = -1;
// 104        snk.out = 0;
// 105        snk.connected = true;
// 106    }


// 117
// 118    public void write(int b)  throws IOException {
// 119        if (sink == null) {
// 120            throw new IOException("Pipe not connected");
// 121        }
// 122        sink.receive(b);
// 123    }