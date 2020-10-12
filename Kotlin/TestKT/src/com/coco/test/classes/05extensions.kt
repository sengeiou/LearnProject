package com.coco.test.classes

fun MutableList<Int>.swap(index: Int, index1: Int) {
    val temp = this[index]
    this[index] = this[index1]
    this[index1] = temp
}

class Example {
    fun test() {
        println("class method")
    }
}

fun Example.test() {
    println("extensions metho")
}

//  可控接收者
fun Any?.toString(): String {
    if (this == null || this.equals("")) {
        return "empty"
    }
    return toString()
}


val <T> List<T>.lastIndex: Int
    get() = size - 1


fun main() {

    val intList = mutableListOf<Int>(1, 2, 3)
    intList.swap(0, 1)
    println(intList)

    Example().test()

    var name: String? = ""
    println(name.toString())


}