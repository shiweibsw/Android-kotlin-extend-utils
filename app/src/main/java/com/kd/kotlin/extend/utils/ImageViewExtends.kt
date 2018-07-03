package com.kd.kotlin.extend.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


/**
 * 加载图片
 */
fun ImageView.loadImage(context: Context, path: String, placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false) {
    var options = RequestOptions()
    options.placeholder(placeholder)
    if (useCache)
        options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆形图片
 */
fun ImageView.loadCircleImage(context: Context, path: String, placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false) {
    var options = RequestOptions()
    options.placeholder(placeholder)
    options.circleCrop()
    if (useCache)
        options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    Glide.with(context).load(path).apply(options).into(this)
}

/**
 * 加载圆角图片
 */
fun ImageView.loadRoundCornerImage(context: Context, path: String, roundingRadius: Int = 32, placeholder: Int = R.mipmap.ic_launcher, useCache: Boolean = false) {
    var options = RequestOptions()
    options.placeholder(placeholder)
    if (useCache)
        options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    Glide.with(context).load(path).apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius))).apply(options).into(this)
}


/**
 * 取消加载
 */
fun ImageView.loadClear(context: Context) {
    Glide.with(context).clear(this)
}




