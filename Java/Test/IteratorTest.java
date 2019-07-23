import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings("unchecked")
public class IteratorTest{
	public static void main(String[] args) throws Exception{

		ArrayList list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");

		Iterator<String>  itr = list.iterator();

		while(itr.hasNext()){ 
			//itr.remove();    // 这里会报错，因为没有调用next 方法  //java.lang.IllegalStateException
		}

	}
}
