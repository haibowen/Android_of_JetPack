package com.haibowen.myjetpackdemo.lifecycles

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyObserver2 :LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun  activityStart(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun  activityStop(){

    }


}