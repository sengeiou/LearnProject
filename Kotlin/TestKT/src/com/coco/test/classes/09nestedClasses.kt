package com.coco.test.classes

//class 09nestedClasses {
//}

class Outer0x11 {
    var name = "cocoa"
    class Nester {
        fun foo() {
            println("----")   // 无法访问外部的name
        }
    }
}

class Outer0x12 {
    var name = "cocoa"

    inner class Nester {
        fun foo() {
            println("----$name")
        }
    }

}


//匿名内部类
//使用对象表达式创建匿名内部类实例：
//
//window.addMouseListener(object : MouseAdapter() {
//
//    override fun mouseClicked(e: MouseEvent) { …… }
//
//    override fun mouseEntered(e: MouseEvent) { …… }
//})

fun main() {
    Outer0x11.Nester().foo()

    Outer0x12().Nester().foo()


}

