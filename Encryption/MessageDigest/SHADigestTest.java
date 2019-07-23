import java.security.*;


public class SHADigestTest{
	public static void main(String[] args) throws Exception{
		String s =  "123123";

		MessageDigest md  = MessageDigest.getInstance("SHA");

		System.out.println(new String(md.digest(s.getBytes()),"UTF-8"));
	}
}