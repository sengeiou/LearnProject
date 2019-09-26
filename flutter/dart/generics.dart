import 'dart:io';

abstract class Flyer<T> {
  void fly(T name);
}

class Person {}

class Cache<T extends Person> {
  void setCache(T person) {}

  K test<K>(K name) {}
}

num versionApi() {
  var a = new Duration(milliseconds: 1);
  sleep(a);
  return 1;
}

//async and await
void checkVersion() async {
  var a = await versionApi();
//在一个异步方法内可以使用多次 await 表达式。

//await 配合 try catch
  try {
    a = await versionApi();
  } catch (er) {
    print(er);
  }
}


// generics function
T check<T, R>(List<R> list) {
  return list[0] as T;
}

void main() {
  var names = new List<String>();
  names.addAll(["one", "two"]);
  // names.addAll([1,2,3]);
  print(names);

  //Using collection literals（使用集合字面量）
  var citys = <String>["hangzhou", "shanghai"];
  const map = <num, String>{1: "one"};

  print("the map 1 is ${map[1]}");

  // collection use generics
  var set1 = new Set<String>();
  var keys = new Map<String, num>();
  keys["cocoa"] = 123;
  print("the keys is ${keys}");

  var tag1 = citys is List<int>; //false
  print("the tag1 ${tag1}");

  // new Cache<String>();
  new Cache<Person>();

  // new Document();
  File myFile = new File('classes.dart');

  myFile.exists().then((re) {
    print(re);
  });

  num a = 10;
  print("type is ${a.runtimeType}");
}
