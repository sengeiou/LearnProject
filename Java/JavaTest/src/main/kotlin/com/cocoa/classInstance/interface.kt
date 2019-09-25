package com.cocoa.classInstance

fun main() {
    val su = Su("cocoa")
    println(su.name)
}

fun packageFun(a: String): String {
    return a
}


//既包含抽象方法的申明，也包含实现，接口无法保存状态，可以有属性但必须申明为抽象或提供访问器实现
interface MyInterface {

    var prop1: Int   // 抽象的属性
    var prop2: Int   // 抽象的属性

    val propWithImplemration: String   // 接口中的属性不能有幕后字段（backing field）
        get() = "foo"

    fun bar()
    fun foo() {
        // 可选的方法体
    }
}

class Child : MyInterface {

    override var prop1: Int = 2
    override var prop2: Int = 0
        get() = 12
        set(value) {
            field = value + 12
        }

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface Named {
    val name: String
}

interface Person0x123 : Named {
    val firstName: String
    override val name: String
        get() = "$firstName"
}

class Su(override val firstName: String) : Person0x123 {
}

interface A {
    fun foo() {
        print("A")
    }
}

interface B {
    fun foo() {
        print("b")
    }
}

class Test0x121jsh : A, B {

    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

}