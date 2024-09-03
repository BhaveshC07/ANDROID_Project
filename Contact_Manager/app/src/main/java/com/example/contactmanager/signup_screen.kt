package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signup_screen : AppCompatActivity() {

    lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_screen)

        val signUpbtn=findViewById<Button>(R.id.btnnsignup)
        val userName=findViewById<EditText>(R.id.suUsername)
        val email=findViewById<EditText>(R.id.suEmail)
        val pass=findViewById<EditText>(R.id.suPass)
        val signINbtn=findViewById<TextView>(R.id.SI1)

        signUpbtn.setOnClickListener {
            val Name=userName.text.toString()
            val mail=email.text.toString()
            val passs=pass.text.toString()

            val user=user(Name,mail,passs)
            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(Name).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()
                userName.text?.clear()
                email.text?.clear()
                pass.text?.clear()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
        signINbtn.setOnClickListener {
            val intent=Intent(this,signin_screen::class.java)
            startActivity(intent)
        }
    }
}