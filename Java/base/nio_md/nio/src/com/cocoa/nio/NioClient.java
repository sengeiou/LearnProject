package com.cocoa.nio;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by cocoa on 2017/6/14.
 */
public class NioClient extends Main {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(ADDRESS, PORT);
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter bufferedOutputStream = new OutputStreamWriter(outputStream);
            bufferedOutputStream.write("Hello nio server");
            bufferedOutputStream.close();
            outputStream.close();
            socket.close();


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
