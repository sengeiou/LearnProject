package com

import kotlinx.coroutines.*

fun main(){

    var a : Int = 10

    runBlocking{
        println("blocking")
        delay(3000)
    }
    print("end")


}