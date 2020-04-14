package com.coco.test

fun main(){
    println("Hello")
    println("${sum(1,2)}")

    var name = "cocoa"

    val len = name.length.also {
        println(it)
    }

    println("the length ${len}")

}


fun sum (a : Int, b : Int) = a + b



