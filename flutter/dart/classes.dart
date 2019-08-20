class Point {
  num x;
  num y;

  @override
  String toString() {
    return "the x is ${x} and y is ${y}";
  }

  // Point(num x , num y){ // 这里的代码可以简化成下面的
  //   this. x = x;
  //   this. y = y;
  // }

  Point(this.x,this.y);
   //构造函数不会继承  
  //Default constructors（默认构造函数）
  //如果你没有定义构造函数，则会有个默认构造函数。 默认构造函数没有参数，并且会调用超类的 没有参数的构造函数。

  //Named constructors（命名构造函数）
  Point.fromJson(Map data): x = data['x'], y = data['y'] {
    print("from json ${x} ${y}");
  }

  // Point.fromJson(Map json) {  //这是一个命名构造函数的标准写法，上面的是简写
  //   x = json['x'];
  //   y = json['y'];
  // }

  // 重定向构造函数，就是重载构造函数
  Point.alongXAxis(num x) : this(x, 0);


  // 工厂方法构造函数 , 没看懂咋用，延后
  // factory Pointer(String name){
  //      if(name == 'xx'){
  //        return new Point(10, 10);
  //      }   
  //      return new Point(1,1);
  // }

  // 实例函数
  num testMethod(Point point){
      return point.x - this.x;
  }


  // Getters and setters

  


}


class Person{
  String firstName;
  Person.fromJson(Map data){
    print("in person");
  }
}

class Employee extends Person{
    Employee.fromJson(Map data) :super.fromJson(data){
      print("in employee");
    }
}

class ImmutablePoint{
  final num x;
  final num y;
  const ImmutablePoint(this.x ,this.y);
  //Constant constructors（常量构造函数）
  // static final ImmutablePoint immutablePoint = const ImmutablePoint(0, 0);
}

class Rectangle {
  num left;
  num top;
  num width;
  num height;

  Rectangle(this.left, this.top, this.width, this.height);

  // Define two calculated properties: right and bottom.
  num get right  => left+ width;
      set right(num v) => left = v -width;
}


void main(){
      var p1 = Point(1,2);
      p1.x = 109;

      var pNull;  
      pNull?.x = 10; // 类似可选类型的操作, ? 避免对象为null 时报错


      print("the point is ${p1}");

      var emp = new Employee.fromJson({});

      (emp as Person).firstName = "123";

      var map = {
        'x' : 123,
        'y' : 123
      };

      var p2 = Point.fromJson(map);

      //使用常量构造函数 可以创建编译时常量，要使用常量构造函数只需要用 const 替代 new 即可：
      const xx = const ImmutablePoint(1,1);
      const yy = const ImmutablePoint(1,1);
      //Check whether two references are to the same object.
      print("identical ${identical(xx, yy)}");
      print("runtimeType ${xx.runtimeType}");

      // 没看明白常量构造函数啥用


      var r1 = Rectangle(10,101,1012,100);
      r1.right = 9999;
      print("the right = ${r1.left}");
}