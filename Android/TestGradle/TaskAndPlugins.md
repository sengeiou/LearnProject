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
> 当你开发 app 的时候，会使用你私有的 keystore 打包，根据前面的章节，你会这么定义：

```
android {
    signingConfigs {
        release {
                storeFile file("release.keystore")
                storePassword "password"
                keyAlias "ReleaseKey"
                keyPassword "password"
        } 
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
        }
    } 
}
```

如果是个共有仓库，当你把你这份 gradle 文件上传到仓库时，那么所有人都知道了你的 keyPassword
那么有一个好办法，使用密钥的配置文件和这个gralde 文件进行分离

在项目的根目录下创建 private.properties 文件
添加下面的配置
```
release.password = 你的真实密钥
```

然后在 build.gradle 下面创建一个 getReleasePassword 的 task

```
    task getReleasePassword << {
        def password  = ''
        if (rootProject.file('private.properties').existes()){
            Properties properties = new Properties();
            properties.load(rootProject.file('private.properties').newDataInputStream());
            password = properties.getProperty('release.password')
        }
    }
```



### hook Android 插件

先来看下一些特殊的 android 构建钩子

使用 applicationVariants 获得构建的变种集合，一旦你得到了变种的引用，那么就可以访问和操作它们的属性，
比如 名字，描述 等等。

使用 libraryVariants 则可以操作 Android library。


```
    android.applicationVariants.all { variant ->
        // de something
    }
    
```


关于 each  和 all 的区别

Notice that we iterate over the build variants with all() instead of the each() method that we mentioned earlier. This is necessary because each() is triggered in the evaluation phase before
the build variants have been created by the Android plugin.
The all() method, on the other hand, is triggered every time
a new item is added to the collection.


这个 hook 可以用来在 apk 保存前修改名字，可以用来给 apk 的名字加上版本号。就是可以动态的修改apk的名字，



### 动态修改 apk 的名字
> 用户一般都会在打包好 apk 后重新命名，比如加上版本号，变种，时间 等等，在这个小节，
修改 outputFile 属性，来动态的修改 apk 的名字


```

// 在 app 的 build.gradle

android.applicationVariants.all { variant ->
    variant.outputs.each { output ->
        def file = output.outputFile
        output.outputFile = new File(file.parent, file.name.replace(".apk","-V${variant.versionName}"+"-"+new Date().format("yyMMdd-HH:mm")+".apk"))
        //app-free-release-1.0-171114-10:31.apk  当然你也可以替换掉 app-free-release 这一部分
    }
}
```

每个构建变种都有 outputs 的集合，在android app 中就是 apk，每个output 对象都有一个 outputs 的文件，
上面的代码做的就是去修改这个文件名。


### 动态的创建新的任务 (有点不理解，暂时跳过，貌似是命令行安装app 后并运行)

> 我们可以在配置阶段创建自己的任务，基于 android 的构建变种上，
为了做个示范，我们将创建一个任务，不只是 install ，它运行在 app 的各个构建变种上，install 任务只是android插件的一部分，
如果你使用命令行  installDebug 安装你的app，在安装好后需要手动的启动。


我们需要提早 hook applicationVariants 的属性


### 创建你私有的插件
> 如果你想在你的多个项目中复用一些 gradle 任务插件,那么你可以创建自定义的插件，这样就可以复用，并且可以分享给他人使用。
  插件可以用 groovy 编写，也可以用别的 JVM 语言，比如 java 或 scala ，但是，大部分情况下，都是用 groovy 编写的，
  

### 创建简单的插件
>  创建插件，新建一个新的 class 去实现 Plugin 接口, 我们会使用这个章节里的代码。就是那个动态创建 run 任务的代码。

```
class RunPlugin implements Plugin<Project> {
     void apply(Project project) {
        project.android.applicationVariants.all { variant -> 
            if (variant.install) {
            project.tasks.create(name: "run${variant.name.capitalize()}", dependsOn: variant.install) {
               // Task definition
            }
} 
}
} 
}
```

