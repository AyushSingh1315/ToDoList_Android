package com.cubesoft.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window

class settings : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}
