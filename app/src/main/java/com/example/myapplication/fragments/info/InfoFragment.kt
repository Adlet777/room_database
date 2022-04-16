package com.example.myapplication.fragments.info

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_info.view.*


class InfoFragment : Fragment() {

    private val args by navArgs<InfoFragmentArgs>()


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        view.id_field.setText("ID: " + args.currentTodoObject.id.toString())
        view.title_field.setText("Title: " + args.currentTodoObject.title)
        view.status_field.setText("Status: " + args.currentTodoObject.status)
        view.category_field.setText("Category: " + args.currentTodoObject.category)
        view.description_field.setText("Description: " + args.currentTodoObject.description)
        view.duration_field.setText("Duration: " + args.currentTodoObject.duration.toString())

        return view
    }

}