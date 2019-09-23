void main(){
      // dart 数字类型 分 int 和 double 类型

      var x = 1;
      var y = 1.2183;
      
      // 这里很奇怪，不能赋值给 const one
      var one = int.parse('1');
      var r1 = double.parse('1.2');


      print("the y toString is ${y.toStringAsFixed(2)}");

      // var error  = int.parse("xxx");  //报错    

      print("the result is $one $r1");

      // 字符串支持相邻的拼接，niubility
      var msg  = "this is sample message" 'asdasdsa';
      var msg1 = msg + "and the one = $one";

      var msg2 = '''
          1231232131231  
          132131231231
            312313123213123
      ''' ;   


      print(msg1);
      print(msg2);

      var b1 = true;
      var b2 = msg.isEmpty;

      print("boolean type b1 = $b1 b2= $b2");


      var  list = [1,23,3];
      print("the list is $list");
      var  length = list.length;
      var re = "the lenght is $length";
      print(re);  

      var  map1 = {
        "one": 1,
        "two":2
      };
      print("the map is $map1");
      var two  = map1['two'];  
      print('two is $two');

      var hasThree = map1['three'] != null;
      print("map1 has three = $hasThree");


      num a = 10;
      int a1 = 1;
      double b12 = 1.2;
      String name  = "123";
      bool b = true;
      

}
