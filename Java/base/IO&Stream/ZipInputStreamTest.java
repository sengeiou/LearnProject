import java.io.FileInputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipInputStreamTest{

	public static void main(String[] args) throws Exception{
		// for test
		String userDir = System.getProperty("user.dir");

		System.out.println(userDir);




		// 将文件进行打包
		FileOutputStream readmeOutFile = new FileOutputStream("test.zip");

		ZipOutputStream zipOutStream = new ZipOutputStream(readmeOutFile);

		ZipEntry readme1 =  new ZipEntry("RandomAccessFileTest11.java");
		
		zipOutStream.putNextEntry(readme1);
		

		FileInputStream in  = new FileInputStream(new File("RandomAccessFileTest.java"));	
		
		byte[]  b  = new byte[1024]; 
		
		while(in.read(b)!=-1){
			zipOutStream.write(b);
		}

		zipOutStream.close();	



		// 获取一个压缩文件的信息
		ZipInputStream zipStream = new ZipInputStream(new FileInputStream("test.zip"));

		ZipEntry mZipEntry ;

		while((mZipEntry = zipStream.getNextEntry())!= null){
			// 会遍历每一个目录
			System.out.println(mZipEntry.getName());
		}

	}

}