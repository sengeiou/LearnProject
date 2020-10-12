package com.coco.test.classes


//Kotlin 的接口可以既包含抽象方法的声明也包含实现。与抽象类不同的是，接口无法保存状态。它可以有属性但必须声明为抽象或提供访问器实现。
interface MyInterface {

    val age: Int

    fun foo()
    fun doNotImpl() {
        println("doNotImpl method")
    }

}

class MyImpl : MyInterface {

    override val age: Int = 90

    override fun foo() {
        println("MyImpl foo")
    }

}

interface Named {
    val name: String
}

private interface Person0x : Named {

    val firstName: String
    val lastName: String

    override val name: String
        get() = "${firstName} ${lastName}"

}


private class Employeee : Person0x {
    override val firstName: String
        get() = "first"
    override val lastName: String
        get() = "last"
}


// 解决覆盖冲突问题
private interface A {
    fun foo() {
        println("this is foo from A")

    }

    fun bar()
}

private interface B {
    fun foo() {
        println("this is foo from B")
    }

    fun bar() {
        println("this is bar from B")
    }
}


private interface D : A, B {

    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }

}

class XiaoD :D{

}



fun main() {
    var my = MyImpl()
    my.foo()
    // tagert

    val xiaoD = XiaoD()
    xiaoD.foo()
    xiaoD.bar()


}











