
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {



public static final int PORT = 6666;
public static final String ADDRESS = "127.0.0.1";


public static void main(String[] args){


        Socket mSocket = null;

        try{

                mSocket = new Socket(ADDRESS,PORT);

                InputStream mInputStream =  mSocket.getInputStream();

                OutputStream mOutputStream  = mSocket.getOutputStream();


                PrintWriter mPrintWriter  =  new PrintWriter(mOutputStream);

                InputStreamReader mInputStreamReader  = new InputStreamReader(mInputStream);

                BufferedReader mBufferedReader = new BufferedReader(mInputStreamReader);


                int i  = 0;

                while(true) {

                        mPrintWriter.println(i+"");
                        mPrintWriter.flush();
                        i++;

                        Thread.sleep(1000);

                        if(i==10) {
                                mPrintWriter.println("bye");
                                mPrintWriter.flush();
                                break;
                        }

                        String serverMsg = mBufferedReader.readLine();
                        System.out.println(serverMsg);

                }


        }catch(Exception e) {
                System.out.println(e.getMessage());

        }finally{
                try{
                        mSocket.close();
                }catch (Exception e) {

                }

        }

}
}
