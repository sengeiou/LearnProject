package com.coco.test.collections

fun main(){

    var numberOfSet = setOf<Int>(1,2,3)
    var emptySet = setOf<Int>()

    var map = mutableMapOf<Int,String>().apply {
        this[0] = "zero"
        this[1] = "one"
    }

    var doubleList = List(3){
        it * 2
    }

    println("${doubleList}")


    // copy
    var sourceList = listOf<String>("1","2","3")
    // deep copy
    var copyList  = sourceList.toMutableList()
    copyList[1] = "changed"

    println("the sourceList = ${sourceList}")




}