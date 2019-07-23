package com.cocoa.test.io;

import com.cocoa.test.Constanct;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSimpleTest1 {


    /**
     * 如果要判断socket是否连接       socket.isConnected()&& !socket.isClosed()
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(Constanct.PORT);

            System.out.println(String.format("the server is listener @ port %s", Constanct.PORT));

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println(String.format("new connection @ port %s and address %s", socket.getPort(), socket.getInetAddress().toString()));

                InputStream inputStream = socket.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                int i = 0;
                while (true) {
                    if (isConented(socket)) {
                        String str = in.readLine();
                        System.out.println(str);
                        out.println("has receive...." + i);
                        out.flush();
                        i++;
                        if (str.equals("end")) {
                            break;
                        }
                    } else {
                        System.out.println("is offline ");
                        break;
                    }
                }
                socket.close();


//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

//                String result;
//                while ((result = bufferedReader.readLine()) != null) {
//                    System.out.println(result);
//                    if(result.endsWith("**")){
//                        break;
//                    }
//                }
//
//
//                OutputStream outputStream = socket.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//                bufferedWriter.write("gun**");
//
//
//
//
//                bufferedWriter.close();
//                outputStream.close();
//
//                bufferedReader.close();
//                inputStream.close();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static boolean isConented(Socket socket) {
        return socket.isConnected() && !socket.isClosed();
    }


}
