package com.coco.test
fun main(){
        var p = Person("cocoa")
        println(p)
//        val p1 = Person(1)
}

class Empty

class Invoice{

}


class Person constructor(name : String){

    var customerKey  = name

    init {
        println("this is person init ${name}--${customerKey}")
    }

//    constructor( age : Int){
////        customerKey.length.also {  }
//    }

}



open class Parent{
    open fun print(){
        println("this is print from parent")
    }
}

class Child : Parent() {
    override fun print() {
        super.print()
        println("this is print from parent")
    }

}

