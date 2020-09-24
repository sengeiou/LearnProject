package com.coco.test.collections

fun main() {


    var list = listOf<String>("11", "22", "3", "444")

    list.filter {
        it.length >1
    }
    // 这里的filter 返回的也是不可变的list


    // filterTo() 代替 filter() 以及用 associateTo() 代替 associate()。
    // 转换目标对象为可变list

    var result = list.filterTo(mutableListOf<String>()) {
        it.length > 1
    }
    result.add("444")

    println("${result}")


     val indexResult =   list.filterIndexedTo(mutableListOf()){
            index, _ -> index == 0
        }
    println("${indexResult}")


    var mutableList  = mutableListOf<String>("11", "22", "3", "444")
    mutableList.sort()  // sort在原来的集合上排序
    mutableList.sorted()  // sorted 返回新的排序集合


}

