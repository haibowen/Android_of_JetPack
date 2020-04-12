package com.haibowen.myjetpackdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class  MainViewModelFactory(private  val countReversed:Int):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return  MainViewModel(countReversed) as T
    }

}