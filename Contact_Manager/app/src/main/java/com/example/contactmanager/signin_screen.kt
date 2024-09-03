package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signin_screen : AppCompatActivity() {

    lateinit var database1:DatabaseReference

    companion object{
        const val KEY="com.example.contactmanager.signin_screen.name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_screen)

        val signinBtn=findViewById<Button>(R.id.btnsigninn)
        val userName1=findViewById<TextInputEditText>(R.id.SIuserName)
        val pass=findViewById<TextInputEditText>(R.id.SIpass)

        signinBtn.setOnClickListener {

            val username=userName1.text.toString()
            val password=pass.text.toString()

            if(username.isNotEmpty()&&password.isNotEmpty()){
                readData(username,password)
            }else{
                Toast.makeText(this,"Please enter credentials",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(username: String, password: String) {

        database1=FirebaseDatabase.getInstance().getReference("Users")
        database1.child(username).get().addOnSuccessListener {

            if(it.exists()){
                val name=it.child("userName").value
                val intentWLC=Intent(this,add_contact::class.java)
                intentWLC.putExtra(KEY,name.toString())
                startActivity(intentWLC)
            }else{
                Toast.makeText(this,"User Not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}