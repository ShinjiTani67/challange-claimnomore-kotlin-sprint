package com.example.challange_sprint01_claimnomore

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Button(
            onClick = {
                Intent(applicationContext, User::class.java).also {
                    startActivity(it)
                }
            }
        )
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonNavigate = findViewById<Button>(R.id.entrarfuncionario)

    }

    private fun Button(onClick: () -> Intent) {
        
    }
}