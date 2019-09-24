package test;
import java.lang.reflect.*;

public class LogHandler implements InvocationHandler{

  public Object o ;

  public LogHandler(Object o){
    this.o = o;
  }

  public Object invoke(Object proxy,Method method, Object[] args){

      System.out.Println("this log start");
      try{
          method.invoke(o);
      }catch(Exception e){
      }

      System.out.Println("this log end");

  }

}
