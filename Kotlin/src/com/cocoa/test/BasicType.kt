package com.cocoa.test

fun main(args: Array<String>){
    println("------Int---------")
    val a = 1

    println(a === a)   // true

    var boxA : Int? = a
    var boxB : Int? = a

    println(boxA === boxB)

    println(a.toByte())
    println(a.toDouble())
    //println(a.toChar())

    println("------Boolean---------")

    var isTrue : Boolean  = true
    if(isTrue){
        println(isTrue)
    }
    if(!isTrue || isTrue){
        println(isTrue)
    }


    println("------Array---------")

    var array : Array<String> = Array(5,{ i -> i.toString() })

   for (i in array){
       println(i)
   }










}