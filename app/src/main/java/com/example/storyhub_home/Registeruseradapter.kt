package com.example.storyhub_home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Registeruseradapter( val mCtx:Context,val layoutResId:Int, val Userlist:List<registeruser>) :ArrayAdapter<registeruser>(mCtx,layoutResId,
    Userlist)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view:View= layoutInflater.inflate(layoutResId,null)
    val textViewname =view.findViewById<TextView>(R.id.textViewname)
    val user = Userlist[position]
        textViewname.text= user.username
        return view
    }
}