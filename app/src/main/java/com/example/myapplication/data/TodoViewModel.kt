package com.example.myapplication.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    val listTodos: LiveData<List<Todo>>
    private val repository: TodoRepository

    init {
        val todoDao = TodoDB.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
        listTodos = repository.listData
    }

    fun createTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createTodo(todo)
        }
    }
}