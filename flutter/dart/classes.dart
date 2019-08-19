class Point {
  num x;
  num y;

  @override
  String toString() {
    return "the x is ${x} and y is ${y}";
  }

  // Point(num x , num y){
  //   this. x = x;
  //   this. y = y;
  // }

  Point(this.x,this.y);

  Point.fromJson(Map data): x = data['x'], y = data['y'] {
    print("from json ${x} ${y}");
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






void main(){
      var p1 = Point(1,2);
      p1.x = 109;
      print("the point is ${p1}");

      var emp = new Employee.fromJson({});

      (emp as Person).firstName = "123";

      var map = {
        'x' : 123,
        'y' : 123
      };

      var p2 = Point.fromJson(map);

}