package com

fun main(){
        var p1 = P1("cocoa",12)
        var map = HashMap<String,String>()
        map.put("one","1")
        for((k,v) in map){
            print("$k----$v")
        }

}

data class P1(val name : String ,val age : Int)

