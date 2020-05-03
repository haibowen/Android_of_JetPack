package com.haibowen.myjetpackdemo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.haibowen.myjetpackdemo.model.Book

@Dao
interface  BookDao{

    @Insert
    fun  insertBook(book: Book):Long

    @Query("select * from Book")
    fun loadAllBooks():List<Book>


}