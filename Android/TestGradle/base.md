> 参考资料  https://segmentfault.com/a/1190000004229002

### gradle task
#### 当你创建了一个Android工程，那么将包含Android tasks，build tasks，build setup tasks，help tasks，install tasks，verification tasks等。

#### 基本的任务

* ./gradlew assemble -为所有构建类型创建apk
* ./gradlew check 运行所有的检查，比如说Android Lint，如果发现问题可终止任务
* ./gradlew build 运行以上两个任务
* .s/gradlew clean -清除生成的apk

* ./gradlew connectedCheck - 在设备上运行测试
* ./gradlew deviceCheck - 远程设备运行测试
* ./gradlew installDebug/installRelease - 在设备商安装指定版本
* ./gradlew uninstall - 卸载


#### 一旦更改了 build.gradle 文件，就需要 sync project with gradle files

####  buildConfigField 和 resValue 的用法

```
 buildTypes {
        release {
            resValue "string", "AppName", "app1"   // 类型， 变量名，值 ，使用方法，暂时不知道
            buildConfigField "boolean", "LOG_DEBUG", "false" // 类型， 变量名，值 ，使用方法 例: BuildConfig.LOG_DEBUG
            buildConfigField "String","appurl","www.baidu.com"
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }

        debug{
            resValue "string", "AppName", "app1"
            buildConfigField "boolean", "LOG_DEBUG", "true"
            buildConfigField "String", "appurl", "www.qq.com"
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
}        
```