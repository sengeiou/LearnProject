package com.cocoa.classInstance

class Bird{

    //除了延迟初始化，不然就要指定属性的默认值
//    var age : Int
    val name : String = "bird"

    fun fly(){
        println("I can fly!!")
    }
}
class Dog(var name : String = "wangwang", val age : Int = 0)

class Person1(name :String = "cocoa", age : Int = 0){

    var name1 : String   = name   // 构造方法的参数不带 val 和 val ，则可以在这里调用，只有两个地方
    var age1 : Int = age


    // 在这里lateName 没有初始化，不会报错，但是你尝试调用 Person().lateName 则会报没有初始化的错误（可以在任何方法中初始化）
    lateinit var lateName : Integer  //lateinit 不能修饰基础类型 如int ，要使用包装类型


    fun setLateName(){
        this .lateName = Integer(200)
    }


    val lazyName : String by lazy {     // by lazy 必须是 val 的，只会被赋值一次
        if (age1 == 0) "" else "123"
    }

    init {
        this.name1 = name  // 构造方法的参数不带 val 和 val ，则可以在这里调用，只有两个地方
        this.age1  = age
    }

    fun test(){
        //print($name)
    }

    override fun toString(): String {
        return "Person(name='$name1', age=$age1)"
    }

}
// 类中的所有非抽象成员必须在对象创建时完成初始化
// 类中的val 属性只能在 init 中完成赋值


class Car(num : Int){

    var num : Int

    init {
        this.num = num
        println("init")
    }

    //从构造方法，执行顺序为先执行委托方法 ，在执行自身代码
    constructor(name : String) : this( name.length){  // 冒号后面为委托方法，
//        括号内的为自身代码
        println("constructor")
    }

}





fun main(){
    var b = Bird()
    println(b)

    val d  = Dog()
    println(d)
    println(d.name)
    d.name = "cocoa"
    println(d.name)

    val p  = Person1()
    var p1  = Person1(name = "cocoa", age = 12)
    println(p.toString())
    println(p1)

    p1.setLateName()
    println(p1.lateName)


    val c = Car(name = "audi") // 执行代码，发现输出 init constructor 4
    println(c.num)
}
