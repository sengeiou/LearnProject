package com.coco.test.collections

fun main(){


    var list = listOf("one", "two", "three", "four", "five")
    println(list.groupBy { it.length>3 })

    println(list.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))

}