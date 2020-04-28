package com.cocoa.testjetpack

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArrayMap
import androidx.databinding.ViewDataBinding
import com.cocoa.testjetpack.bean.Handler
import com.cocoa.testjetpack.bean.User
import com.cocoa.testjetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,Runnable{


    var binding : ActivityMainBinding? = null ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        binding?.user = User("sj","jun")
        binding?.defaultStr = "the default String"
        binding?.handler = Handler()
        setContentView(binding?.root)
        Thread(this).start()

        val array = ArrayMap<String,String>()
        array.put("123","123123")

    }

    override fun run() {
      Thread.sleep(3 * 1000);
      binding?.user = User("sj1231231231231231231231","12312312312312jun")
    }
}
