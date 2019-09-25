package com.cocoa.classInstance

import org.omg.PortableServer.LIFESPAN_POLICY_ID

fun main() {

    var a : Int = 10
    println(a.square())

    var c : C  = C()
    c.foo()   //member

}

// 为 int 扩展了一个平方的方法
fun Int.square() :Int{
    return this * this
}


//如果一个类的成员方法和扩展方法同名，同参，同返回，那么调用该方法时，永远取成员函数
class C{
    fun foo(){
        println("member")
    }
}

fun C.foo(){
    println("extenions")
}


// 扩展属性
// 扩展属性无法初始化，只能显示的提供set/get
val <T> List<T>.lastIndex : Int
    get() = size - 1




