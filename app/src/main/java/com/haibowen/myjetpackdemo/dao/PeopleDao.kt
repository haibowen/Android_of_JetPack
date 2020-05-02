package com.haibowen.myjetpackdemo.dao

import androidx.room.*
import com.haibowen.myjetpackdemo.model.People
import com.haibowen.myjetpackdemo.model.User


@Dao
interface PeopleDao {

    @Insert
    fun  insertPeople(people: People):Long

    @Update
    fun updatePeople(newUser: People)

    @Query("select * from People")
    fun loadAllPeople():List<People>

    @Query("select * from People where age> :age")
    fun loadPeopleOlderThan(age:Int):List<People>

    @Delete
    fun deletePeople(people: People)

    @Query("delete from People where lastName=:lastName" )
    fun deletePeopleByLastName(lastName:String):Int

}