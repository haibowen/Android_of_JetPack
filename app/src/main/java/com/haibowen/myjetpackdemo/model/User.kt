package com.haibowen.myjetpackdemo.model

import androidx.lifecycle.MutableLiveData

class User (var  firstName:String,var lastName:String,var age:Int){

    val userLiveData=MutableLiveData<User>()
}