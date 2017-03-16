import java.io.File;
import java.io.PrintWriter;

public class PrintWriterTest{
	// PrintWriter 集成了 java.io.Writer ，所以能对字符流进行操作
	//  

	public static void main(String[] args) throws Exception {
		String fileName  = "print.txt";

		File file = new File(fileName);

		if(!file.exists()){
			file.createNewFile();
		}

		PrintWriter printer = new PrintWriter(fileName);

		printer.print("444");

		printer.close();
	}

}