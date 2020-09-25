package com.coco.test.classes


//在 Kotlin 中所有类都有一个共同的超类 Any，这对于没有超类型声明的类是默认超类：
class Person constructor(name: String) {

    //请注意，主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中使用：
    val innerName = name.toUpperCase()

    //构造的参数可以在初始化块中使用
    init {
        println("the init method and the name ${name}")
        //the init method and the name cooca
    }

    //在实例初始化期间，初始化块按照它们出现在类体中的顺序执行
    init {
        println("Second initializer block that prints ${name.length}")
    }

}

//声明属性以及从主构造函数初始化属性，Kotlin 有简洁的语法：
// val 表示只读
class Dog(val firstName: String, var age: Int) { /*……*/

    // 次构造函数
//        如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可
    constructor(age: Int) : this(firstName = "default name", age = age) {
    }
}

open class Shape() {
    open fun draw() {

    }
}

class Circle : Shape() {

    override fun draw() {

    }
}


fun main() {
    var p1 = Person("cooca")
//        val name  = p1.name   // name 是不能被访问的
    println(p1.innerName)

    var dog = Dog(firstName = "cocoa", age = 12)
    // 掉用次构造函数
    var dog1 = Dog(age = 123)
    println(dog.age)
    println("${dog1.firstName} ${dog1.age}")


}