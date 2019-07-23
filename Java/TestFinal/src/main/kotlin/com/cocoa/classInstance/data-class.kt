package com.cocoa.classInstance

fun main(){

    var p = Person0x00("123",12)
    println(p.age)
    println(p.toString())

    var p1 = Person0x11("123",1)
    println(p1.age)
    println(p1.toString())

    // 对比 p 和 p1 ,发现 toString 函数不一样

}

class Person0x11(val name :String , val age : Int){

}

// 数据类必须满足一下几点
// 主构造函数必须有一个参数
// 主构造函数的所有参数必须标记为 val 或 var
data class Person0x00(val name :String , var age : Int){

}