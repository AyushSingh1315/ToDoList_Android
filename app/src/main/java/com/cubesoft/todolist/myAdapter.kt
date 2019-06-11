package com.cubesoft.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class myAdapter(var tasks: List<ListEntity>) : RecyclerView.Adapter<myAdapter.customAdapter>()
{


    lateinit var p :Context
    lateinit var db: tasksDb
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customAdapter
    {
        var contex = parent.context
        p = contex
        var v : View = LayoutInflater.from(contex).inflate(R.layout.custom_view,parent,false)
        var holder = customAdapter(v)
        db = Room.databaseBuilder(p,tasksDb:: class.java,"mydb").allowMainThreadQueries().build()

        return holder

    }

    override fun getItemCount(): Int
    {
        return tasks.size
    }

    override fun onBindViewHolder(holder: customAdapter, position: Int)
    {


        holder.text_title.text = tasks[position].title
        holder.text_desc.text = tasks[position].desc
        holder.text_date.text = tasks[position].date
        holder.text_time.text = tasks[position].time


        holder.itemView.setOnClickListener {


                holder.delete.setImageResource(R.drawable.delete)

                holder.delete.setOnClickListener{
                    var ob: ListEntity = ListEntity()
                    ob.title= tasks[position].title
                    ob.desc = tasks[position].desc
                    ob.id = tasks[position].id
                    db.task().deleteSpecific(ob)
                    Toast.makeText(p,"Item Deleted",Toast.LENGTH_SHORT).show()

                    Navigation.findNavController(it).navigate(R.id.action_displayFragment_to_taskCompletion)

                }




        }



//        holder.itemView.setOnClickListener{
//            Toast.makeText(p,"Click at $position ",Toast.LENGTH_SHORT).show()
//        }



    }


    class customAdapter(itemView: View): RecyclerView.ViewHolder(itemView)
    {


        var text_title: TextView = itemView.findViewById(R.id.textview_title)
        var text_desc: TextView = itemView.findViewById(R.id.textview_desc)
        var delete:ImageView = itemView.findViewById(R.id.delete_button)

        var text_date : TextView = itemView.findViewById(R.id.textview_date)
        var text_time: TextView = itemView.findViewById(R.id.textview_time)







    }




}


