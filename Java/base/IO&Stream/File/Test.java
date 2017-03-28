import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
public class Test{
	public static void main(String[] args) throws Exception{
		Path path = Paths.get("sx.txt");
		System.out.println(path.toString());

		byte[] b = Files.readAllBytes(path);

		System.out.println(new String(b));

		System.out.println("------");

		java.util.List<String>  mList = Files.readAllLines(path);

		for( String line : mList ){
				System.out.println(line);
		}

	}
}