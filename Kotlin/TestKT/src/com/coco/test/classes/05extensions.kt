package com.coco.test.classes

fun MutableList<Int>.swap(index: Int, index1: Int) {
    val temp = this[index]
    this[index] = this[index1]
    this[index1] = temp
}

//如果一个类定义有一个成员函数与一个扩展函数，而这两个函数又有相同的接收者类型、 相同的名字，并且都适用给定的参数，这种情况总是取成员函数

class Example {
    fun test() {
        println("class method")
    }
}

fun Example.test() {
    println("extensions metho")
}

fun Example.test(i:Int){
    this.test()
    println("this is from test(i)")
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

    //
    println("Example().test(1)\n")
    Example().test(1)


    var name: String? = ""
    println(name.toString())


}