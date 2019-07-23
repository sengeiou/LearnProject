## 依赖管理

> 关于 aar 的不是很懂，需要在看下资料，这里以主的进度为紧要任务



### 仓库
> 仓库一般指的是远程的仓库，一个仓库可以被视为一些文件的集合体。

* 在 Android studio 中，已经为你准备了默认的仓库

```
repositories {
    jcenter()  // 这里使用的是jcenter 的仓库
}
```


* Gradle支持三种不同的仓库，分别是：Maven和Ivy以及文件夹。 当你在dependencies 中添加了依赖包时，你需要执行build 构建(实际工作中，使用 sync project)
  gradle 会为你下载依赖，并且缓存， 所以一个特定版本的依赖包只需要下载一次。
  
* 一个依赖需要定义三个元素：group，name和version。group意味着创建该library的组织名，通常这会是包名，name是该library的唯一标示。version是该library的版本号。
```
dependencies {
       compile 'com.google.code.gson:gson:2.3'
       compile 'com.squareup.retrofit:retrofit:1.9.0'
}

上述的代码是基于groovy语法的，所以其完整的表述应该是这样的：

dependencies {
      compile group: 'com.google.code.gson', name: 'gson', version:'2.3'
      compile group: 'com.squareup.retrofit', name: 'retrofit'
           version: '1.9.0'
     }
     

```




#### 预定义仓库

* Gradle会默认预定义三个maven仓库：Jcenter和mavenCentral以及本地maven仓库。你可以同时申明它们：

```
repositories {
       // 一般情况下，没有必要定义这么多仓库
       mavenCentral()
       jcenter()   // 推荐使用这个仓库， jcenter 支持了 https ，jcenter是maven中心库的一个分支
       mavenLocal()
   }
   
```


#### 远程仓库

* 如果创建了私有的仓库，则需要这么使用

```
repositories {
       maven {
           url "http://repo.acmecorp.com/maven2"    // 加上 url
       }
}

repositories {
       maven {
           url "http://repo.acmecorp.com/maven2"
           credentials {  // 如果有访问权限，还可以这么做
               username 'user'
               password 'secretpassword'
           }
        } 
   }
   
```

#### 本地依赖

*  如果想添加 jar 文件作为依赖 ， 可以这么写

```
dependencies {
       compile files('libs/domoarigato.jar')
}

如果有很多的jar包时，你可以改写为：

dependencies {
       compile fileTree('libs')
}

// Android Stidio 默认的默认创建，也是添加所有在 libs 文件夹中的 jar。
dependencies {
       compile fileTree(dir: 'libs', include: ['*.jar'])
}
 
```

*  native 包（so 包），用c或者c++写的library会被叫做so包，Android插件默认情况下支持native包，你需要把.so文件放在对应的文件夹中：
                 
```
app
   ├── AndroidManifest.xml
   └── jniLibs
       ├── armeabi
       │   └── nativelib.so
       ├── armeabi-v7a
       │   └── nativelib.so
       ├── mips
       │   └── nativelib.so
       └── x86
           └── nativelib.so
```


* aar 文件
> 如果你想分享一个library,该依赖包使用了Android api，或者包含了Android 资源文件，那么aar文件适合你。依赖库和应用工程是一样的，
你可以使用相同的tasks来构建和测试你的依赖工程，当然他们也可以有不同的构建版本。应用工程和依赖工程的区别在于输出文件，
应用工程会生成APK文件，并且其可以安装在Android设备上，而依赖工程会生成.aar文件。该文件可以被Android应用工程当做依赖来使用。


* 创建和使用依赖工程模块
> 我们有两种方式去使用一个依赖工程。一个就是在你的工程里面，直接将其作为一个模块，另外一个就是创建一个aar文件，这样其他的应用也就可以复用了。

1. 如果你把其作为模块，你可以在 TestGradle 项目的  setting.gradle 和 app 下的 build.gradle 文件查看下面的例子
```
      //在settings.gradle文件中添加其为模块：(个人理解就是激活了这个模块)
      include ':app', ':mylibrary'    
```      
   
   
```
     // 如果你想使用该模块，你需要在你的依赖里面添加它，就像这样: (个人理解就是真正引用这个模块)
     dependencies {
          compile project(':mylibrary')
     }
```


2. 如果你想复用你的library，那么你就可以创建一个aar文件，并将其作为你的工程依赖。当你构建你的library项目，
aar文件将会在 build/output/aar/下生成。把该文件作为你的依赖包，你需要创建一个文件夹来放置它，我们就叫它aars文件夹吧，
然后把它拷贝到该文件夹里面，然后添加该文件夹作为依赖库：
```
repositories {
    flatDir {
        dirs 'aars' 
    }
}
```
```
 //这样你就可以把该文件夹下的所有aar文件作为依赖，同时你可以这么干：
 dependencies {
       compile(name:'libraryname', ext:'aar')
}
```
这个会告诉Gradle，在aars文件夹下，添加一个叫做libraryname的文件，且其后缀是aar的作为依赖。



### 依赖的概念

#### 配置
(不是很理解)
>有些时候，你可能需要和sdk协调工作。为了能顺利编译你的代码，你需要添加SDK到你的编译环境。
你不需要将sdk包含在你的APK中，因为它早已经存在于设备中，所以配置来啦，我们会有5个不同的配置：

* compile  是默认的那个，其含义是包含所有的依赖包，即在APK里，compile的依赖会存在。
* apk  apk中存在，但是不会加入编译中，这个貌似用的比较少。
* provided 提供编译支持，但是不会写入apk。
* testCompile testCompile和androidTestCompile会添加额外的library支持针对测试。
* androidTestCompile  testCompile和androidTestCompile会添加额外的library支持针对测试。


#### 动态版本

>在一些情形中，你可能想使用最新的依赖包在构建你的app或者library的时候。实现他的最好方式是使用动态版本。我现在给你们展示几种不同的动态控制版本方式：
（但是使用动态版本的时候一定要注意，最新的版本的不一定是稳定版，而且不一定和现在的代码兼容，个人不推荐使用）

```
dependencies {
       compile 'com.android.support:support-v4:22.2.+'
       compile 'com.android.support:appcompat-v7:22.2+'  
       compile 'com.android.support:recyclerview-v7:+'
}
// 注意区分第1行和第2行的.

第一行，我们告诉gradle,得到最新的生产版本。
第二行，我们告诉gradle，我们想得到最新的minor版本，并且其最小的版本号是2. 
第三行，我们告诉gradle,得到最新的library。

```


####  Android studio UI操作依赖库 

> 右键 project 的 Module setting ， 打开 dependenices ，就可以使用 GUI 的方式添加依赖





