package com.kd.kotlin.extend.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.Gravity
import android.widget.Toast



//----------toast----------
fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text,duration).show()
}
fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,resId,duration).show()
}
fun Context.centerToast(resId: Int, duration: Int = Toast.LENGTH_SHORT){
    var t=Toast.makeText(this,resId,duration)
    t.setGravity(Gravity.CENTER,0,0)
    t.show()
}

//----------NetWork----------
/**
 * 打开网络设置
 */
fun Context.openWirelessSettings(){
    startActivity(Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
}

/**
 * 网络是否连接
 */
fun Context.isConnected():Boolean{
   var info = this.getActiveNetworkInfo()
    return info.isConnected
}

@SuppressLint("MissingPermission")
private fun Context.getActiveNetworkInfo(): NetworkInfo {
    var manager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.activeNetworkInfo
}