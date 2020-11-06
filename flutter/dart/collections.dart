void main() {
  List list1 = [1, 2, 3];

  var list3 = List<int>();
  list3.add(11);
  print(list3);

  var list2 = new List();
  list2.add(1);

  const list0x23 = [1, 2, 3];
  // list0x23[1] = 12;   // 这里是不能修改的

  var list0x33 = const [1, 2, 3]; // 用const 修饰常量数组
  // list0x33[1] = 123;   //  这里也是不能修改  Unsupported operation: Cannot modify an unmodifiable list
  // print("the list0x33 == ${list0x33}");

  list2.length;
  list2.isEmpty;
  list2.isNotEmpty;

  list2.addAll([2, 3, 4, 5]);
  var result = list2.reversed;
  print(result);

  print(list2.indexOf(2));

  print(list2.remove(1));

  list2.fillRange(0, 1, 999);
  print(list2);

  list2.fillRange(0, 2, [8988, 909]);
  print(list2);

  print(list2.join("--"));

  var set = Set<int>();
  set.add(1);
  set.add(1);
  set.add(3);
  set.add(4);
  set.add(5);

  print("the set type is ${set.runtimeType}");

  print(set);

  var set2 = {1, 2, 3};

  print(set2);

  var tt1 = [1,3];  // 这是一个list
  var tt2 = {1,23}; // 这是一个set 准确说  LinkedHashSet
  print("tt1 ${tt1.runtimeType}");
  print("tt2 ${tt2.runtimeType}");

  var m = {'age': 12};

  var map = new Map();
  map['name'] = "co";
  map['age'] = 12;

  print(map.keys.toList());

  var a1 = map.containsKey("name");
  var a2 = map.containsValue(12);
  print("object result = ${a1}  ${a2}");

  var a3 = list1.map((value) {
    return value * 2;
  });
  print(a3);



}
