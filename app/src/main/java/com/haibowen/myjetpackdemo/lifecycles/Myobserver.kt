package com.haibowen.myjetpackdemo.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Myobserver (val lifecycle: Lifecycle) :LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun  activeStart(){
        Log.d("MyObserver","activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun  activeStop(){
        Log.d("MyObserver","activityStop")

    }
}