package com.haibowen.myjetpackdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.haibowen.myjetpackdemo.dao.BookDao
import com.haibowen.myjetpackdemo.dao.PeopleDao
import com.haibowen.myjetpackdemo.model.Book
import com.haibowen.myjetpackdemo.model.People

@Database(version = 2, entities = [People::class, Book::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao

    abstract fun bookDao(): BookDao

    companion object {


        val MIGRATION_2_3=object :Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                //TODO("Not yet implemented")
                database.execSQL("alter table Book add column author text not null default 'unknown' ")
            }

        }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //TODO("Not yet implemented")

                database.execSQL("create table Book (id integer primary key autoincrement not null,name text not null,name text not null,pages integer not null)")
            }
        }

        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }

            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "app_database"
            ).addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .build()
                .apply {
                    instance = this
                }

        }

    }
}