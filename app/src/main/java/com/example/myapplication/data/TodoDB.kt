package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDB: RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDB? = null

        fun getDatabase(context: Context): TodoDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
           synchronized(this){
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   TodoDB::class.java,
                   "todo_database"
               ).build()
               INSTANCE = instance
               return  instance
           }
        }
    }
}