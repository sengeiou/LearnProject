package com.coco.test.classes

open class A0x12(name : String){
    var name : String = "cocoa"

}

interface  B0x12{
    fun test()
}

class C0x12{

    private fun A() = object {
        val x: String = "x"        // 私有函数，所以其返回类型是匿名对象类型
    }
    open fun B()= object {
        val x: String = "x"
    }

    fun C(){
        var x1 = A().x
//        var x2 = B().x   // 报错  公有函数，所以其返回类型是 Any
    }
}


// 伴生对象
//即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口：
class D0x12{
    companion object  {
        var name : String  = "cocoa"
    }
}





fun main(){

    var s : Thread = Thread( object : Runnable{
        override fun run() {
            println("this is run methods! ${Thread.currentThread().name}");
        }
    });

    s.start()


    var testA = object : A0x12("cccc"), B0x12{
        override fun test() {
            println("b0x12 test methods!");
        }
    }


    println("${testA.name}  ----")
    testA.test();
    println("${testA is A0x12}")    // true
    println("${testA is B0x12}")    // true



    //有的时候只需要一个对象，不申明超类
    val a  = object  {
        var age  = 10;
    }

    println("${a.age}");


//    D0x12.Fac.name
    println("${D0x12.name}")
    println("${D0x12.Companion}")

}