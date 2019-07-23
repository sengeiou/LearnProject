import java.io.RandomAccessFile;

public class RandomAccessFileTest extends Thread{
	
	private RandomAccessFile rFile;
	private long pos;
	private int num;
	private static int count = 0;

	public RandomAccessFileTest(RandomAccessFile rFile, int num,long pos){
		this. rFile = rFile;
		this.pos = pos;
		this. num= num;
		System.out.println("thread " + num + " is pos = " + pos);
	}

	public static void main(String[] args){
		try{
			// file 的文件为 111222333  用三个线程去读取
			RandomAccessFile file  = new RandomAccessFile("print.txt", "r");
			long length   = file .length();
			System.out.println("file length = "+length);

			long pos  = length / 3;

			for(int i = 0; i < 3; i++){
				RandomAccessFileTest rFileTest  = new RandomAccessFileTest(file ,i, i*pos);
				rFileTest.start();	
			}	
		}catch(Exception e){
		 	System.out.println(e.toString()+ e.getMessage());
		}
	}

	@Override
	public void run() {
		try{
			synchronized(rFile){
				rFile.seek(pos);
				
				byte[] b = new byte[3];
				rFile.read(b);
				System.out.println(new String(b));
				
				count++;
				if(count==3){
					rFile.close();
				}
			}
		}catch(Exception e){
			System.out.println(e.toString()+ e.getMessage());
		}
	}
}