package com.kd.kotlin.extend.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.view.View

/**
 * View 转 bitmap
 */
fun View.view2Bitmap(): Bitmap {
    var ret = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
    var canvas = Canvas(ret)
    var bgDrawable = this.background
    bgDrawable?.draw(canvas) ?: canvas.drawColor(Color.WHITE)
    this.draw(canvas)
    return ret
}