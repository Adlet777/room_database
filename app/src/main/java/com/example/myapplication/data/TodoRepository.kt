package com.example.myapplication.data

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {

    val listData: LiveData<List<Todo>> = todoDao.listTodos()

    fun createTodo(todo: Todo){
        todoDao.createTodo(todo)
    }
}