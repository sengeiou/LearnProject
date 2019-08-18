

void printNumber(num number) =>
    print("the number is $number");

enableFlags({bool bold : false, bool hidden: true}){
    print("the params bold is $bold and the hidden is $hidden");
}

printElement(element){
  print("$element");
}


void main(List<String> args){
      //dart functons.dart params1 params2
      print("the main function params is $args");


      printNumber(12);
      enableFlags();    
      //把一个函数当做参数传给另一个函数
      var list = [1,2,3];
      list.forEach(printElement);



}