import java.io.FileInputStream ;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectStreamException;

public class Orientation implements Serializable{

	public static final Orientation HORIZONTAL  = new Orientation(1);

	public static final Orientation VERTICAL = new Orientation(2);

	private int value ;

	private Orientation(int value){
		this. value = value;
	}

	public int getValue(){
		return value;
	}


	public static void main(String[] args) throws Exception{
		
		Orientation o = Orientation.HORIZONTAL;

		FileOutputStream out  = new FileOutputStream("text.txt",false);
		ObjectOutputStream  objOut = new ObjectOutputStream(out);

		objOut.writeObject(o);

		FileInputStream in =  new FileInputStream("text.txt");
		ObjectInputStream  objIn = new ObjectInputStream(in);

		Object  object = objIn.readObject();

		Orientation result = (Orientation) object;

		System.out.println(result.getValue());	

		// 书上给出的例子，拿反序列化后的对象和 Orientation.HORIZONTAL(只生成一次) 比较 ，结果是不等的
		// 要解决这个，需要 重写 readResolve
		System.out.println(result ==  Orientation.HORIZONTAL );	 // false

		

	}

	// 实验过程中请开启此代码，以便观察结果
	// protected Object readResolve() throws ObjectStreamException{
	// 	if(value ==1){
	// 		return HORIZONTAL;

	// 	} else if (value == 2){
	// 		return VERTICAL;
	// 	} 
	// 	return null;
	// }






}