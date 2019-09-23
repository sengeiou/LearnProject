package com

fun main() {

    val a = 10
    val b = 11

    //--if-else ---
    val c = if (a > b) a else b

    // if-esle
    val d = if (a > b) {
        println("a is more than b")
        a
    } else {
        print("others")
        b
    }

    // replace switch
    when (a) {
        1 -> println("a==1")
        2 -> println("a==2")
        else -> {
            print("a = $a")
        }
    }
    val aa = "1"

    when (a) {
        Integer.parseInt(aa) -> println("a == ")
        in 1..10 -> println("xxxx")
    }

    val o: Any = 1
    when (o) {
        is String -> {
            println("o is string")
        }
        is Int -> {
            println("o is number")
        }
    }


    val arr1 = arrayOf(1, 2, 3, 4)
    for((k,v) in arr1.withIndex()){
        println("$k---$v")
    }

    for (index in arr1.indices){
        println(arr1[index])
    }


}