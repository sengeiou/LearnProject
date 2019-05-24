package com.test_class


class Dog : Thread() {

    override fun run() {
        super.run()
        println(Thread.currentThread().name);
    }

}