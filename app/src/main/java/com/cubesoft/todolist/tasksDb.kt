package com.cubesoft.todolist

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(ListEntity::class)],version = 1,exportSchema = false)
abstract class tasksDb : RoomDatabase()

{
    abstract fun  task() : databaseDao
}