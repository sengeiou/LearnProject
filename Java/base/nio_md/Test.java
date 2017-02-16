import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.Channels;
import java.io.*;

public class Test{
	


	public static void main(String[] args) throws IOException{
		// IntBuffer  mIntBuffer = IntBuffer.allocate(10);

		// for(int i =0; i<10; i++){
		// 	mIntBuffer.put(i);
		// } 

		// System.out.println(mIntBuffer.capacity());
		// System.out.println(mIntBuffer.position());
		// System.out.println(mIntBuffer.limit());
		// System.out.println(mIntBuffer.mark());


		// mIntBuffer.flip();

		// while(mIntBuffer.hasRemaining()){
		// 	int result  = mIntBuffer.get();
		// 	System.out.println(result);
		// }

// ===============
		// ReadableByteChannel source = Channels.newChannel(System.in);
		// WritableByteChannel dest   = Channels.newChannel(System.out);

		// channelCopy1(source,dest);
		// source.close();
		// dest.close();

// ===============
		// ByteBuffer  b1  = ByteBuffer.allocate(20);
		// ByteBuffer  b2  = ByteBuffer.allocate(20);

		// for (int i = 0; i < 20; i++){
		// 	b1.put((byte)'A');
		// 	b2.put((byte)'B');
		// } 

		// b1.flip();
		// b2.flip();



		// ByteBuffer[] bufferArray = {b1,b2};

  //  		File directory = new File("");
  //       String courseFile = directory.getCanonicalPath();
  //       System.out.println(courseFile);
  //       String fileStr = courseFile+File.separator+"test.txt";
  //       RandomAccessFile mRandomAccessFile  = new RandomAccessFile(new File(fileStr),"rw");

  //       FileChannel fileChannel  = mRandomAccessFile.getChannel();
  //       int i  = 0;
  //       while(i<1000){	
  //       	long readCount = fileChannel.write(bufferArray);
  //       	System.out.println(readCount);
  //       	i++;
  //       	b1.rewind();
		// 	b2.rewind();

		// }
  //       fileChannel.close();

        // b1.flip();
        // b2.flip();

        // while(b1.hasRemaining()){
        // 	System.out.println((char)b1.get());
        // }

        // while(b2.hasRemaining()){
        // 	System.out.println((char)b2.get());
        // }
// ===============



   		File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
        String fileStr = courseFile+File.separator+"test.txt";
        

        // RandomAccessFile mRandomAccessFile  = new RandomAccessFile(new File(fileStr),"rw");

        FileInputStream in = new FileInputStream(new File(fileStr));

        FileChannel fileChannel = in.getChannel();

       	MappedByteBuffer mByteBuffer =  fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fileChannel.size());

       	System.out.println(mByteBuffer.position());

	}

	public static void channelCopy1(ReadableByteChannel source,WritableByteChannel dest)throws IOException{
		ByteBuffer  buffer  = ByteBuffer.allocate(16*1024);
		while(source.read(buffer) != -1){

			buffer.flip();
			dest.write(buffer);

			buffer.clear();
			break;
		}

		// buffer.flip();
		// while(buffer.hasRemaining()){
		// 	dest.write(buffer);
		// }

	}


	// public  String test(){
	// 	try{
	// 		return "123";
	// 	}catch(Exception  e){

	// 	}finally{
	// 		System.out.print("finally");	
	// 	}
	// 	return "out";
	// }




	// public void test2(){
	// 	switch("123"){
	// 		case "123":
	// 		System.out.println("123");
	// 		break;
	// 		default:
	// 		break;	
	// 	}	

	// }




}