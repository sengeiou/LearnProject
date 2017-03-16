import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class ObjectOutputStreamTest implements Serializable{

	private String name;
	private int age;


	public static void main(String[] args) throws Exception {

		ObjectOutputStreamTest temp  = new ObjectOutputStreamTest();

		temp.name = "shenjun";
		temp.age = 10;

		FileOutputStream out =  new FileOutputStream("print.txt",false);

		ObjectOutputStream  objOut= new ObjectOutputStream(out);

		objOut.writeObject(temp);

		objOut.close();


	}



}