package com.coco.test.classes

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// 泛型
data class Box<T>(var t : T){

}

fun main(){

    var b = Box<String>("123")
    b.t = "123"



}