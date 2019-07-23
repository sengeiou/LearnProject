package com.cocoa.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class TestClient {

    public static void main(String[] args) throws IOException {

        SocketAddress  socketAddress = new InetSocketAddress("localhost",8899);

        Socket socket = new Socket("localhost",8899);

    }

}
