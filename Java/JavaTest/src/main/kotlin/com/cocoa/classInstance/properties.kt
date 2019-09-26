package com.cocoa.classInstance

//位于顶层或者是 object 声明 或 companion object 的一个成员
// 编译器常量
const val CONSTANCT_VALUE = "123123"

/**
 *
 * 3. 一个只读属性的语法和一个可变的属性的语法有两方面的不同：
 *   1、只读属性的用 val开始代替var 2、只读属性不允许 setter
 * 4.
 *
 *
 *
 */
fun main() {

//    Test::bb.isInitialized

        //isInitialized 测试失败
    var test = Test()
//   val t = test::bb.isInitialized
    println(test.bb)
    test.isEmpty = true
    print(test.isEmpty)

}

class Test0x1212{

}

class Test {

    var age = 0
    var name : String?

    // 只读属性不允许 set  test.addr = "123" 会报错
    val addr : String = "china hangzhou ..."

    // 自定义get 方法
    val isAdrEmpty : Boolean
        get() = addr.isEmpty()

    // lateinit 不能对基本类型使用，只能使用字符类型和引用类型
    lateinit  var bb : Thread
    lateinit  var aa : String
    var testBoolean: Boolean = true

    var visiable : String = ""
        private set   // 修改访问器的可见性


    init {
        name = ""
        bb = Thread()
    }

    fun test(){
        aa = "123"
    }
    var isEmpty: Boolean = false
        get() =  field    //"123".length == 0
        set(value) {
            field = value
            println("set isEmpty ${value}")
        }


    // 幕后字段 field
    var size = 0
        set(value) {
            if (value != 0) {
                field = value
            }
        }


}
