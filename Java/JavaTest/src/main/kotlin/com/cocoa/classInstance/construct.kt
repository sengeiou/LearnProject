package com.cocoa.classInstance


// val 表示会在 birdOX 内部创建 name 变量
class BirdOX(val name : String = "cocoa") {
    fun test(){
        println(this.name)
    }
}

class BirdOY(name :String = "cococoa"){
    val name : String

    init {    //构造方法参数可以在init 语句块被调用
        this .name = name
        println("this is init1")
    }
    init {// init 块可以有多个，按书写的顺序执行
        println("this is init2")
    }
    fun test(){
        println(this.name)
    }
}


fun main(){
        val b = BirdOX(name = "tom")
        println(b.name)

        val b1 = BirdOY(name = "ttt")
        println(b1.name)

}