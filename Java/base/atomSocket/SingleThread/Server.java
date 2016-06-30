

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
/**

 */
public class Server {

public static final int PORT = 6666;


public static void main(String[] args){


        try{

                ServerSocket mServerSocket = new ServerSocket(PORT);

                Socket mSocket = mServerSocket.accept();

                InputStream mInputStream  = mSocket.getInputStream();

                OutputStream mOutputStream = mSocket.getOutputStream();

                InputStreamReader mInputStreamReader = new InputStreamReader(mInputStream);

                BufferedReader mBufferedReader = new BufferedReader(mInputStreamReader);


                while (true) {

                        String s  = mBufferedReader.readLine();
                        System.out.println(s);

                        if("bye".equals(s)) {
                                break;
                        }
                }
                System.out.println(".......");

                mSocket.close();
                mServerSocket.close();

        }catch(IOException e) {
              System.out.println(e.getMessage());  
        }

}
}
