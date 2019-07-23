import java.io.PipedInputStream;
import java.io.PipedOutputStream;
// import java.io.IOException;

public class MyThread extends Thread {

	private PipedInputStream in;
	private PipedOutputStream out;
	private String sendMsg;


	public MyThread(PipedOutputStream out , PipedInputStream in) {
		this.out = out;
		this.in = in;
	}

	public void setMsg(String msg) {
		this.sendMsg = msg;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);

				if (!"".equals(sendMsg)) {
					byte[] b = sendMsg.getBytes();
					out.write(b, 0, b.length);
					out.flush();
					this.sendMsg = "";
					continue;
				}

				byte[] bb = new byte[1024];
				while (in.read(bb) != -1) {
					System.out.println(new String(bb));
				}
			} catch (Exception e) {

			}
		}
	}
}