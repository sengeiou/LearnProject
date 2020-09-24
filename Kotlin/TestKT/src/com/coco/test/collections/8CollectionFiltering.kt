package com.coco.test.collections

fun main(){

    var list = listOf("one", "two", "three", "four")
    var filterList = list.filter{
        it.length > 3
    }

    println("${list}")
//    list.filterIndexed { index, s ->  }
//    list.filterNotNull

    //filterIsInstance<String> 过滤string 类型
    var list1 = listOf(null,1 , "two", "three", "four")
    println("${list1.filterIsInstance<String>()}")


    var (match , rest ) = list.partition { it. length >3 }
    // 查找出符合条件的, 不符合条件的
    println("the match is ${match}  and rest is ${rest}");




}