Plugin 接口定义了 apply 方法，当你的插件去build 的时候， gradle 会去调用这个方法，

为了使插件起作用，我们需要在 build.gradle 中加入下面的代码

```
     apply plugin : RunPlugin  // 没看懂，放在哪里
```


### 分发插件
> 如果要把插件分享给别人，你需要创建一个单独的 module ， 一个单独的插件有自己单独的 build 文件去配置依赖和分发，
这个 module 会生成一个 JAR,  包含了插件的 classes 和属性，你可以在多个项目中使用这个 JAR，也可以分享给别人。

在插件的 build.gradle 中添加下面的配置

```
apply plugin: 'groovy'

dependencies {
       compile gradleApi()
       compile localGroovy()
}

```


第一行： 如果我们要使用 groovy 编写插件，我们要应用 groovy 的插件，这个 groovy 插件继承了 java 的插件，
同时支持了 java 和 groovy，所以你可以混合使用它们，你可以使用 groovy 继承 java 的 class，这很爽！！！

然后看下面的 dependencies ,这些是默认的配置 

compile gradleApi()     gradle API 需要访问 gradle 的命名空间
compile localGroovy()  分发groovy SDK

我们也可以在下面加上自己的配置
```
    compile 'com.android.tools.build:gradle:2.2.0'
    compile 'org.javassist:javassist:3.20.0-GA'
```


如果你需要分发你的插件，必须要加上下面的配置
```
group = 'com.gradleforandroid'
version = '1.0'
```

一个大致的build.gradle 可以看 runplug 下的配置文件


一个单独的插件模块的目录结构见下图：

```
plugin
   └── src
       └── main
            ├── groovy
            │       └── com
            │            └── package
            │                    └── name   // 放代码
            └── resources
                    └── META-INF
                        └── gradle-plugins  // 放配置文件

```


然后在包下创建 RunPlugins.groovy
添加下面的代码
```
    package com.gradleforandroid
   import org.gradle.api.Project
   import org.gradle.api.Plugin
   class RunPlugin implements Plugin<Project> {
       void apply(Project project) {
           project.android.applicationVariants.all { variant ->
               // Task code
     } }
}
```


接着添加配置文件
在 src/main/resources/META-INF/gradle-plugins/ 下面添加配置文件
文件的命名是 packageName.properties

然后 加上下面的代码
implementation-class=packageName.主的groovy 文件 （可以理解为主入口）

例子：
```
   implementation-class=com.gradleforandroid.RunPlugin
```

配置文件一般只需要加这句话就行


当所有的东西配置好后。你可以使用 gradlew assemble ，这个命令会创建 jar 到 output 目录下，
如果你想推送到 maven 仓库，你可以在 build.gradle 添加

```
apply plugin: 'maven'
Next, you need to con gure the uploadArchives task, like this:
   uploadArchives {
       repositories {
           mavenDeployer {
             repository(url: uri('repository_url'))
}
}
}

```

然后再运行 uploadArchives 

当然我的demo 中， 没有上传到仓库，而是输出到本地 FinalRun 下
 
关于怎么上传到maven 仓库，准备开个章节写下
 
 
 
### 使用自定义的插件 （真实的代码可以在项目根目录下的 build.gradle 中找到）

> 要使用插件，我们需要在 buildscript 代码块中加入依赖，
首先，要配置新的仓库
第二，要在 dependencies 加入你的 classpath 

比如下面的代码：
```
buildscript {
       repositories {
           flatDir { dirs 'build_libs' }
       }
       dependencies {
           classpath 'com.gradleforandroid:plugin'
} }


```

然后，需要应用插件

```
apply plugin: com.gradleforandroid.RunPlugin
```
 
 
# 这一章节大致学完了，还是得配置 gradle 一起在看下