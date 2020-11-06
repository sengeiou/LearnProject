
// import '';


void printNumber(num number) =>
    print("the number is $number");
    // print("123");

enableFlags({bool bold : false, bool hidden: true}){
    print("the params bold is $bold and the hidden is $hidden");
}


printElement(element){
  print("$element");
}

Function makeAdder(num addBy){
  return (num i ) => addBy + i;
}



foo(){
  print("this is foo");
}

class A{
  static void bar(){}
  void baz(){}
}



test(String name ,{age :123}){
   return name + age.toString();
}


test1({String key , int age : 0 }){

}


void main(List<String> args){

      test1(age: 1,key: "123");


      print(test("cocoa",age:12));

      //dart functons.dart params1 params2
      print("the main function params is $args");


      printNumber(12);
      enableFlags();    
      //把一个函数当做参数传给另一个函数
      var list = [1,2,3];
      list.forEach(printElement);


      var add2 = makeAdder(2);

      //匿名方法
      list.forEach((item){
        print("the item(${item}) + 2  = ${add2(item)}");
      });

      var x = foo;
      x();

}