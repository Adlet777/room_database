package com.example.myapplication.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.Todo
import com.example.myapplication.data.TodoViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class AddFragment : Fragment() {

    private lateinit var mTodoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        view.button_create.setOnClickListener{
            insertDataToDB()
        }

        return view
    }

    private fun insertDataToDB() {
        val title = title_add.text.toString()
        val description = description_add.text.toString()
        val status = status_add.text.toString()
        val category = category_add.text.toString()
        val duration = duration_add.text

        if (inputCheck(title, description, status, category, duration)) {
            val todo = Todo(0, title, description, status, category, Integer.parseInt(duration.toString()))
            mTodoViewModel.createTodo(todo)
            Toast.makeText(requireContext(), "Successfully created Todo task", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else
            Toast.makeText(requireContext(), "Some values are not entered", Toast.LENGTH_LONG).show()
    }

    private fun inputCheck(title: String,
                           description: String,
                           status: String,category:
                           String,
                           duration: Editable): Boolean {
        return !(TextUtils.isEmpty(title)
                && TextUtils.isEmpty(description)
                && TextUtils.isEmpty(status)
                && TextUtils.isEmpty(category)
                && duration.isEmpty())
    }
}