

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
/**

 */
public class Server {

public static final int PORT = 6666;


public static void main(String[] args){
        try{
                ServerSocket mServerSocket = new ServerSocket(PORT);
                while(true) {
                        Socket mSocket = mServerSocket.accept();
                        handConnection(mSocket);
                }
        }catch (Exception e) {

        }
}


public static void handConnection(Socket pSocket){
  new Thread(new Runnable() {
            public void run() {

        try{

                InputStream mInputStream  = pSocket.getInputStream();

                OutputStream mOutputStream = pSocket.getOutputStream();

                InputStreamReader mInputStreamReader = new InputStreamReader(mInputStream);

                BufferedReader mBufferedReader = new BufferedReader(mInputStreamReader);

                PrintWriter mPrintWriter = new PrintWriter(mOutputStream);


                while (true) {

                        String s  = mBufferedReader.readLine();
                        System.out.println(s);

                        if("bye".equals(s)) {
                                break;
                        }

                        mPrintWriter.println("you send server "+s);
                        mPrintWriter.flush();

                }
                System.out.println(".......");



        }catch(IOException e) {
                System.out.println(e.getMessage());
        }
}}).start();

}



}
