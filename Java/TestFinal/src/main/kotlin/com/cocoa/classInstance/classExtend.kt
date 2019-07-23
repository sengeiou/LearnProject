package com.cocoa.classInstance

fun main() {
    var person = Person("cocoa")
    // person.name  主构造函数的参数在对象中是无法调用的
    println(person.nameLength)

    var person1 = Person(1)
    println(person.nameLength)

    // 初始化的过程 init -> 次构造函数 -> 主构造函数   ？？？对不对
    // 主构造函数默认是public


    // 继承


    //
    println("测试派生类的初始化顺序")
    val pp = Derived1("shen","jun")





//    packageFun("cocoa")

}

// 定义类
class Invoice {

}

class Empty

// 主构造函数
class Person constructor(name: String) {

    // 主构造函数的参数可以在类中使用
    var nameLength = name.length

    init {
        // 主构造函数不能包含任何代码，初始化的代码可以放到init 中, 并且可以获取主构造函数中的参数
        print("init this name is $name")
    }

    // 如果类有主构造函数，每个次构造函数都需要委托给主构造函数，参考下面的方法
    constructor(length: Int) : this("") {
        print("ci gouzao")
        nameLength = length
    }


}

open class Base constructor(p: Int) {

    // 没有标注 open ，子类不允许覆盖
    open fun v() {}

    open val x : String get() {
        return x
    }


}

class Derived(p: Int) : Base(p) {

    // 覆盖方法必须加上override
    override fun v() {

    }

}


// 派生类的初始化
//argument for base :Shen
//initializing base
//initializing size in base 4
//initializing derived
//initializing size in derived :7

// 观察发现顺序为   父的主构造 -> 父的init -> 父的其他方法 -> 子的init -> 子的其它方法

open class Base1(val name :String){
    init {
        println("initializing base")
    }

    open val size : Int = name.length.also {
        println("initializing size in base $it")
    }

    fun x (){

    }

}

class Derived1 (name : String , val lastName :String) : Base1(name.capitalize().also { println("argument for base :$it") }){

    init {
        println("initializing derived")
    }

    override val size: Int = (super.size + lastName.length).also {
        println("initializing size in derived :$it")
        super.x()  // 调用父类的方法   如果是内部类，则使用 super@outclass.funName()
    }

}

// 抽象类
// 抽象类可以不用open 修饰，包括抽象类中的方法
abstract class AObj0x11 {
}

class TestOx11 :AObj0x11(){
}

// 抽象类可以覆盖一个非抽象类的开放成员
open class Test0x12 {
    open fun x (){}
}

abstract class AObj0x12 : Test0x12(){
    override fun x (){}
}



















