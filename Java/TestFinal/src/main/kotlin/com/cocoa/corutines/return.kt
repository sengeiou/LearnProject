package com

fun main(){

    loop1@ for (i in 0..100){

        if (i==10){
            break@loop1
        }
        println(i)
    }



}


