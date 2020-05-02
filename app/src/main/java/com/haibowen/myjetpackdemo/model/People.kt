package com.haibowen.myjetpackdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class People(var firstName:String ,var lastName:String,var age:Int){


    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}