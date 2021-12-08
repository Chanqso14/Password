package com.example.password


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetpasswordActivity : AppCompatActivity() {
    private lateinit var editTextTextPassword: TextView
    private lateinit var button7: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resetpassword)
        init()
        registerListeners()
    }

    private fun init(){
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        button7 = findViewById(R.id.btn7)
    }
    private fun registerListeners() {
        button7.setOnClickListener {
            val newpass = editTextTextPassword.text.toString()
            if (newpass.isEmpty() || newpass.length < 7) {
                Toast.makeText(this, "Incorrect new password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newpass)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}