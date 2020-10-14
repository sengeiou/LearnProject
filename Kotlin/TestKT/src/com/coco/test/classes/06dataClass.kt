package com.coco.test.classes


data class User(val name: String, val age: Int) {

}


data class Person0x23(val name: String) {
    var age: Int = 0
}


fun main() {
//    equals()/hashCode() 对；
//    toString() 格式是 "User(name=John, age=42)"；
//    componentN() 函数 按声明顺序对应于所有属性；
//    copy() 函数（见下文）。
    var u: User = User("cocoa", 32)
    var x: User = User("cocoa", 32)
    println(u == x)


    var p1 = Person0x23("pp")
    var p2 = Person0x23("pp")
    p1.age = 20
    p2.age = 30
    println(p1 == p2)   // 这里虽然age 不一致，但是因为toString()、 equals()、 hashCode() 以及 copy() 的实现中只会用到 name 属性


    // 复制
    var copyUser = u.copy(name = "othername")

    val (name ,age ) = copyUser;

    println("${copyUser}   ${u}")

    println("${name} ${age} form copyUser")

    println("${copyUser.component1()}")
    println("${copyUser.component2()}")


}