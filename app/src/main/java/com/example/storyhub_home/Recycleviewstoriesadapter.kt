package com.example.storyhub_home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView

class Recycleviewstoriesadapter(val availablestories:ArrayList<Stories>)
    :RecyclerView.Adapter<Recycleviewstoriesadapter.getview>() {


        inner class getview( itemView: View) : RecyclerView.ViewHolder(itemView) {
            val stit: TextView = itemView.findViewById(R.id.textView)
            val pics: ImageView =itemView.findViewById(R.id.imageView2)
            val author : TextView= itemView.findViewById(R.id.textView2)


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): getview {

            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.storiescardview,parent,false)

            return getview(view)

        }

        override fun onBindViewHolder(holder: getview, position: Int) {
        val story:Stories =availablestories[position]
           //holder.stit.text= story.stitle
          // holder.author.text=story.author
          // holder.pics.setImageResource(storiy.pics)
            holder.pics.setImageDrawable(story.pics().toDrawable())
            holder.stit.text = story.getstitle()
            holder.author.text = story.getauthor()
        }

        override fun getItemCount(): Int {
            return  availablestories.size
        }


}