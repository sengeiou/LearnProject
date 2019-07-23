### 申明与访问控制

1. 每个源代码文件只能有一个 public 类。
2. 如果文件中有一个 public 类，那么文件名必须与 public 类同名。
3. 一个文件可以具有多个非公共类，就是除了 public 类，可以的类可以定义多个，但是这些类不能同名。
4. java 中有4种访问控制的方法，public protected private 默认，如果不显示的申明这三个，就是默认的。
5. 申明类只能使用 public 和 默认访问。
6. 


### 下面看下这四种访问控制

* 默认访问权限，不写任何的修饰符就是默认的访问控制，默认访问就是包级访问。
  
  ```
  //在 test.pkg 包下创建 TestParent 
  // 注意 java 中，每个源文件只能有一个 public 类，并没有说一定要有 public 类
   class TestParent {
    
    }
    
  // 然后在 Test 中使用  ，但是会编译出错，除非在 class TestParent 前加上 public
  package com.cocoa.base.scjp.lesson1;
  
  import test.pkg.TestParent;
  
  public class Test extends TestParent {
  
      public static void main(String[] args) {
  
      }
  }

  ```

*  public 公共访问，所有类都具有访问 public 的权限，当然不同的包下，你还是需要 import 。



  