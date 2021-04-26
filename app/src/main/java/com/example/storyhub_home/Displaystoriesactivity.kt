package com.example.storyhub_home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.displaystories.*

class Displaystoriesactivity : AppCompatActivity(){
        override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.displaystories)



        val story  = ArrayList<Stories> ()
        story.add(Stories("James macharia","The guy He is",pics = R.drawable.bb))
        story.add(Stories("Kenneth Ogwayo","The guy He is",pics = R.drawable.benprofilepic))
        story.add(Stories("Omondi Onyango","The guy He is",pics = R.drawable.ic_google))
        story.add(Stories("Wanjohi Kinyua","The guy He is",pics = R.drawable.ic_facebook))
        story.add(Stories("sheikl Nadhimin","The guy He is",pics = R.drawable.benprofilepic))
        story.add(Stories("Katana Ngala","The guy He is",pics = R.drawable.ic_android))
        story.add(Stories("ken Mutua","The guy He is",pics = R.drawable.ic_android))
        story.add(Stories("Joyce omanaga","The guy He is",pics = R.drawable.ic_android))
        story.add(Stories("william mutune","The guy He is",pics = R.drawable.ic_android))
        story.add(Stories("Janshon Muli","The guy He is",pics = R.drawable.ic_android))
        story.add(Stories("Wilington Onyango","The guy He is",pics = R.drawable.ic_android))
        story.add(Stories("Domotila maina","The guy He is",pics = R.drawable.ic_android))

                val recyclerViewId:RecyclerView = findViewById(R.id.recycleviewavailabstorires)
                val RecyclerViewstoriesAdapter:Recycleviewstoriesadapter = Recycleviewstoriesadapter(story)
                recyclerViewId.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewId.adapter =RecyclerViewstoriesAdapter
    }
}