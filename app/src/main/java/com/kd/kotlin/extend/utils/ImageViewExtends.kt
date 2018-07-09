package com.kd.kotlin.extend.utils

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.support.annotation.IntRange
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


/**
 * 加载图片
 */
fun ImageView.loadImage(context: Context, path: String, placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false) {
    var options = getOptions(placeholder, useCache)
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆形图片
 */
fun ImageView.loadCircleImage(context: Context, path: String, placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false) {
    var options = getOptions(placeholder, useCache)
    options.circleCrop()
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆角图片
 */
fun ImageView.loadRoundCornerImage(context: Context, path: String, roundingRadius: Int = 20, placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false) {
    var options = getOptions(placeholder, useCache)
    Glide.with(context).load(path).apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius))).apply(options).into(this)
}

/**
 * 取消加载
 */
fun ImageView.loadClear(context: Context) {
    Glide.with(context).clear(this)
}

/**
 * 按照图片的宽高比加载
 * 使用本属性的ImageView在xml布局中的width及height属性必须为WRAP_CONTENT
 * widthProportion 为相对于屏幕宽度的比例取值范围为0.0-1.0，当widthProportion=1.0时，ImageView的宽度为屏幕宽度
 * heightProportion为相对于图片宽度的显示比例
 */
fun ImageView.loadImageByProportion(@IntRange(from = 0, to = 1) widthProportion: Float, heightProportion: Float) {
    this.adjustViewBounds = true
    var screenWidth = 0
    var wm: WindowManager = this.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    if (wm == null) {
        screenWidth = this.context.resources.displayMetrics.widthPixels - leftMargin - rightMargin
    } else {
        var point = Point()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wm.defaultDisplay.getRealSize(point)
        } else {
            wm.defaultDisplay.getSize(point)
        }
        screenWidth = point.x - leftMargin - rightMargin
    }
    var para = this.layoutParams
    para.width = (screenWidth * widthProportion).toInt()
    para.height = ViewGroup.LayoutParams.WRAP_CONTENT
    layoutParams = para
    maxWidth = (screenWidth * widthProportion).toInt()
    maxHeight = (screenWidth * widthProportion * heightProportion).toInt()
    scaleType = ImageView.ScaleType.CENTER_CROP
}


private fun ImageView.getOptions(placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false): RequestOptions {
    var options = RequestOptions()
    options.placeholder(placeholder)
    options.priority(Priority.HIGH)
    if (useCache)
        options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    return options
}




