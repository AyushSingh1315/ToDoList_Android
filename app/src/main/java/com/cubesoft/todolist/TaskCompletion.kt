package com.cubesoft.todolist

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.cubesoft.todolist.databinding.FragmentTaskCompletionBinding



class TaskCompletion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        var binding:FragmentTaskCompletionBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_completion,container,false)
        var view : View = binding.root

        return view
    }

}
