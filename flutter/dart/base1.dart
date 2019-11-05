void main() {
  // int

  var i1 = 19.00;
  print("the i1 abs() = ${i1.abs()}");

  i1.toString();
  print("the i1 isNaN = ${i1.isNaN}");
  print("the i1 isNegative = ${i1.isNegative}");
  print("the i1 sign = ${i1.sign}");
  print("the i1 runtimeType = ${i1.runtimeType}");

  var hashCode = i1.hashCode;
  print("the hashcode is $hashCode");

  var address  = "zhejiang";
  print("address hashcode is ${address.hashCode}");

  var a2 = int.parse("10");  
  double d2 = double .parse("00.99-");


  print("the a2 is ${a2}");
  print("the d2 is ${d2}");


  // int i2 = 10.00;  // double 类型不能赋值int  会报错

  var name = "bob";
  print(name);

  int count;

  print("未初始化的变量具有 null 的初始值。即使数字类型变量最初为 null ，因为数字是对象。$count");

  print("${1 + 2}");

  final age = 12;
  const p1 = "123";
}
