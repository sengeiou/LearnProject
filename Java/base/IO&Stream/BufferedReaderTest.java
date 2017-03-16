import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class BufferedReaderTest{

	public static void main(String[] args) throws Exception{

		FileInputStream fis = new FileInputStream("print.txt");

		InputStreamReader isr = new InputStreamReader(fis);

		BufferedReader br = new BufferedReader(isr);

		String line ;

		while((line = br.readLine()) != null){
			System.out.println(line);
		}

	}

}