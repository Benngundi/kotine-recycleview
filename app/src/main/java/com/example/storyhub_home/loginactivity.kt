package com.example.storyhub_home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class loginactivity : AppCompatActivity() {

    override protected
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn = findViewById<TextView>(R.id.textviewsignup)
        btn.setOnClickListener {
            val intent = Intent(this,Registeractivity::class.java)
            startActivity(intent)
        }
        btnmap.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            if (useremail.text.isEmpty() or  !useremail.text.contains("@")){
                useremail.setError("invalid email address")
                useremail.requestFocus()
            }
            else if ( inputusername.text.isEmpty() or (inputusername.text.length<7))
            {
                inputusername.setError("password must contain 7 charactes")
                inputusername.requestFocus()
            }
            else
            {
                Toast.makeText(this,"Call login method", Toast.LENGTH_SHORT).show()
            }
        }

    }
}