package com.haibowen.myjetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.haibowen.myjetpackdemo.model.Repository
import com.haibowen.myjetpackdemo.model.User

//
//class Main2ViewModel (countReserved:Int) : ViewModel() {
//
//
//    var counter = MutableLiveData<Int>()
//
//    init {
//        counter.value=countReserved
//
//    }
//
//    fun  plusOne(){
//        val  count=counter.value?:0
//        counter.value=count+1
//    }
//
//    fun clear(){
//        counter.value=0
//    }
//}





//class Main2ViewModel(countReserved: Int) : ViewModel() {
//
//
//    val counter: LiveData<Int>
//        get() = _counter
//
//    private val _counter = MutableLiveData<Int>()
//
//    init {
//
//        _counter.value = countReserved
//    }
//
//    fun plusOne() {
//        val count = _counter.value ?: 0
//        _counter.value = count + 1
//
//    }
//
//    fun clear() {
//        _counter.value = 0
//    }
//}


//class Main2ViewModel (countReserved:Int):ViewModel(){
//    private val userLiveData=MutableLiveData<User>()
//
//    val userName:LiveData<String> =Transformations.map(userLiveData){
//        user->
//        "${user.firstName}${user.lastName}"
//    }
//}

//
//class Main2ViewModel (countReserved:Int):ViewModel(){
//
//    fun getUser(userId:String):LiveData<User>{
//        return Repository.getUser(userId)
//    }
//}

//class Main2ViewModel (countReserved:Int):ViewModel(){
//    private  val userIdLiveData =MutableLiveData<String>()
//
//
//
//    val user:LiveData<User>=Transformations.switchMap(userIdLiveData){
//        userId->
//        Repository.getUser(userId)
//    }
//
//
//    fun getUser(userId:String){
//        userIdLiveData.value=userId
//
//    }
//}

//class Main2ViewModel : ViewModel(){
//
//    private val refreshLiveData=MutableLiveData<Any?>()
//    val refershResult=Transformations.switchMap(refreshLiveData){
//        Repository.refresh()
//    }
//    fun  refresh(){
//
//        refreshLiveData.value=refreshLiveData.value
//    }
//}




