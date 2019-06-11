package com.cubesoft.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
class ListEntity(

    @PrimaryKey(autoGenerate = true)
    var id :Long = 0L,

    @ColumnInfo(name = "title")
    var title:String = "",

    @ColumnInfo(name = "desc")
    var desc:String = "",

    @ColumnInfo(name="date")
    var date:String = "",

    @ColumnInfo(name="time")
    var time: String = ""


)