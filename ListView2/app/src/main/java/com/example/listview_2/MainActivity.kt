package com.example.listview_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import java.sql.Array

class MainActivity : AppCompatActivity() {

    lateinit var userArray:ArrayList<user>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name= arrayOf("Bhavesh Charde","Sachin","Nilima","Omkar","Pranay")
        val lastmsg= arrayOf("hey","Good Morning","Nice","Scholorship","Mast")
        val lastseen = arrayOf("6:25am ","5:25am ","3:25am ","2:25am ","1:25am ")
        val phone= arrayOf("7558756068","1234567890","20314568798","584856225","9876543210")
        val imageid= intArrayOf(R.drawable.me,R.drawable.profile1,R.drawable.profile2,R.drawable.profile3,R.drawable.profile4)

        userArray=ArrayList()

        for(eachIndex in name.indices){
            val users=user(name[eachIndex],lastmsg[eachIndex],lastseen[eachIndex],phone[eachIndex],
                imageid[eachIndex])

            userArray.add(users)
        }

        val listView=findViewById<ListView>(R.id.listview1)
        listView.isClickable=true;
        listView.adapter=MyAdapter(this, userArray)

        listView.setOnItemClickListener { parent, view, position, id ->
            val userName=name[position]
            val userPhone=phone[position]
            val imgId=imageid[position]


           val i=Intent(this,UserActivity::class.java)
            i.putExtra("Name", userName)
            i.putExtra("number",userPhone)
            i.putExtra("imageId", imgId)

            startActivity(i);
        }
    }
}