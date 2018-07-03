package com.kd.kotlin.extend.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img.loadImage(this,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530504284670&di=290348ed26686c9abf5ecc8274f86271&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb7003af33a87e95053e42ae21c385343faf2b449.jpg")
    }
}
