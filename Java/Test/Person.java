public  class Person{
		public int age;

		public Person(int age){
			this.age  = age;
		}

		@Override
		public String toString(){
			return "age " + age;
		}

	}