import java.nio.ByteBuffer;
import java.io.*;
import java.nio.channels.*;

public class CommTest{

	public static void main(String[] args)throws Exception{

		RandomAccessFile  randomAccessFile  = new RandomAccessFile("test.txt","rw");	
		FileChannel fileChannel = randomAccessFile.getChannel();


		ByteBuffer mByteBuffer = ByteBuffer.allocate(2);


		int size  = fileChannel.read(mByteBuffer);

		while(size != -1){

			mByteBuffer.flip();

			while(mByteBuffer.hasRemaining()){
				System.out.println((char)mByteBuffer.get());
			}
			mByteBuffer.clear();
			size = fileChannel.read(mByteBuffer);
		}
		randomAccessFile.close();		

	}

}