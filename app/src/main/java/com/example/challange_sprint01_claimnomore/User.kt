package com.example.challange_sprint01_claimnomore

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)

        val inputText = intent.getStringExtra("inputText")
        textViewDisplay.text = inputText ?: "Nada recebido"
        }
    }
}