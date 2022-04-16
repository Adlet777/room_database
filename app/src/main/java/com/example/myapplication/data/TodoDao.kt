package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createTodo(todo: Todo)

    @Query("SELECT * FROM todo ORDER BY id ASC")
    fun listTodos(): LiveData<List<Todo>>
}