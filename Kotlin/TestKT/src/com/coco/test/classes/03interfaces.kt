package com.coco.test.classes

interface MyInterface{
    fun  foo()
}

class MyImpl : MyInterface{

    override fun foo() {
        println("MyImpl foo")
    }

}




fun main(){
        var my = MyImpl()
            my.foo()
        // tagert
}