public class Equals{

	public String name;


	public static void main(String[] args){
		// Equals qq = null;
		// System.out.println(qq instanceof Equals);

		Equals q1 = new Equals();
		q1.name = "shen1";


		Equals q2 = new Equals();
		q2.name = "shen";

		boolean result = q1.equals(q2);
		System.out.println(result);


	}


	@Override
	public boolean equals(Object o){
		if(this == o ){     // 这步必须做
			return true;
		}	
		if(o instanceof Equals){  // 这步必须做 instanceof 可以判断o 为 null 的情况，同时也可以为强转做判断
			Equals t = (Equals) o;
			if(this.name.equals(t.name)){
				return true;
			}
		}
		return false;
	}

}