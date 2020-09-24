package com.coco.test.collections

fun main() {

    var list = List<Int>(10, {
        it * it
    })


    for (item in list) {
        println("${item}")
    }

    list.forEach {
        println("${it}")
    }

    for ((item, index) in list.withIndex()) {
        println("${item}===>${index}")
    }

    val iterator = list.iterator();
    while (iterator.hasNext()) {
        println("${iterator.next()}")
    }


    println("listIteratorlistIteratorlistIteratorlistIterator")
    // 双向  Iterator
    var listIterator = list.listIterator();
    listIterator.next()
    listIterator.next()
    listIterator.next()
    while (listIterator.hasPrevious()) {
        println("${listIterator.previous()}")
    }


}