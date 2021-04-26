package com.example.storyhub_home

data class Stories constructor( private val author:String,private val stitle:String,private val pics:Int){
   fun getauthor():String{
       return author
   }
    fun getstitle():String{
        return stitle
    }
    fun pics():Int{
        return pics
    }
}
