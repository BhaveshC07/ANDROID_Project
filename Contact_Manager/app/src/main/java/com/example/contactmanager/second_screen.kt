package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class second_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val signin=findViewById<Button>(R.id.btnSignIn)
        val signup=findViewById<Button>(R.id.btnSignup)

        signin.setOnClickListener {
            val intent= Intent(this,signin_screen::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener {
            val intent= Intent(this,signup_screen::class.java)
            startActivity(intent)
        }
    }
}