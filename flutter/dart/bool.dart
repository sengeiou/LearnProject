void main(){
  bool b = false;
  print("b hashcode = ${b.hashCode}");
  print("b toString = ${b.toString()}");

  // 不能用 1和0 判断
  // if(1){
  //     print("");
  // }

  var name = 123;

  if(name !=null){
    print("name is ${name}");
  }else{
    print("the name was null");
  }


}