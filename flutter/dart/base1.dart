void main() {
  // int

  // dart 的number有两种类型，int 和 double 都是num 抽象类的实现类  （num 本身不能被创建）
  int aaaa = 10;
  double bbbb = 120.12;
  print(aaaa);
  print(bbbb);

  // var numTest = num();

  var num1 = int.tryParse("----"); //返回 null?   // null safe
  print("int.tryParase ${num1}"); // null
  print("int.tryParase ${num1.runtimeType}"); // Null

  var num2 = int.tryParse("1");
  print("${num2.runtimeType}"); // int

  var i1 = 19.00;
  print("the i1 abs() = ${i1.abs()}");

  i1.toString();
  print("the i1 isNaN = ${i1.isNaN}");
  print("the i1 isNegative = ${i1.isNegative}");
  print("the i1 sign = ${i1.sign}");
  print("the i1 runtimeType = ${i1.runtimeType}");

  var hashCode = i1.hashCode;
  print("the hashcode is $hashCode");

  var address = "zhejiang";
  print("address hashcode is ${address.hashCode}");

  var a2 = int.parse("10");
  try {
    double d2 = double.parse("00.99-"); // 报错
    print("the d2 is ${d2}");
  } catch (e) {}

  print("the a2 is ${a2}");

  // int i2 = 10.00;  // double 类型不能赋值int  会报错

  var name = "bob";
  print(name);

  int count;

  print("未初始化的变量具有 null 的初始值。即使数字类型变量最初为 ${count}  ，因为数字是对象,");

  print("${1 + 2}");

  final age = 12;
  const p1 = "123";

  int a1a = 12;

  int a2a = 13;
}
