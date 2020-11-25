package com.coco.test.classes

enum class AAA{
    A1, A2
}

enum class BBB(var code : Int){

    B1(1),
    B2(2) ;
}



fun main(){

    println("${AAA.A1}--------")
    println("${BBB.B1.code}--------${BBB.B1}")

    for(i in BBB.values()){
        println("---foreach---${i}")
    }

    val b1 = BBB.valueOf("B1");
    println("-----${b1}");



}