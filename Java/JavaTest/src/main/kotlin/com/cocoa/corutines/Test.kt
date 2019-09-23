package com

fun main() {


    var a: String? = null
//    val result = a?.length
//    if (result == null) {
//        println("the result is null")
//    }
    a?.let {
        println(a)
    }

    var b = a ?: "defatlt"
    println("b is $b")

    val list: List<String?> = listOf("111", null)
    for (item in list) {
        item?.let {
            println(item)
        }
    }
    list.forEach {
        it?.let {
            println(it)
        }
    }
    val c: String? = "ccc"
    println(c!!.length)

    test1("123")
}

fun test1(a: Any) {
    if (a is String) {
        print(a.length)
    }
}

interface Birder {
    fun fly()
}

class Person : Birder {
    override fun fly() {
        println(" person fly")
    }
}



