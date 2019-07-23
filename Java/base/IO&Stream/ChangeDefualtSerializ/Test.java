import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Test implements Serializable{

	private String name;
	transient private int age;


	public static void main(String[] args) throws Exception {

		Test temp  = new Test();

		temp.name = "shenjun";
		temp.age = 10;

		FileOutputStream out =  new FileOutputStream("print.txt",false);

		ObjectOutputStream  objOut= new ObjectOutputStream(out);

		objOut.writeObject(temp);

		objOut.close();


		FileInputStream in  = new FileInputStream("print.txt");

		ObjectInputStream  objIn  = new ObjectInputStream(in);

		Object o = objIn.readObject();

		Test t = (Test)o;

		System.out.println(t.age + "++==" + t.name );




	}
	private void writeObject(ObjectOutputStream out)throws IOException{
			out.defaultWriteObject();
			//out.writeInt(age);   //尝试加上这行代码
	}


	private void readObject(ObjectInputStream in) throws IOException ,ClassNotFoundException{
			in.defaultReadObject();
			//this.age = in.readInt();
	}





// aced 0005 7372 0004 5465 7374 5aca 2f71
// aa8f 0480 0300 0249 0003 6167 654c 0004
// 6e61 6d65 7400 124c 6a61 7661 2f6c 616e
// 672f 5374 7269 6e67 3b78 7077 0600 3100
// 3200 3378 

// aced 0005 7372 0004 5465 7374 5aca 2f71
// aa8f 0480 0200 0249 0003 6167 654c 0004
// 6e61 6d65 7400 124c 6a61 7661 2f6c 616e
// 672f 5374 7269 6e67 3b78 7000 0000 0a74
// 0007 7368 656e 6a75 6e










}