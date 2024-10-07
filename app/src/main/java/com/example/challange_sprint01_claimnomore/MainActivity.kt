package com.example.challange_sprint01_claimnomore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entrarFuncionarioBtn: Button = findViewById (R.id.entrarFuncionarioBtn)
        entrarFuncionarioBtn.setOnClickListener() {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
        }

        val entrarDentistaBtn: Button = findViewById (R.id.entrarDentistaBtn)
        entrarDentistaBtn.setOnClickListener() {
            val intent = Intent(this, Dentist::class.java)
            startActivity(intent)
        }
    }
}