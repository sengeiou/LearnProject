# 适配器模式

### 基本概念
 * Target 目标角色,在实际项目中, 应该是早就存在的， 一般都是个接口 （参考Target的接口）
 * Adaptee 源角色,在实际项目中, 应该新需求新增的一个事物 , 一般都是通过适配器,把源角色替换为目标角色
 * Adapter 适配器模式的核心角色, 用来把adaptee 转换为 target  (一般都是集成adaptee然后实现target)

> android 中的 listview和adapter 中就用到了适配器模式，http://blog.csdn.net/tianfeng701/article/details/8775225


### 主要优点
 *  让两个没有关系的类在一起运行
 *  灵活性好
