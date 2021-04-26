package com.example.storyhub_home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnmember.setOnClickListener {
            intent = Intent(this, loginactivity::class.java)
            startActivity(intent)
        }
        btnnotmember.setOnClickListener {
            intent = Intent(this, Registeractivity::class.java)
            startActivity(intent)
        }
        btnstories.setOnClickListener {
            intent = Intent(this, Displaystoriesactivity::class.java)
            startActivity(intent)
        }

    }
}