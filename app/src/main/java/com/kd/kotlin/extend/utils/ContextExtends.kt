package com.kd.kotlin.extend.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text,duration)
}

fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,resId,duration)
}