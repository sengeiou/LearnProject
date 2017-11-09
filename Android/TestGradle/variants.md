## 创建构建变种 （很重要）



### 创建自己的构建版本
> 当默认的构建版本不够用的时候，可以在 buildTypes 下自己创建新的构建版本

```
//Staging这个构建版本的 application id 就是: com.package.staging

android {
    buildTypes {
        staging {
            applicationIdSuffix ".staging"  // 在原来的 application id 后加上.sraging
            versionNameSuffix "-staging"   // 还可以修改 versionName
            buildConfigField "String", "API_URL",
            "\"http://staging.example.com/api\""
         }
    }
}

// 按照上面的写法，你可以在设备上安装 release 和 staging 两个版本

```


同时， buildType 下的配置是支持继承的

```
android {
       buildTypes {
           staging.initWith(buildTypes.debug) // staging 继承了 debug 的配置
           staging {
               applicationIdSuffix ".staging"
               versionNameSuffix "-staging"
               debuggable = false
           } 
        }
}
```


### Source sets  依赖包  不常用， 不理解


### product flavors
注意区分 buildType 
product flavors 用来为一个 app 创建不同的版本。 举个例子， 收费版和免费版，dev 的收费版 和 dev 的免费版



#### 创建 product flavors
```
android {
    productFlavors {
        red {
             applicationId 'com.gradleforandroid.red'
             versionCode 3
        }
        blue {
             applicationId 'com.gradleforandroid.blue'
             minSdkVersion 14
             versionCode 4
        }
    }
}
```

看例子

```
productFlavors {
        free {
            // 类似 buildType 
            buildConfigField "String", "pf_buildConfigField", "free_build" 
            resValue "string", "pf_value", "free"   // string 小写
            // 配置manifest 的 meta , 实在 application 下的
            manifestPlaceholders = [
                   "NAME"      : "free123"  
            ]
        }

        paid {
            // 类似 buildType 
            buildConfigField "String", "xxxx", "paid_build" 
            resValue "string", "pf_value", "paid" 
            // 配置manifest 的 meta
            manifestPlaceholders = [
                    "NAME"      : "paid123"
            ]
        }

}

在  AndroidManifest.xml 下定义 ,就可以动态的修改 meta-data
<meta-data android:value="${NAME}" android:name="XXX_ID"/>

```



#### as 也提供了 GUI 的方式选择变种，在ide 的左下角



####变体过滤器
>忽略某个变体也是可行的。这样你可以加速你的构建当使用assemble的时候，这样你列出的tasks将不会执行那么你不需要的变体。你可以使用过滤器，在build.gradle中添加代码如下所示：

```        
android.variantFilter { variant ->
       if(variant.buildType.name.equals('release')) {
           variant.getFlavors().each() { flavor ->
               if (flavor.name.equals('blue')) { 
                variant.setIgnore(true);
                }
        }
    }
}

```


#### 签名配置

在你发布你的应用之前，你需要为你的app私钥签名。如果你有付费版和免费版，你需要有不同的key去签名不同的变体。这就是配置签名的好处。配置签名可以这样定义

```
  android {
       signingConfigs {
           staging.initWith(signingConfigs.debug)
           release {
               storeFile file("release.keystore")
               storePassword"secretpassword"
               keyAlias "gradleforandroid"
               keyPassword "secretpassword"
           }
      }
}
```

然后这么去使用它们

```
android {
       buildTypes {
           release {
               signingConfig signingConfigs.release
           } 
       }
}
上例使用了buildTypes，但是你可能需要对每个版本生成不同的验证，你可以这么定义：
android {
       productFlavors {
           blue {
               signingConfig signingConfigs.release
           }
       }
}
```

然而 ，在 flavors 定义的签名会被重写，所以在上面的例子中 buildType 的级别最高
当然，你可以这么去处理，（如果有需要，可以参考，我暂时还没想到场景）

```
android {
       buildTypes {
           release {
               productFlavors.red.signingConfig signingConfigs.red
               productFlavors.blue.signingConfig signingConfigs.blue
           }
       }
}
```





### 个人实验总结：
> 关于 buildTypes 的配置

* sigingConfigs 必须在 buildType 前面申明，不然会出现找不到配置
* debug 签名信息可以不用申明，别的申明也可以使用 debug 的申明，比如下面的 dev
* 在 buildType 中，除了 debug ， 别的type 都要显示的申明 signingConfig , 不然会出现无法运行的问题

```
android {
  
    // 省略了某些配置，主要解释重点的
  
    // 必须在 buildTypes 前申明
    signingConfigs {
        
        // debug 可以不用申明，会有默认的签名
        // dev 用了 debug 的签名
        dev.initWith(signingConfigs.debug)

        // 申明 release 的签名信息
        release {
            storeFile file("../store/kqc.keystore")
            storePassword "kqc8888"
            keyAlias "kqc"
            keyPassword "kqc8888"
            v2SigningEnabled true
        }
    }


    // 方法定义了如何构建不同版本的app
    buildTypes {
        release {
            resValue "string", "appName", "release_appname"   // 见 readme.md
            buildConfigField "boolean", "LOG_DEBUG", "false"  // 见 readme.md
            buildConfigField "String","appurl","\"http://www.release.com\""
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            signingConfig signingConfigs.release  // release 必须要加上这一句
        }

        debug{
            resValue "string", "appName", "debug_appname"
            buildConfigField "boolean", "LOG_DEBUG", "true"
            buildConfigField "String", "appurl", "\"http://www.debug.com\""
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }

        dev{
            resValue "string", "appName", "dev_appname"
            buildConfigField "boolean", "LOG_DEBUG", "true"
            buildConfigField "String", "appurl", "\"http://www.developer.com\""
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            signingConfig signingConfigs.dev
        }
    }
}

```