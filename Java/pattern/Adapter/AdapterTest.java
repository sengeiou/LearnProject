
/**
大致介绍下个人对适配器模式的理解
target






*/


public class AdapterTest{
public static void main(String[] args){


  //我的

  System.out.println("我的");

  Target t = new Person();
  t.request();

  Target t1 = new Adapter();
  t1.request();

}
}
