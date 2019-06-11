package com.cubesoft.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()

//        var settings: ImageView = findViewById(R.id.setting)
//
//        settings.setOnClickListener {
//            var I :Intent = Intent(this,settings::class.java)
//
//            startActivity(I)
//
//        }




        setContentView(R.layout.activity_main)



    }


    fun settings(veiw :View)
    {

        var I :Intent = Intent(this,settings::class.java)
           startActivity(I)

    }
}
