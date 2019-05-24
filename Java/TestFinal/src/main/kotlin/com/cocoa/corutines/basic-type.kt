package com

fun main(){
    val oneMillion = 1_000_000
    println(oneMillion)

    val a: Int = 10000
    println(a ===a)
    val boxA : Int? = a
    val boxA1 : Int? = a
    println(boxA === boxA1)


    val c = 10
    c.toByte()
    c.toLong()


    val b  = 1
    println(b shl 3)  // <<

    val array = arrayOf(1,2,3)
    val strArray = arrayListOf<String>()
    val array1 = Array<String>(10, {
        it -> it.toString()
    })

    println(array.get(0))
    println(strArray)
    println(array1)

    for (item in array1){
        print(item)
    }


}