package com.cubesoft.todolist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.cubesoft.todolist.databinding.FragmentDisplayBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class displayFragment : Fragment()
{


    lateinit var recyclerView: RecyclerView
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var myAdapter: myAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)






    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        var binding:FragmentDisplayBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_display,container,false)

        var view:View = binding.root

        var new_task : FloatingActionButton = view.findViewById(R.id.add_newTask)





        var db = Room.databaseBuilder(context!!,tasksDb:: class.java,"mydb").allowMainThreadQueries().build()
        viewManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recyclerView)



        db.task().getAll().observe(this, Observer {
            this.myAdapter = myAdapter(it)
            myAdapter.notifyDataSetChanged()
            recyclerView.adapter = myAdapter
            recyclerView.layoutManager = viewManager
        })









        new_task.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_displayFragment_to_addNewTask)
        }






        return view
    }




}
