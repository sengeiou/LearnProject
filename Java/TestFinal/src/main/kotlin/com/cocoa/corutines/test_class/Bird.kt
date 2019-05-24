package com.test_class

class  Bird{
    var allByDefault: Int? // 错误：需要显式初始化器，隐含默认 getter 和 setter
    var initialized : Int = 10  // 类型 Int、默认 getter 和 setter
        get() = field
        set(value) {
           field = value+10
        }
    init {
        allByDefault = null
    }


}