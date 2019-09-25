package com.cocoa.classInstance

//位于顶层或者是 object 声明 或 companion object 的一个成员
// 编译器常量
const val CONSTANCT_VALUE = "123123"

fun main() {

//    Test::bb.isInitialized

        //isInitialized 测试失败
    var test = Test()
//   val t = test.bb.isInitialized

}

class Test0x1212{

}

class Test {


    // lateinit 不能对基本类型使用，只能使用字符类型和引用类型
    lateinit open var bb : Thread
    lateinit  var aa : String

    fun test(){
        aa = "123"
    }

    var testBoolean: Boolean = true

    var isEmpty: Boolean
        get() {
            return "123".length == 0
        }
        set(value) {
            println(value)
        }


    // 幕后字段 field
    var size = 0
        set(value) {
            if (value != 0) {
                field = value
            }
        }


}
