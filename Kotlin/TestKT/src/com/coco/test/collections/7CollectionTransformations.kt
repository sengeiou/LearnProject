package com.coco.test.collections

fun main(){

    var set = setOf<Int>(1,2,3)
    var result1 = set.mapIndexed{
        index, i ->  index * i
    }
    println("result1 =  ${result1}")

    var list = listOf<Any?>(null ,1,2,3,3)
    var notNullList =    list.mapNotNull {
        it
    }
    println("filter null ${notNullList}")


    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println("${colors zip animals}")
//    [(red, fox), (brown, bear), (grey, wolf)]


    var result2 =  listOf(1 to "one")
    println("${result2}");
//    [(1, one)]


    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })


    var innerList = listOf(listOf(12,12),listOf(22,22))
    println("${innerList}")
    println("${innerList.flatten()}")   // flatten 打平操作
//    [[12, 12], [22, 22]]
//    [12, 12, 22, 22]


//    val containers = listOf(
//        StringContainer(listOf("one", "two", "three")),
//        StringContainer(listOf("four", "five", "six")),
//        StringContainer(listOf("seven", "eight"))
//    )
//    println(containers.flatMap { it.values })




    println("${innerList.flatten().joinTo(StringBuffer("The list of numbers: "))}")


}