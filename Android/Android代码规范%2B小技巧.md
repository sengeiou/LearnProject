# Android代码规范+小技巧


### 配置篇

 - android:clipToPadding=false  设置滚动控件的padding可以随之滚动 ，配合paddingTop 使用

 - android:layout_weight 都用过，配合android:weightSum ,可以做出更加灵活的布局，比如一个按钮宽度占屏幕的60%，可以设置父空间的android:weightSum="1" 按钮设置为android:layout_weight="0.6"

 - layout的xml 命名  ：以xml类型+”_”开头

		example：activity_Login.xml   //activity
					fragment_home.xml       //fragment
			        item_adapter_order.xml   // adapter

 - 在xml使用xmlns:tools=http://schemas.android.com/tools ，方便调试，开发，  除了text之外，还可以使用visiable等属性
 ![除了text之外，还可以使用visiable等属性](http://img.blog.csdn.net/20151118153134632)



 - xml控件规范  	
  android:id 明显应该在layout文件中第一行
  android:style 放在最后一行

 - 单位
    文字大小的单位应该统一用sp，其他元素用dp。因为这两个单位是与设备分辨率无关的，能够解决在不同分辨率设备上显示效果不同的问题。

 - 如果设置layout_weight=1  那么你的layout_width或layout_height 就不要设置成“match_parent",设置成0dp以便在测量时做出更好的优化

 - xml的根目录为<FrameLayout>时，可以用 merge代替，因为activity的父元素就是FrameLayout。当Inflate以 merge 开头的布局文件时，必须指定一个父ViewGroup，并且必须设定attachToRoot为true（参看inflate(int,android.view.ViewGroup, Boolean)方法）

### 代码篇
 -  代码中，尽量少用反射相关的，少用枚举

 -  TextUtils
一个字符串处理的工具类。比如空判断TextUtils.isEmpty, 文本拼接TextUtils.concat, 统计字符串除去空格的长度TextUtils.getTrimmedLength 等等，没必要自己再写个类去实现了

 - 不要将Context 变量设置为static

 - 在activity中写内部类，一定要把内部类设置为static，非静态的内部类会持有外部类的引用

 - 保存sharedPreference时，建议用apply()代替commit()(不考虑线程安全的情况下);另外apply没有返回值，而commit返回boolean表明修改是否提交成功;

 - 遵守字段命名惯例:
  非public的、非static的字段名称以m开头。
  static字段名称以s开头。
  其它字段以小写字母开头。
  public static final字段（常量）全部字母大写并用下划线分隔。

		//example
		public class MyClass {
		    public static final int SOME_CONSTANT = 42;
		    public int publicField;
		    private static MyClass sSingleton;
		    int mPackagePrivate;
		    private int mPrivate;
		    protected int mProtected;
		}


 - 不要在底层的方法中处理异常，应该向方法的调用者抛出异常。
 - 手动添加view时，要生成id，可以用View.generateViewId()，不过api要在17+，比较废....

## 补充

### 命名规则
- 常量：MIN_WIDTH
- 全局成员变量：private String mMyName;   
- 静态成员变量：static String sMyName;   
- 方法入参变量：pMyName;   
- 私有变量：camel命名法   
- 循环中的变量：缩写字母，无意义字母
- 控件ID的命名规范：btn_login
- 类命名：WelcomeActivity
- 方法命名：动词或动名词，initXX()，isXX()，getXX()，processXX()，displayXX()，saveXX()，resetXX()，clearXX()，removeXXX() ，drawXXX()
- 资源文件命名：btn_XX

### 注释的规范：
- 文件注释：

		  /*
		   * 文件名
		   * 包含类名列表
		   * 版本信息，版本号
		   * 创建日期。
		   * 版权声明
		   */


- 类注释：

	    /**
		 * 类名
		 * @author：作者
		 * @description：实现的主要功能。
		 * @date：创建日期
		 * 修改者，修改日期，修改内容。
		 */

- 方法注释：

		/**
		 *
		 * 方法的一句话概述
		 * <p>方法详述（简单方法可不必详述）</p>
		 * @param s 说明参数含义
		 * @return 说明返回值含义
		 * @throws IOException 说明发生此异常的条件
		 * @throws NullPointerException 说明发生此异常的条件
		 */

- 其他注释

		多行：/**  */  
		单行://

### 格式化代码：  
- Tab size 4  
- 最大行宽 120
- 除了import 或者url等影响copy的代码，其余的如果超过最大行宽，请注意换行.
- 提交文件前请格式化代码，但如果是已经提交给SVN或GIT的请不要全部格式化，否则会增加合并代码的工作量。


### 提交之前先扫描：
- 提交代码前，请用扫描工具扫描代码，修改掉不规范的代码。Analyze-inspectCode
