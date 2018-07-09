package com.kd.kotlin.extend.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img.loadImage(this, "http://c.hiphotos.baidu.com/image/pic/item/fd039245d688d43ffdcaed06711ed21b0ff43be6.jpg")
        img.loadImageByProportion(0.5f, 1.0f)
    }
}
