package com.cocoa.testjetpack.bean

import android.view.View

class Handler {
    fun onClick(v : View, u :User){
        println("this is click ${u.firstName}")
    }
}