package com.coco.test.collections


fun main(){
    var list  = listOf<Int>(1,2,3)
//            list.add(3)   // listof 创建的不可变数组，无法添加元素


    var  mutableList = mutableListOf<Int>(1,2,3)
    mutableList.add(1);

    println("${list::class}")
    println("${mutableList::class}")

//    listof 和 mutableList 默认实现
//    class java.util.Arrays$ArrayList   // 不可变数组用的是Arrays$ArrayList
//    class java.util.ArrayList

    var set = setOf<String>("1","2")
    var mutableSet = mutableSetOf<String>("1");


    println("${set::class}")
    println("${mutableSet::class}")
//    class java.util.LinkedHashSet
//    class java.util.LinkedHashSet


    var map = mapOf<String,String>("1" to "one")
    var mutableMap = mutableMapOf<String ,Int>("1"  to 1)

    println("${map::class}")
    println("${mutableMap::class}")
//    class java.util.Collections$SingletonMap
//    class java.util.LinkedHashMap


}


class Base1 {


}