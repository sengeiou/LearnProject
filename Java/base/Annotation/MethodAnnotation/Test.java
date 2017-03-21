import java.lang.annotation.*;
import  java.lang.reflect.*;
public class Test{

	public static void main(String[] args){
		System.out.println(getName());

		
	}

	@MethodAnnotation( name = "cocoa")
	public static String getName(){
		return "name";
	}


}