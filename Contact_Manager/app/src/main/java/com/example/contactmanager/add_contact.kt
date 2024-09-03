package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class add_contact : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var databaseReference1: DatabaseReference

    companion object {
        const val KEY1 = "com.example.contactmanager.add_contact.name"
        const val KEY2 = "com.example.contactmanager.add_contact.number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val userName = intent.getStringExtra(signin_screen.KEY)


        val welcomeText = findViewById<TextView>(R.id.tvWlc)

        welcomeText.text = "Hello $userName"

        val savebtn = findViewById<Button>(R.id.btnsave)
        val wlcNAME = findViewById<TextInputEditText>(R.id.wlcName)
        val wlcNO = findViewById<TextInputEditText>(R.id.wlcNo)
        val list = findViewById<TextView>(R.id.tvList)

        savebtn.setOnClickListener {

            val name = wlcNAME.text.toString()
            val number = wlcNO.text.toString()

            val contact = contacts(name, number)
            databaseReference = FirebaseDatabase.getInstance().getReference("Contacts")
            databaseReference.child(number).setValue(contact).addOnSuccessListener {
                    Toast.makeText(this, "Contact Saved", Toast.LENGTH_SHORT).show()
                    wlcNAME.text?.clear()
                    wlcNO.text?.clear()
                }.addOnSuccessListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }

            list.setOnClickListener {
                databaseReference = FirebaseDatabase.getInstance().getReference("Contacts")
                databaseReference.child(wlcNO.toString()).get().addOnSuccessListener {
                    if (it.exists()) {
                        val name = it.child("name").value
                        val number = it.child("number").value
                            val intentWLC = Intent(this, contact_list::class.java)
                            intentWLC.putExtra(add_contact.KEY1, name.toString())
                            intentWLC.putExtra(add_contact.KEY2, number.toString())
                            startActivity(intentWLC)
                    } else {
                        Toast.makeText(this, "User Not exist", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }