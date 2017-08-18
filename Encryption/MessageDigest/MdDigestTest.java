import java.security.*;
import java.io.*;

public class MdDigestTest {
	public static void main(String[] args) {
		try {
			String str = "123";
			String result = new String(digestMD5(str.getBytes()), "UTF-8");
			System.out.println(result);
		} catch (NoSuchAlgorithmException  e) {
			System.out.println(e.toString());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.toString());
		}
	}
	public static byte[] digestMD5(byte[] data) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		return md5.digest(data);
	}

}