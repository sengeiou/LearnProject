package com.cocoa.classInstance

import org.omg.PortableServer.LIFESPAN_POLICY_ID

fun main() {

    var a : Int = 10
    println(a.square())

    var c : C  = C()
    c.foo()   //member


    test(Co())

    // 这里的host
    val host =  Host("kotl.in")
    // 这里的host 无法调用 printConnectionString
    // 只有在 Connection 对象中才能使用
    Connection(Host("kotl.in"), 443).connect()



}

// 为 int 扩展了一个平方的方法
fun Int.square() :Int{
    return this * this
}


//如果一个类的成员方法和扩展方法同名，同参，同返回，那么调用该方法时，永远取成员函数
//在下面的例子中，打印的永远是 member
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



// 扩展是静态解析的
open class Person0x221{
}

class Co : Person0x221(){

}
fun Person0x221.Print(){
    println("Person0x221")
}

fun Co.Print(){
    println("Person0x221")
}
// 如果传入的 Person0x221 是 Co 类型， 打印的依旧是Person0x221 中的扩展，就是所谓的，扩展是静态解析的
fun test(s : Person0x221){
    s.Print()
}


// 扩展的作用域
// 如果在包  org.example.declarations 中定义了 getLongestString 扩展
// 在别的包中，则需要进行 import org.example.declarations.getLongestString


// 扩展声明为成员

class Host(val hostname : String){
    fun printHostname (){ println(hostname)}
}

class Connection (val host :Host ,val port :Int){
       fun printPort(){println(port)}
    fun Host.printConnectionString(p : Int){
        printHostname()
        print(":")
        printPort()
        // 内部扩展调用外部类的方法
        toString()   // 调用的是host 的
        this@Connection.toString() // 调用的是 connection 的
    }
    fun connect(){
        host.printConnectionString(port)
    }
}







