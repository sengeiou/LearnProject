package com.test_class

class Person(name:String, age : Int?) {
    init {
        println("person init ${name} ${age}")
    }


    constructor(name:String) : this(name,0){
        println("person init ${name} ")
    }
}