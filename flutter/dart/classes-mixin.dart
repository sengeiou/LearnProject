

mixin Runner{    // 使用mixin 定义来定义
    bool canRun = false;
    void run(){
        print("im running");

    }
}

class Human{

}

class Person extends Human with Runner{    //with 来支持 Mixin
    
    static num max_age= 200;  // 静态成员方法

    num age = 10;

    static void printMsg(){
        print("this is ${max_age}");
    }

} 


void main(){


  var r1 = Person();
  r1.run();

  print(Person.max_age);


}
