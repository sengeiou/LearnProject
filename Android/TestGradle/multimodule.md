### 多模块构建

#### 多模块构建的结构
> 通常情况下， 一个工程包含多个模块。 settings.gradle 用来告诉 gradle ，项目下有哪些模块。
每个模块都有其独立的 build.gradle 文件

大致的结构如下:

```
 project
   ├─── setting.gradle
   ├─── build.gradle
   ├─── app
   │    └─── build.gradle
   └─── library
        └─── build.gradle

```

在 setting.gradle 文件下 则应该是这样的

```
include ':app', ':library'
```

然后为了保证 app 模块添加了 library 模块做为依赖，需要在 app 的  build.gradle 文件中添加下面的内容

```
dependencies {
      compile project(':library') 
}
```


另一种情况，如果你的模块中包含了子模块，可以参考下面的例子：

比如项目的结构为
```
project
├─── setting.gradle
├─── build.grade
├─── app
│    └─── build.gradle
└─── libraries
     ├─── library1
     │    └─── build.gradle
     └─── library2
          └─── build.gradle
```


则在 settings.xml 中这么定义

```
include ':app', ':libraries:library1', ':libraries:library2'
```

如果要在 app 中引用 library1 ,那么可以这么定义：

```
dependencies {
       compile project(':libraries:library1')
}
```




#### 构建生命周期
> 构建的生命周期，即构建的基本过程

初始化，gradle 会去寻找 settings.gradle 的文件，如果文件不存在，那么gradle就会假定你只有一个单独的构建模块。如果你有多个模块，settings.gradle文件定义了这些模块的位置。
如果这些子目录包含了其自己的build.gradle文件，gradle将会运行它们，并且将他们合并到构建任务中。这就解释了为什么你需要申明在一个模块中申明的依赖是相对于根目录。


#### 模块tasks



#### 加速构建
> 理论上构建多模块时，gradle 会依次执行所所有模块，当电脑的性能很好的时候的，可以使用多线程构建，默认是关闭的

如果要想要开启parallel构建，可以在grade.properties文件中配置：

```
org.gradle.parallel=true

```


#### 模块耦合

即你可以在一个模块中引用其他模块的属性，但是我不建议你们这么做，我们完全可以在根目录下的build文件中定义这些属性。






