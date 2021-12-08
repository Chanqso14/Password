package com.example.password

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress2: EditText
    private lateinit var editTextTextPassword2: EditText
    private lateinit var editTextTextPassword3: EditText
    private lateinit var button5: Button
    private var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        registerListeners()
    }

    private fun init() {
        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2)
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2)
        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3)

        button5 = findViewById(R.id.btn5)
    }

    private fun registerListeners() {
        button5.setOnClickListener {
            val email = editTextTextEmailAddress2.text.toString()
            val password = editTextTextPassword2.text.toString()
            val password2 = editTextTextPassword3.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty~!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password == password2 && password.length > 9 && password.contains("[0-9]".toRegex()) && password.contains("[a-z]".toRegex()) && email.matches(emailPattern.toRegex()) ){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}




