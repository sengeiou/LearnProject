package com.coco.test.classes

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}


class PersonOx12 {


    var name: String?
    val isEmpty: Boolean?     // 申明为val 后只能有get 方法
        get() {
            return this.name?.isEmpty()
        }

    var count : Int  = 0
        set(value){
            field = value    // field 是幕后字段
        }

    constructor(name: String) {
        this.name = name
    }

    // 编译器常量
    companion object {
        const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
    }


    lateinit var  thread : Thread

//
//    fun setUp(){
//        this.thread = Thread.currentThread()
//    }


}


fun main() {
    var address = Address()
    println(address.name)

    var person = PersonOx12("cocoa")
    println("person isEmpty ${person.isEmpty}")
    person.count = 12
    println("person count = ${person.count}")





    println("${person.thread  == null}")
//    println("${PersonOx12::thread}")


}