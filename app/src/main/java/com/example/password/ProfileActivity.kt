package com.example.password

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var tv1 : TextView
    private lateinit var button4 :Button
    private lateinit var button6 :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerListeners()
        tv1.text = FirebaseAuth.getInstance().currentUser?.uid

    }
    private fun init(){
        button4 = findViewById(R.id.btn4)
        button6= findViewById(R.id.btn6)
        tv1 = findViewById(R.id.tv1)
    }
    private fun registerListeners(){
        button4.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        button6.setOnClickListener {
            startActivity(Intent(this, ResetpasswordActivity::class.java))

        }
    }
}