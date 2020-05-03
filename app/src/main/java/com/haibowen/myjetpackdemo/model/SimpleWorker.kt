package com.haibowen.myjetpackdemo.model

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class SimpleWorker(context:Context,params:WorkerParameters): Worker(context,params){
    override fun doWork(): Result {
        TODO("Not yet implemented")

        Log.d("SimpleWorker","do work in SimpleWorker")
        return  Result.success()
    }

//    fun doWork(): Result {
//        Log.d("SimpleWorker","do work in SimpleWorker")
//        return Result.success()
//
//    }


//
}