package com.kd.kotlin.extend.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

/**
 * file 转 bitmap
 */
fun File.getBitmap(): Bitmap {
    return BitmapFactory.decodeFile(this.absolutePath)
}