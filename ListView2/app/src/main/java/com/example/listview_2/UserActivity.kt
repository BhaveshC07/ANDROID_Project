package com.example.listview_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val name=intent.getStringExtra("Name")
        val phoneNumber=intent.getStringExtra("number")
        val imageId=intent.getIntExtra("imageId",R.drawable.me)

        val nameTv=findViewById<TextView>(R.id.tv1)
        val phoneTv=findViewById<TextView>(R.id.tv2)
        val img=findViewById<CircleImageView>(R.id.profile_image)

        nameTv.text=name
        phoneTv.text=phoneNumber
        img.setImageResource(imageId)
    }
}