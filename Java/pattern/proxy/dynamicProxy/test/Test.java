package test;
import java.lang.reflect.*;

public class Test{

    public static void main(String[] args){

      User user = new User();

      InvocationHandler h = new LogHandler(user);


      Logger logger = (Logger)  Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{Logger.Class}, h);

      logger.log();



    }


}
