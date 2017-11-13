### 任务和插件


#### 理解 groovy

可以在根目录下运行 ./gradlew taskTest  
```
// 这里的代码可以在本项目的根目录的 build.gradle 找到

// 定义class 不用申明set 和 get 方法
class Person{
    String name
}

// 不同申明返回类型和 return 关键字，
def square(def num){
    num * num  
}

// https://segmentfault.com/a/1190000004276167 中文文档
task taskTest << {
    println "cocoa test"// 基本的输出

    def name1 = "cocoa"  // 定义变量，不用申明变量类型，应该是动态类型
    println "$name1"     // $必须是字符串中使用

    def cocoa = new Person()  // 创建对象
    cocoa.name = "$name1"
//    cocoa.setName()
    println cocoa.getName()  // 自动生成的get set 方法

    println square(10)

    List list = [1,2,3,4,5]
    list.each (){ element ->
        println element
    }
}
```




####  开始学习任务 


##### 定义任务 
> 任务是一个项目对象，所有的任务都实现了 Task 的接口，一个最简单的定义任务的方法

```
 task hello 
```

但是上面的代码不会做任何的东西
你可以加入下面的代码来做一些事， 比如：

```
task hello{
    println "Hello Would!"
}
```

然后执行下面的命令

```
$ gradlew hello
  
  Hello Would!
  :hello
  
```

Hello Would! 在任务打印前就执行了，这里有一个概念， gradle 的 build 有三个阶段：

* 初始化阶段
* 配置阶段
* 执行阶段

最上面的代码实际在配置阶段，如果你想在执行阶段加入你的事件，可以这么做

```
    task hello << {
        println "execution"
    }
```


最后的代码，你可以这么写来测试下每个阶段的输出

```

task hello << {
  println 'Execution'
}
hello {
  println 'Configuration'
}

```

最后的输出：（很好理解，不解释了）

```
$ gradlew hello
Configuration
:hello
Execution

```



Groovy 有很多的语法缩写，这里有几个方法去创建任务：

```
 task(hello) << {
    println 'hello'
 }  
    
 task('hello') << {
    println 'hello'
 }   
 tasks.create(name : 'hello')  << {
    println 'hello'
 } 

```

最上面的两个代码块用两个不同的方式做了同样的事情，括号 和 单引号 都是可选的，在这两个代码块中，我们可以这么去理解，
一个任务有两个参数，一个任务的名字，另一个则是代码块

最后的代码块则是调用了 TaskContainer 的 create 的方法



### 剖析任务
Task 接口是所有任务的基础，它定义了很多属性和方法，所有任务其实是实现了 DefaultTask 这个类，当你创建了新的任务，
其实也是基于 DefaultTask 的。

在任务执行的时候，所有的action 都是按顺序执行的， 你可以使用 doFirst 和 doLast ，这两个方法可以定义最先执行和最后执行的任务
这个很有用

```
// 这里的代码可以在本项目的根目录的 build.gradle 找到

taskTest  {
    println "config"

    doLast {
        println "im doLast"
    }

    doFirst{
        println "im doFirst"
    }

}

```

全部的输出：

```
config
Incremental java compilation is an incubating feature.
:taskTest
im doFirst
cocoa test
cocoa
cocoa
100
1
2
3
4
5
im doLast

```



如果你的任务里多个 doLast 和 doFirst 
```
  task mindTheOrder {
     doFirst {
       println 'Not really first.'
     }
     doFirst {
       println 'First!'
     }
     doLast {
       println 'Not really last.'
     }
     doLast {
       println 'Last!'
     } 
}

```

执行的结果是：
```
$ gradlew mindTheOrder
:mindTheOrder
First!
Not really first.
Not really last.
Last!

```

可以看出，doFirst 是先写的后输出， doLast 则是 先写的先输出


多个任务要顺序的执行，你可以使用  mustRunAfter 方法

```
task task1 << {
    println 'task1'
}
task task2 << {
    println 'task2'
}
task2.mustRunAfter task1

```

然后执行：

```
$ gradlew task2 task1
:task1
task1
:task2
task2
```



### 使用 task 简化 release 过程