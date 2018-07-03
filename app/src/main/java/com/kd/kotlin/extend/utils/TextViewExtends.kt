package com.kd.kotlin.extend.utils

import android.widget.TextView

fun TextView.setColor(resId: Int) {
    this.setTextColor(resources.getColor(resId))
}