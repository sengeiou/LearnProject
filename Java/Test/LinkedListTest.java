import java.util.LinkedList;

public class LinkedListTest{

	public static void main(String[] args){

		LinkedList<String> mList = new LinkedList<String>();

		mList.add("1");
		mList.add("1");
		mList.add("2");

		mList.remove("1");
		System.out.println(mList.size());
		// 这里输出2, remove方法只会删除一次，如果要删除所有的相同的元素，需要用iterator遍历删除		

		mList.addAll(mList);	
		System.out.println(mList.toString());


		mList.addAll(1,mList);	
		System.out.println(mList.toString());

		


	}
}