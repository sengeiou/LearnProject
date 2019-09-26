package com.cocoa.classInstance

import com.alibaba.fastjson.JSON
import com.google.gson.Gson

fun main(){

    var p = Person0x00("123",12)
    println(p.age)
    println(p.toString())

    var p1 = Person0x11("123",1)
    println(p1.age)
    println(p1.toString())

    // 对比 p 和 p1 ,发现 toString 函数不一样,
    // 因为 data class 重写了 toString

    var ppp = Person0x02(name = "ccooa")
    println("print ppp $ppp")

    // copy 方法 创建修改后的新对象
    val cocoa = p.copy(name = "ccocoa")
    println(cocoa == p)


    //数据类与解构声明
    val (name ,age ) = Person0x00(name = "cocoa", age = 12)
    println("the name is $name and age is ${age}")


    // 测试 data class 做为 fast json 的解析类
    val jsonStr = "{name:\"json value name\",age:123123}"

    // use fastjson
    val jsonResult : Person0x01 = JSON.parseObject(jsonStr,Person0x01::class.java)
    println("the jsonResult from fastjson is $jsonResult")

    // use google gson
    var gsonResult  : Person0x01 = Gson().fromJson(jsonStr,Person0x01::class.java)
    println("the gsonResult from gson is $gsonResult")
}

class Person0x11(val name :String , val age : Int){

}

// 数据类必须满足一下几点
// 主构造函数必须有一个参数
// 主构造函数的所有参数必须标记为 val 或 var

// 可以自己重写 equals hashCode  和 toString , 当然数据类会有默认的实现
data class Person0x00(val name :String , var age : Int){

}

//如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值
data class Person0x01(var name :String = "" , var age : Int = 0){

}

data class Person0x02(var name : String){
    var age : Int  = 120
}

