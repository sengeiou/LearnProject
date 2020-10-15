package com.coco.test.base


open class Base(val name : String){
    init {
        println("Initializing Base")
    }

    open val size : Int = name .length .also {
        println("Initializing size in Base : ${it}")
    }
}


class Derived (name : String , val lastName : String)
    : Base(name.capitalize().also { println("Argument for base ${it}") }){


//    constructor(age : Int){
//
//    }

    init {
        println("Initializing Derived")
    }

    override val size: Int
        = (super.size + lastName.length).also { println("Initializing size in Derived ${it}") }
}
fun main() {
    var p = Person("cocoa")
    println(p)
//        val p1 = Person(1)
//    派生类初始化顺序
    println("Constructing Derived(\"hello\", \"world\")")
    val d = Derived("hello", "world")


}

class Empty

class Invoice {

}


class Person constructor(name: String) {

    var customerKey = name

    init {
        println("this is person init ${name}--${customerKey}")
    }

//    constructor( age : Int){
////        customerKey.length.also {  }
//    }

}


open class Parent {

    open val count: Int = 10

    open fun print() {
        println("this is print from parent")
    }
}

class Child : Parent() {

    override var count: Int = 0
        get() = super.count


    override fun print() {
        super.print()
        println("this is print from parent")
    }

}

