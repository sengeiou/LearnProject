



void main(){
      try{
          func1();
      }on UnimplementedError{// 使用 on 来指定异常类型，使用 catch 来 捕获异常对象。
          print("got exception");
      }

      try{
          func1();
      }catch (e, s){     //使用 catch 来 捕获异常对象。 第一个参数为抛出的异常对象， 第二个为堆栈信息 (一个 StackTrace 对象)。
                         // 可以用一个参数，也可以用两个参数，（e）  (e,s)
          print("got exception $e \n$s");
      }

      try{
          test1();
      }catch (e){     
          print("捕获 rethrow 抛出的异常！！");
      }finally{
          print("finally 中的代码，不管有没有出现异常都会执行！！");
      }
     
}

void test1(){
     try{
          func1();
      }catch (e){     
          print("使用rethrow 重新抛出异常！！");
          rethrow;
      }
}



// 定义异常
void func1() => throw new UnimplementedError();
