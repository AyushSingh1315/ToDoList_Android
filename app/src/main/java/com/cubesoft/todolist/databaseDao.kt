package com.cubesoft.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*


@Dao
interface databaseDao

{
    @Insert
    fun insert(task : ListEntity)

    @Update
    fun update(task: ListEntity)


    @Query("select * from tasks ")
    fun getAll(): LiveData<List<ListEntity>>


    @Query("delete from tasks where id = :id")
    fun delete(id: Long)

    @Delete
    fun deleteSpecific(default: ListEntity)


}