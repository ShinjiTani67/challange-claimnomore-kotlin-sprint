package com.example.challange_sprint01_claimnomore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonNavigate = findViewById<Button>(R.id.entrarfuncionario)

    }
    buttonNavigate.setOnClickListener {
        val inputText = editTextInput.text.toString()
        val intent = Intent(this, User::class.java)
        intent.putExtra("inputText", inputText)
        startActivity(intent)

    }
}