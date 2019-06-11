package com.cubesoft.todolist


import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.cubesoft.todolist.databinding.FragmentAddNewTaskBinding

class addNewTask : Fragment()
{

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {

        var binding: FragmentAddNewTaskBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_new_task,container,false)
        var view: View = binding.root

        var ed1: EditText = view.findViewById(R.id.edt_title)
        var ed2: EditText = view.findViewById(R.id.edt_desc)
        var mm : EditText = view.findViewById(R.id.edt_mm)
        var dd : EditText = view.findViewById(R.id.edt_dd)
        var time: EditText = view.findViewById(R.id.edt_time)
        var add_button : Button = view.findViewById(R.id.button_add)
        var db = Room.databaseBuilder(context!!,tasksDb:: class.java,"mydb").allowMainThreadQueries().build()

        add_button.setOnClickListener {

            var Title: String = ed1.text.toString()
            var Desc : String = ed2.text.toString()
            var Date : String = "@"+dd.text.toString() + " / "+ mm.text.toString()
            var Time : String = "@"+time.text.toString()


            if (Title =="" && Desc ==""){
                Toast.makeText(context,"Please don't be lazy, type something :)", Toast.LENGTH_LONG).show()
            }

            else {

                var ob: ListEntity = ListEntity()

                ob.title = Title
                ob.desc = Desc
                ob.date = Date
                ob.time  = Time

                db.task().insert(ob)
                Toast.makeText(context, "Successfully added the task", Toast.LENGTH_SHORT).show()
                ed1.setText("")
                ed2.setText("")
                dd.setText("")
                mm.setText("")
                time.setText("")

            }

        }

        add_button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.background.setColorFilter(-0x1f0b8adf, PorterDuff.Mode.SRC_ATOP)
                    v.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    v.background.clearColorFilter()
                    v.invalidate()
                }
            }
            false
        }





        return view

    }



}
