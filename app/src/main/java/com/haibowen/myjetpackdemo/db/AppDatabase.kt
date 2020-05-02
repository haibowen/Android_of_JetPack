package com.haibowen.myjetpackdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haibowen.myjetpackdemo.dao.PeopleDao
import com.haibowen.myjetpackdemo.model.People

@Database(version = 1,entities = [People::class])
abstract  class AppDatabase :RoomDatabase(){
    abstract fun peopleDao():PeopleDao
    companion object{

        private var instance:AppDatabase?=null

        fun  getDatabase(context: Context):AppDatabase{
            instance?.let {
                return it
            }

            return Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java,"app_database")
                .build()
                .apply {
                    instance=this
                }

        }

    }
}