package com.haibowen.myjetpackdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.concurrent.CountDownLatch


class Main2ViewModelFactory (private  val countReserved:Int):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return  Main2ViewModel(countReserved)as T



    }


}