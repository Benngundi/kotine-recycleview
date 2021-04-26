package com.example.storyhub_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_registeractivity.*


class Registeractivity : AppCompatActivity() {
    lateinit var txtusername:TextView
    lateinit var  txtuseremail:TextView
    lateinit var userpassword: TextView
    lateinit var btnsave:Button
    lateinit var ref:DatabaseReference
    lateinit var listview:ListView
    lateinit var userlist:MutableList<registeruser>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeractivity)
        ref = FirebaseDatabase.getInstance().getReference("user")
        txtusername=findViewById(R.id.inputusername)
        txtuseremail=findViewById(R.id.useremail)
        userpassword = findViewById(R.id.inputpassword)
        btnsave= findViewById(R.id.btnregister)
        userlist= mutableListOf()
        listview=findViewById(R.id.listviewuser)


        // link to new activities

        txtvhaveaccount.setOnClickListener {
            intent = Intent( this,loginactivity::class.java)
            startActivity(intent)
        }



        //credentials check

        btnregister.setOnClickListener {
            credentialscheck()
        }
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()){
                userlist.clear()
                for(h in snapshot.children){

                    val user= h.getValue((registeruser::class.java))
                userlist.add(user!!)
                }
                val adapter= Registeruseradapter(applicationContext,R.layout.users,userlist)
                    listview.adapter=adapter

            }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun credentialscheck() {
        val password:String =inputpassword.text.toString()

        val confirmpassword:String = inputconfirmpassword.text.toString()

        if ((inputusername.text.isEmpty()) or (inputusername.text.length<7)){
            inputusername.setError("Username is  invalid")
            inputusername.requestFocus()

        }
        else if ((useremail.text.isEmpty()) or (!useremail.text.contains("@"))){
            useremail.setError("email is invalid")
            useremail.requestFocus()
        }
        else if ((inputpassword.text.isEmpty()) or( inputpassword.text.length<7) ){
            inputpassword.setError("password must contain 7 characters")
            inputpassword.requestFocus()
        }

        else if ((inputconfirmpassword.text.isEmpty()) or (!confirmpassword.equals(password)))
        {
            inputconfirmpassword.setError("password is don't match")
            inputconfirmpassword.requestFocus()
        }
        else{


            val userid = ref.push().key
            val user = registeruser(userid.toString(),txtusername.text.toString(),txtuseremail.text.toString(),userpassword.text.toString())

            ref.child(userid.toString()).setValue(user).addOnCompleteListener {
                Toast.makeText(this,"Welcome to Story hub , you are now a member",Toast.LENGTH_SHORT).show()
            }
                         }
    }



}