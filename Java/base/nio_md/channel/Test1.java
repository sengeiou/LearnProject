import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class Test1{
	public static void main(String[] args) throws Exception{

		FileInputStream  fileIuputSream = new FileInputStream("Channels.java");

		FileChannel fileChannel = fileIuputSream.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		while(fileChannel.read(byteBuffer)!= -1){

			byteBuffer.flip();

			while(byteBuffer.hasRemaining()){

				System.out.print((char)byteBuffer.get());

			}
			
			byteBuffer.flip();
		}
	}
}