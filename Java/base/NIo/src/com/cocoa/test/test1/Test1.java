package com.cocoa.test.test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016/5/20.
 */
public class Test1 {

    public static void main(String args[]){

          File file =new File("src/com/cocoa/test/Main.java");

            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());

        try {
            RandomAccessFile mRandomAccessFile = new RandomAccessFile("src/com/cocoa/test/Main.java","rw");

            FileChannel fileChannel =  mRandomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(128);

            int result = fileChannel.read(byteBuffer);


            System.out.println(result);

            while (result != -1){

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()){
                    System.out.println((char) byteBuffer.get());
                }

                byteBuffer.clear();

                result = fileChannel.read(byteBuffer);

            }

            fileChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
