package com.coco.test.base

fun main(){

    val  t = Test()
    t.count = 10
    println("the new value ${t.count}")


}


class Test{

    var count : Int = 0
        set(value) {
           if(value >2){
               println("the old value ${field}")
               field = value
           }
        }

}

