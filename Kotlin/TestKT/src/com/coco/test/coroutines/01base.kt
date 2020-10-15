package com.coco.test.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext



fun main(){
    GlobalScope.launch {
        delay(1000L)
        println("阿国在学协程！！！")
    }
    println("？？？？")
    Thread.sleep(2000L)
}