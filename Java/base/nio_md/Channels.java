import java.nio.*;
import java.io.RandomAccessFile;
import java.nio.channels.*;
import java.io.File;
import java.io.IOException;

/**



 */


public class Channels {

public static void main(String[] args) throws Exception {

        //simpleFileChannel();

        //  simpleReadOnly();

        simpleScatterGather();

}



public static void simpleScatterGather()  {
        try{
// gather get the data from buffers

                ByteBuffer buffer1 = ByteBuffer.allocate(10);
                ByteBuffer buffer2 = ByteBuffer.allocate(20);

                for(int i=0; i<10; i++) {
                        buffer1.put((byte)'H');
                        buffer2.put((byte)'E');
                }

                buffer1.flip();
                buffer2.flip();

                System.out.println(buffer1.limit());
                System.out.println(buffer2.limit());


                ByteBuffer[] bArray = {buffer1,buffer2};

                File directory = new File("");
                String courseFile = directory.getCanonicalPath();
                System.out.println(courseFile);
                String fileStr = courseFile+File.separator+"test.txt";
                RandomAccessFile mRandomAccessFile  = new RandomAccessFile(new File(fileStr),"rw");


                FileChannel fileChannel =  mRandomAccessFile.getChannel();

                ByteBuffer b = ByteBuffer.allocate(100);
                fileChannel.read(b);        
                System.out.println("byteBuffer. position()"+b.position());        
                System.out.println("fileChannel . position()"+fileChannel.position());


                // fileChannel.write(bArray);
                // fileChannel.close();

                // fileChannel.write        

                // mRandomAccessFile  = new RandomAccessFile(new File(fileStr),"rw");
                // fileChannel =  mRandomAccessFile.getChannel();

                // //scatter  set date into buffers

                // ByteBuffer buffer3 = ByteBuffer.allocate(10);
                // ByteBuffer buffer4 = ByteBuffer.allocate(20); // change <10 ? try

                // ByteBuffer[] scatterArray = {buffer3,buffer4};

                // fileChannel.read(scatterArray);

                // System.out.println(buffer3.position());
                // System.out.println(buffer4.position());


                // // change to read model
                // buffer3.flip();
                // while(buffer3.hasRemaining()) {
                //         System.out.println((char)buffer3.get());
                // }

                // buffer4.flip();
                // while(buffer4.hasRemaining()) {
                //         System.out.println((char)buffer4.get());
                // }


        }catch(Exception e) {
                System.out.println(e.getMessage());
        }

}


public static void simpleReadOnly  () throws Exception {
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();

        System.out.println(courseFile);


        String fileStr = courseFile+File.separator+"read_only.txt";

        RandomAccessFile mRandomAccessFile  = new RandomAccessFile(new File(fileStr),"rw");

        ByteBuffer b = ByteBuffer.allocate(5);
        b.put((byte)'H');
        b.put((byte)'E');
        b.put((byte)'L');
        b.put((byte)'L');
        b.put((byte)'O');

//  mRandomAccessFile.write(b);




}



public static void simpleSocketChannel  () throws Exception {



}


public static void simpleFileChannel() throws IOException {
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath();

        System.out.println(courseFile);


        String fileStr = courseFile+File.separator+"Buffer.md";

        RandomAccessFile mRandomAccessFile  = new RandomAccessFile(new File(fileStr),"rw");

        FileChannel mFileChannel = mRandomAccessFile.getChannel();

        ByteBuffer mBuffer = ByteBuffer.allocate(96);

        int byteRead  =  mFileChannel.read(mBuffer);

        while (byteRead != -1) {
                System.out.println(String.format("the byte read %s",byteRead));

                mBuffer.flip();


                while(mBuffer.hasRemaining()) {
                        System.out.print((char)mBuffer.get());
                }

                mBuffer.clear();

                byteRead = mFileChannel.read(mBuffer);

        }

        mFileChannel.close();
}



}
