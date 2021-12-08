package com.example.password
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmailAddress:EditText
    private lateinit var editTextTextPassword:EditText
    private lateinit var btn: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerListeners()
    }
    private fun init(){
        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        btn = findViewById(R.id.btn)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

    }
    private fun registerListeners() {
        btn.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btn3.setOnClickListener{
            startActivity(Intent(this, ForgotpasswordActivity::class.java))
        }
        btn2.setOnClickListener {
            val email = editTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty~!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        gotoProfile()
                    } else {
                        Toast.makeText(this,"error!",Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
    private fun gotoProfile(){
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()

    }
}