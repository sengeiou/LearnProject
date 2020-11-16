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

class Logger{
  final String name;
  bool mute = false;

  Logger._internal(this.name);
  // 工厂方法构造函数
  factory Logger(num len){
      return new Logger._internal(len.toString());    
  }
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



// Abstract methods（抽象函数）
//使用 abstract 修饰符定义一个 抽象类—一个不能被实例化的类。 
//抽象类通常用来定义接口， 以及部分实现。如果你希望你的抽象类 是可示例化的，则定义一个 工厂 构造函数。
abstract class Doer{
    void doSomething();
}

class EffectiveDoer extends Doer{
      void doSomething(){
      }
}

// 在 dart 中， 操作符也可以被重写


class PersonXX{
  final _name;
  PersonXX(this._name);
  String greet(who) => "PersonXX Hello $who $_name";
}

class Imposter implements PersonXX{   // 可以实现多个接口
  final _name = "";
  String greet(who) => "Imposter Hello $who $_name";
}

greetBob(PersonXX person) => person.greet("bob");

//使用 extends 定义子类， super 引用 超类：
//@override 注解来 表明你的函数是想覆写超类的一个函数：


// 定义枚举类型
enum Color{
  red,
  green,
  blue
}
// 枚举类型中的每个值都有一个 index getter 函数， 该函数返回该值在枚举类型定义中的位置（从 0 开始）。 例如，第一个枚举值的位置为 0， 第二个为 1.
class Util{
    void printf(){
        print("this is util print");
    }
}
// 使用 with 进行mixins 功能扩展
// 注意，定义一个类继承 Object，该类没有构造函数， 
//不能调用 super ，则该类就是一个 mixin ，但是1.13  版本后就没有这些限制了
// 上面的Util 就是一个mixin 类
class Test with Util{

}



// 类变量和函数
class ColorXX{
  static const red = const ColorXX("red");

  final name;
  const ColorXX(this.name);

  static void println(String msg){
        print(msg);
  }

}



void main(){
      var p1 = Point(1,2);
      p1.x = 109;

      var pNull;  
      pNull?.x = 10; // 类似可选类型的操作, ? 避免对象为null 时报错


      // var p2 = const Point(1, 1);
      
      if(p1 is Person){
        print("${(p1 as Person).firstName}");
      }


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


       print(greetBob(new PersonXX('kathy')));
        print(greetBob(new Imposter()));

        print("the red index is ${Color.red.index}");
        print("the blue index is ${Color.blue.index}");

        List<Color> colors = Color.values;
        for (var item in colors) {
            print("the color is ${item}");
        }  
        
        var t = new Test();
        t.printf();

        const red = ColorXX.red;
        print("the color name is ${red.name}");
        ColorXX.println("THIS IS STATIC METHOD");

        Point p12;

        print("p12 x  = ${p12?.x}");



}